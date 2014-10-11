package cr.prodigious.aem.impl;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.framework.Constants;

import cr.prodigious.aem.HelloService;

/**
 * One implementation of the {@link HelloService}. Note that
 * the repository is injected, not retrieved.
 */
@Service
@Component(label = "Prodigious Hello Service")
@Properties({
	@Property(name = Constants.SERVICE_DESCRIPTION, value = "Our first service."),
	@Property(name = Constants.SERVICE_VENDOR, value = "Prodigious"),
	@Property(name = "process.label", value = "Hello Service") })
public class HelloServiceImpl implements HelloService {
    
    @Reference
    private SlingRepository repository;

    public String getRepositoryName() {
        return repository.getDescriptor(Repository.REP_NAME_DESC);
    }

}
