package cr.prodigious.aem.activator;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

@Component(immediate = true, label = "Prodigious activator")
public class Activator implements BundleActivator {

	@Activate
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting Prodigious Bundle");
	}
	
	@Deactivate
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Prodigious Bundle");
	}

}
