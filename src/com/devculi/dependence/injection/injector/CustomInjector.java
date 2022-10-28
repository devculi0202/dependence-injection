package com.devculi.dependence.injection.injector;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.devculi.dependence.injection.utils.ClassLoaderUtil;

/**
 * 1. Scan all the clients under root package and all sub packages. 
 * 2. Create instance of client class.
 * 3. Scan all services using in the client 
 * 4. Scan all services that declared inside the service itselt 
 * 5. Create instance for each service and return by step 3 and step 4. 
 * 6. Autowire: inject each service with instance created. 
 * 7. Create Map all the client classes.
 * 8.Expose the API to getBean/getService 
 * 9.Validation if ... 
 * 10. Handle Qualifier
 */
/**
 * Who is the client? 
 * The client who is invokes the services.
 */
public class CustomInjector {
    
    private CustomInjector() {}
    
    public static void startApplication(Class<?> mainClass) throws IOException, ClassNotFoundException {
        List<Class<?>> clientClasses = getAllClients(mainClass);
//        instanceAllClientClasses(clientClasses);
//        clientClasses.stream().forEach(clientClass -> {
//            getServicesByClientClass(clientClass);
//            
//        });
//        injectServiceInstanceToClientByAutowiring();
        
    }
    
    private  static List<Class<?>> getAllClients(Class<?> mainClass) throws IOException, ClassNotFoundException {
        return ClassLoaderUtil.getClasses(mainClass.getPackageName());
    }
    
    
    private static void instanceAllClientClasses(List<Class<?>> allClientClasses) {  
    }
    
    private static List<Class<?>> getServicesByClientClass(Class<?> clientClass) {
        return null;
    }
    
    
    private static Object instanceService(Class<?> serviceClass) {
        return new Object();
    }
    
    private static void injectServiceInstanceToClientByAutowiring() {
    }

}

