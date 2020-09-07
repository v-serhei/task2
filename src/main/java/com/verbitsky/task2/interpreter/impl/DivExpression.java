package com.verbitsky.task2.interpreter.impl;

import com.verbitsky.task2.interpreter.CalcExpression;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DivExpression implements CalcExpression {
    private static Logger logger = LogManager.getLogger();
    private CalcExpression left;
    private CalcExpression right;

    public DivExpression(CalcExpression left, CalcExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(CalcExpression expression){
        double result = 0;
        try {
            result = left.interpret(expression) / right.interpret(expression);
        } catch (ArithmeticException ex) {
            logger.log(Level.ERROR, "wrong expression", ex);
        }
        return result;
    }
}
