/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.log.boundary;

import com.fhws.javaee.business.news.boundary.NewsLogin;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class LoginLogger {
    
    @Inject
    LogService logService;
    
    public void loginSystemOutLogger(@Observes @NewsLogin String message) {
        System.out.println("observer: " + message);
    }
    
     public void loginDBLogger(@Observes @NewsLogin String message) {
        logService.log(message);
    }
}
