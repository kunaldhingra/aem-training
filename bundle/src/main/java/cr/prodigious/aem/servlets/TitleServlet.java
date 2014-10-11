package cr.prodigious.aem.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jcr.Node;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import cr.prodigious.aem.HelloService;

@SlingServlet(metatype = false, generateComponent = true, 
	resourceTypes = "prodigious/components/content/title",
	selectors = "list")
public class TitleServlet extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8776569386442433683L;

	@Reference
	private HelloService helloService;
	
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		Resource resource = request.getResource();
		Node node = resource.adaptTo(Node.class);
		
		PrintWriter pw = response.getWriter();
		
		try {
			String result = "<h1>";
			result += node.getProperty("title").getString();
			result += "</h1>";
			pw.write(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.flush();
		pw.close();
	}
}
