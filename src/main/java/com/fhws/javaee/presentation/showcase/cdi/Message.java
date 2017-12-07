/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.cdi;

import com.fhws.javaee.business.log.boundary.LogService;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

//@Dependent
//@RequestScoped
//@SessionScoped
public class Message implements Serializable {

    private static int counter = 0;
    private String message;

    @Inject
    LogService ls;

    @PostConstruct
    public void init() {
        counter++;
        message = "M " + counter + " " + new Date();
        System.out.println("in Message#init (@PostConstruct) (count: " + counter + ")");

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" + "counter=" + counter + ", message=" + message + '}';
    }

    void print(PrintWriter pw) {
        pw.println(message);
        ls.log(message);
    }

}
