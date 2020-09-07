package com.verbitsky.task2.parser.impl;

import com.verbitsky.task2.parser.ExpressionParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParserImpl implements ExpressionParser {
    private static final String OPERAND_COUNT = "(-{2})|(\\+{2})|(\\*)|(\\\\)|(\\+)|(-)";
    private static final String MATH_EXPRESSION = "(\\s)(\\(?[(i|j)\\d\\+\\-\\*\\/\\)\\(\\n\\s])+\\s";
    private static final String OPERATION_IN_BRACERS = "[(]([^()]+)[)]";
    private static final String POST_DECREMENT = "(i|j)([-]{2})";
    private static final String POST_INCREMENT = "(i|j)([+]{2})";
    private static final String PRE_DECREMENT = "([-]{2})(i|j)";
    private static final String PRE_INCREMENT = "([+]{2})(i|j)";
    private static final String MATH_OPERATION = "[\\+\\-\\*/]";



    /*
    private static final String OPERATION_PREFIX = "[-]{2}(i|j)|[+]{2}(i|j)";
    private static final String OPERATION_MUL = "([\\d]+?)([*])(-?[\\d]+?)";
    private static final String OPERATION_DIV = "(-?[\\d]+?)([*])(-?[\\d]+?)";
*/

    private static final ExpressionParserImpl INSTANCE = new ExpressionParserImpl();
    public static final String SPACES_SYMBOLS = "[\\s]{0,}|\n";

    public static ExpressionParserImpl getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public List<String> parseMathExpressions(String text) {
        Pattern pattern = Pattern.compile(MATH_EXPRESSION);
        Matcher matcher = pattern.matcher(text);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            String expr = matcher.group().trim();
            if (!expr.matches(SPACES_SYMBOLS) && expr.length() > 2) {
                result.add(expr);
            }
        }
        return result;
    }


    @Override
    public Map<String, String> parseSimpleExpression(String expression) {
        return null;
    }

    @Override
    public List<Double> parseOperands(String expression) {
        return null;
    }

    @Override
    public int parseOperandsCount(String expression) {
        Pattern pattern = Pattern.compile(OPERAND_COUNT);
        Matcher matcher = pattern.matcher(expression);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    @Override
    public String parseBracerOperation(String expression) {
        Pattern pattern = Pattern.compile(OPERATION_IN_BRACERS);
        Matcher matcher = pattern.matcher(expression);
        String res;
        if (matcher.find()) {
            res = matcher.group();
        } else {
            res = expression;
        }
        return res;
    }
}
