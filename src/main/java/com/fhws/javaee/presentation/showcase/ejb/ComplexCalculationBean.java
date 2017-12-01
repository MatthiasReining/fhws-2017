package com.fhws.javaee.presentation.showcase.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(ComplexCalculationBeanRemote.class)
public class ComplexCalculationBean implements ComplexCalculationBeanRemote, ComplexCalculationBeanLocal {

    @Override
    public float calc(int in) {
        System.out.println("Calculation on server with input: " + in);
        return 42*in;
    }
}
