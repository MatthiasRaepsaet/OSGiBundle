package myBundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

/**
 * Created by Matthias on 22/08/2017.
 */
public class Activator implements BundleActivator, ServiceListener {
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("starting to listen for events.");
        bundleContext.addServiceListener(this);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("stopped listening for events.");
        bundleContext.removeServiceListener(this);
    }

    public void serviceChanged(ServiceEvent serviceEvent) {
        String[] objectClass = (String[]) serviceEvent.getServiceReference().getProperty("objectClass");

        if(serviceEvent.getType() == ServiceEvent.REGISTERED){
            System.out.println(objectClass[0] + " registered");

        } else if (serviceEvent.getType() == serviceEvent.UNREGISTERING){
            System.out.println(objectClass[0] + " unregistering");

        } else if (serviceEvent.getType() ==serviceEvent.MODIFIED){
            System.out.println(objectClass[0] + " modified");
        }
    }
}
