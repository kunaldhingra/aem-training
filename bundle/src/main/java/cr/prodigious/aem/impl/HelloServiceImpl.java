package cr.prodigious.aem.impl;

import java.util.Map;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
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
@Component(label = "Prodigious Hello Service", immediate = true, metatype = true)
@Properties({
	@Property(name = Constants.SERVICE_DESCRIPTION, value = "Our first service."),
	@Property(name = Constants.SERVICE_VENDOR, value = "Prodigious"),
	@Property(name = "process.label", value = "Hello Service", propertyPrivate = true) })
public class HelloServiceImpl implements HelloService {
    
	private static final String DEFAULT_GREETING = "Hey you!!";
	
	@Property(label = "Greeting", description = "Type the greeting you want to say", value = DEFAULT_GREETING)
	private static final String GREETING = "helloservice.greeting";
	
    @Reference
    private SlingRepository repository;
    
    private String greeting;

    public String getRepositoryName() {
        return greeting + " " + repository.getDescriptor(Repository.REP_NAME_DESC);
    }
    
    @Activate
	private void activate(final Map<String, Object> props) {
    	setGreeting(props);
	}

	@Modified
	private void modified(final Map<String, Object> props) {
		setGreeting(props);
	}

    public void setGreeting(Map<String, Object> props) {
    	this.greeting = (String) props.get(GREETING);
    }
}
