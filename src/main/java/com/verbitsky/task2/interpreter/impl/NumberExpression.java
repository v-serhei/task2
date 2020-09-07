package com.verbitsky.task2.interpreter.impl;

import com.verbitsky.task2.interpreter.CalcExpression;

//Terminal expression
public class NumberExpression implements CalcExpression {
    private double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double interpret(CalcExpression expression) {
        return value;
    }
}
