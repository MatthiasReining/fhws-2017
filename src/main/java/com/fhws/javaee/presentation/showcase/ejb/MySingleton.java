/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.ejb;

public class MySingleton {

    private static MySingleton instance;
    private MySingleton() {
    }
    
    public synchronized static MySingleton getIntance() {
        if (instance == null)
            instance = new MySingleton();
        return instance;
    }
    
}
