/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.cdi;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Payload implements Serializable {

    private String data; 

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Payload{" + "data=" + data + '}';
    }

}
