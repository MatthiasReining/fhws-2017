package com.fhws.javaee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComplexCalculationTest {

    static ComplexCalculation cut;

    @BeforeClass
    public static void init() {
        cut = new ComplexCalculation();
    }

    @Test
    public void shouldRun1() {
        double expected = 1.0;
        double actual = cut.calc(1);
        double delta = 0.1;

        Assert.assertEquals(expected, actual, delta);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeToComplex() {
        cut.calc(2000);
    }

    @Test
    public void shouldBeInfinite() {
        double actual = cut.calc(0);
        
        Assert.assertTrue(Double.isInfinite(actual));
    }

    @Test
    public void shouldRunSuperComplex() {
        double expected = 1.0;
        double actual = cut.calcSuperComplex(2.5);
        double delta = 0.000000000000000000000000000001;

        Assert.assertEquals(expected, actual, delta);
    }
}
