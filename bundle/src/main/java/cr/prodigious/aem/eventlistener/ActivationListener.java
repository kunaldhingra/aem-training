/**
 * Aetna Workflow Event package.
 */
package cr.prodigious.aem.eventlistener;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;

import cr.prodigious.aem.HelloService;

@Service
@Component(immediate = true, metatype = true, label = "AEM training event listener")
@Properties({
		@Property(name = Constants.SERVICE_DESCRIPTION, value = "Event handler to listen for page activations"),
		@Property(name = Constants.SERVICE_VENDOR, value = "Prodigious"),
		@Property(name = "process.label", value = "AEM training event listener", propertyPrivate = true),
		@Property(name = "event.topics", value = ReplicationAction.EVENT_TOPIC, propertyPrivate = true) })
public class ActivationListener implements EventHandler {

	@Reference
	private HelloService helloService;

	public void handleEvent(Event event) {
		ReplicationAction replicationAction = ReplicationAction
				.fromEvent(event);
		
		if (replicationAction.getType().equals(ReplicationActionType.ACTIVATE)) {
			System.out.println("Event catched for activation: " + replicationAction.getPath());
		}
	}
}
