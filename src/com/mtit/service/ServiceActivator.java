package com.mtit.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
	
	ServiceRegistration publishServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("From ServiceActivator: Publisher started!");
		
		ServicePublish publisherService = new ServicePublishImpl();
		
		//Register service 
		publishServiceRegistration = context.registerService(ServicePublish.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("From ServiceActivator: Publisher Stopped");
		//TODO unregister service
		publishServiceRegistration.unregister();
	}

}
