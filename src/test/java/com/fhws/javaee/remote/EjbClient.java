package com.fhws.javaee.remote;

import com.fhws.javaee.presentation.showcase.ejb.ComplexCalculationBeanRemote;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbClient {

    public static void main(String... args) throws NamingException {
        ComplexCalculationBeanRemote ccbr = lookupRemoteStatelessComplexCalculator();
        float result = ccbr.calc(1234);
        System.out.println("result: " + result);
    }
    
    static ComplexCalculationBeanRemote lookupRemoteStatelessComplexCalculator() throws NamingException {
        Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        
        return (ComplexCalculationBeanRemote) context.lookup("ejb:/fhws/ComplexCalculationBean!com.fhws.javaee.presentation.showcase.ejb.ComplexCalculationBeanRemote");
        
        
    }
}
