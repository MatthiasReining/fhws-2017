package com.fhws.javaee.presentation.showcase.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@Remote(ComplexCalculationBeanRemote.class)
@WebService
public class ComplexCalculationBean implements ComplexCalculationBeanRemote, ComplexCalculationBeanLocal {

    @Override
    public float calc(int in) {
        System.out.println("Calculation on server with input: " + in);
        return 42*in;
    }
}
