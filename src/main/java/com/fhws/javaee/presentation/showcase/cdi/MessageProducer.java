/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.cdi;

import java.util.Date;
import javax.enterprise.inject.Produces;

public class MessageProducer {

    @Produces @InjectTest
    public Message produceMessage() {
        Message m = new Message();
        m.setMessage("produced by Message Producer at " + new Date());
        return m;
    }
}
