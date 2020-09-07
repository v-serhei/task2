package com.verbitsky.task2.interpreter.impl;

import com.verbitsky.task2.interpreter.CalcExpression;

public class MulExpression implements CalcExpression {
    private CalcExpression left;
    private CalcExpression right;

    public MulExpression(CalcExpression left, CalcExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(CalcExpression expression){
        return left.interpret(expression) * right.interpret(expression);
    }
}
