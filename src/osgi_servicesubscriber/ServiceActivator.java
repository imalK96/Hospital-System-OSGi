package osgi_servicesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.service.ServicePublish;

public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		
		System.out.println(Constants.HEADER);
		System.out.println(Constants.TYPE_PROMPT);
		String type = input.nextLine().toUpperCase();
		
		System.out.println(Constants.DISTANCE_PROMPT);
		int distance = input.nextInt();
		
		System.out.println(servicePublish.publishService(type,distance));
		System.out.println(Constants.FOOTER);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("From ServiceActivator: Good Bye");
		context.ungetService(serviceReference);
		}

}
