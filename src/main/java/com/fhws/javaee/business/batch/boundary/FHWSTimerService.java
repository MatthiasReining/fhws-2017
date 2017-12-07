package com.fhws.javaee.business.batch.boundary;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class FHWSTimerService{ 

    @Schedule(second = "1", minute = "*/10", hour = "*")
    public void print() {
        System.out.println("Now, it's " + new Date());
    }
    
}
