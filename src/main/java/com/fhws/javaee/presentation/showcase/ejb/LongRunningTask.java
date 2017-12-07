/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.ejb;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class LongRunningTask {
    
    
    @Asynchronous
    public Future<String> run(String message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LongRunningTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        message = "...message: " + message; 
        
        System.out.println("in LongRunnningTask: " + message);
        
        return new AsyncResult<>(message);
        
    }
}
