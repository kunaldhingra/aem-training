package cr.prodigious.aem.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import com.day.cq.wcm.api.Page;

import cr.prodigious.aem.HelloService;

@SlingServlet(metatype = false, generateComponent = true, paths = "/services/prodigious/training-servlet")
public class TraingServlet extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8776569386442433683L;

	@Reference
	private HelloService helloService;
	
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter pw = response.getWriter();
		String result = "{}";
		String pathParam = request.getParameter("path");
		
		ResourceResolver resolver = request.getResourceResolver();
		Resource pageResource = resolver.getResource(pathParam);
		
		if (pageResource != null) {
			Page page = pageResource.adaptTo(Page.class);
			StringBuilder builder = new StringBuilder();
			
			builder.append("{ result: 'ok', page: { title: '");
			builder.append(page.getTitle());
			builder.append("', path: '");
			builder.append(page.getPath());
			builder.append(".html', parent:'");
			builder.append(page.getParent().getPath());
			builder.append(".html' }, repository: '");
			builder.append(helloService.getRepositoryName());
			builder.append("'}");
			
			result = builder.toString();
		}
		
		response.setContentType("application/json");
		pw.print(result);
		
		pw.flush();
		pw.close();
	}
}
