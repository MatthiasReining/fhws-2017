/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.cdi;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class EJBSingleton {
    
    
    @Inject
    Payload payload;
    
    public void exec() {
        System.out.println("exec: " + payload + "  -> " + this);
    }
}
