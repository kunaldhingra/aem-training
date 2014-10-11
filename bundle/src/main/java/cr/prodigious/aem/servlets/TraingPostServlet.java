package cr.prodigious.aem.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.day.cq.wcm.api.Page;

import cr.prodigious.aem.HelloService;

@SlingServlet(metatype = false, generateComponent = true, paths = "/services/prodigious/training-post-servlet")
public class TraingPostServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8776569386442433683L;

	@Reference
	private HelloService helloService;
	
	protected void doPost(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		String pathParam = request.getParameter("path");
		String valueParam = request.getParameter("value");
		
		ResourceResolver resolver = request.getResourceResolver();
		Resource pageResource = resolver.getResource(pathParam);
		
		if (pageResource != null) {
			Page page = pageResource.adaptTo(Page.class);
			Resource pageContentResource = page.getContentResource();
			Node pageContentNode = pageContentResource.adaptTo(Node.class);
			
			try {
				pageContentNode.setProperty("jcr:description", valueParam);
				pageContentNode.getSession().save();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(pathParam + ".html");
	}
}
