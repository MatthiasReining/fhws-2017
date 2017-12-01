package com.fhws.javaee.remote;

import com.fhws.javaee.presentation.showcase.ejb.ComplexCalculationBeanRemote;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbClient {

    public static void main(String... args) throws NamingException {
        // Let's lookup the remote stateless calculator

        ComplexCalculationBeanRemote ccbr = lookupRemoteStatelessComplexCalculator();
        float result = ccbr.calc(1234);
        System.out.println("result: " + result);
    }

    /**
     * Looks up and returns the proxy to remote stateless calculator bean
     *
     * @return
     * @throws NamingException
     */
    static ComplexCalculationBeanRemote lookupRemoteStatelessComplexCalculator() throws NamingException {
        Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
        //
        // <appName> The application name is the name of the EAR that the EJB is deployed in
        // (without the .ear). If the EJB JAR is not deployed in an EAR then this is
        // blank. The app name can also be specified in the EAR's application.xml
        //
        // <moduleName> By the default the module name is the name of the EJB JAR file (without the
        // .jar suffix). The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : WildFly allows each deployment to have an (optional) distinct name.
        // This example does not use this so leave it blank.
        //
        // <beanName> : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface. Must include
        // the whole package name.
        // let's do the lookup
        return (ComplexCalculationBeanRemote) context.lookup("ejb:/fhws/ComplexCalculationBean!com.fhws.javaee.presentation.showcase.ejb.ComplexCalculationBeanRemote");

    }
}
