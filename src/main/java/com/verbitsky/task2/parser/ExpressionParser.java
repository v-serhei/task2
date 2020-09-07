package com.verbitsky.task2.parser;

import java.util.List;
import java.util.Map;

public interface ExpressionParser {
    List <String> parseMathExpressions (String text);

    Map<String, String> parseSimpleExpression (String expression);

    List<Double> parseOperands(String expression);

    int parseOperandsCount(String expression);

    String parseBracerOperation(String expression);
}
