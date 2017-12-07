/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.performance.boundary;

import com.fhws.javaee.presentation.LoginController;
import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Keep of time is working with {@link LoginController#login() }.
 * Bspw. {@link String#chars() }
 * @author matthias
 */
@Interceptor @KeeperOfTime
public class KeeperOfTimeInterceptor implements Serializable {
    
    @AroundInvoke
    public Object logTime(InvocationContext ic) throws Exception {
        long startTime = System.currentTimeMillis();
        
        Object result = ic.proceed();
        
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Execution of method " + ic.getTarget().getClass().getName() + "#" + ic.getMethod().getName() + " took " + duration + "ms" );
        
        return result;
    }
}
