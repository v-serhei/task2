package com.verbitsky.task2.interpreter;

@FunctionalInterface
public interface CalcExpression {
    double interpret(CalcExpression expression);
}
