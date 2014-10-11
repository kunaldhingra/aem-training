package cr.prodigious.aem.workflow;

import java.util.Calendar;

import javax.jcr.Node;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

@Component
@Service
@Properties({
		@Property(name = Constants.SERVICE_DESCRIPTION, value = "Prodigious custom workflow step."),
		@Property(name = Constants.SERVICE_VENDOR, value = "Prodigious"),
		@Property(name = "process.label", value = "Prodigious workflow step") })
public class ProdigiousWorkflowStep implements WorkflowProcess {

	private static final String PROP_ACTICATION_LOG = "activationLog";
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	public void execute(WorkItem workItem, WorkflowSession workflowSession,
			MetaDataMap metadataMap) throws WorkflowException {
		WorkflowData workflowData = workItem.getWorkflowData();
		String pagePath = workflowData.getPayload().toString();
		
		pagePath += "/jcr:content";

		try {
			ResourceResolver resourceResolver = resourceResolverFactory
					.getAdministrativeResourceResolver(null);
			Resource pageResource = resourceResolver.getResource(pagePath);
			Node pageNode = pageResource.adaptTo(Node.class);
			Calendar calendar = Calendar.getInstance();
			
			pageNode.setProperty(PROP_ACTICATION_LOG, "Page activated on " + calendar.getTime());
			pageNode.getSession().save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
