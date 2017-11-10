package com.fhws.javaee;

public class ComplexCalculation {

    public double calc(double x) {
        double result;
        if (x > 100) {
            result = calcSuperComplex(x);
        } else {
            result = 1l / x;
        }
        return result;
    }

    double calcSuperComplex(double x) {
        if (x > 1000) {
            throw new ArithmeticException(">1000 is not allowed!");
        }
        return 2.5 / x;
    }
}
