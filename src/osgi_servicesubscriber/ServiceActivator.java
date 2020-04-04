package osgi_servicesubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.service.ServicePublish;

public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		try {
		System.out.println(Constants.HEADER);
		System.out.println(Constants.TYPE_PROMPT);
		String type = in.readLine();
		
		System.out.println(Constants.DISTANCE_PROMPT);
		double distance = Integer.parseInt(in.readLine());
		
		System.out.println(servicePublish.publishService(type,distance));
		System.out.println(Constants.FOOTER);
		} catch (Exception e) {
			System.out.println("Please ensure all inputs are correct");
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("From ServiceActivator: Good Bye");
		context.ungetService(serviceReference);
		}

}
