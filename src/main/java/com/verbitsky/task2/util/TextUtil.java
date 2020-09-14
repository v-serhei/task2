package com.verbitsky.task2.util;

import com.verbitsky.task2.comporator.TextComponentComparator;
import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;
import com.verbitsky.task2.exception.SimpleCompositException;
import com.verbitsky.task2.parser.ExpressionParser;
import com.verbitsky.task2.parser.PartParser;
import com.verbitsky.task2.parser.impl.ExpressionParserImpl;
import com.verbitsky.task2.parser.impl.ParagraphParser;
import com.verbitsky.task2.parser.impl.SentenceParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextUtil {
    private static final ExpressionParser mathParser = ExpressionParserImpl.getInstance();
    private static final String FRACTIONAL_PART = "\\.";
    private static final String EMPTY_SYMBOL = ",";
    private static Logger logger = LogManager.getLogger();

    private TextUtil() {
    }

    public static String replaceArithmeticExpressionWithValue(String text, Long i, Long j) {
        List<String> mathExpressions = mathParser.parseMathExpressions(text);
        for (String expression : mathExpressions) {
            try {
                String expressionValue = MathExpressionCalculator.CalculateMathExpression(expression, i, j);
                expressionValue = expressionValue.replaceAll(FRACTIONAL_PART, EMPTY_SYMBOL);
                text = text.replace(expression, expressionValue);
            } catch (SimpleCompositException e) {
                logger.log(Level.WARN, e);
            }
        }
        return text;
    }

    public static List<TextComponent> sortTextByParagraphsSentenceCount (String text) {
        PartParser parser = ParagraphParser.getInstance();
        TextComponent components = parser.parse(text);
        List<TextComponent> paragraphs = new ArrayList<>();
        for (TextComponent component : components.getChildList()) {
            if (component.getComponentType() == TextComponentType.PARAGRAPH) {
                paragraphs.add(component);
            }
        }
        paragraphs.sort(TextComponentComparator.SENTENCE_COUNT);
        return paragraphs;
    }

    public static List<TextComponent> sortTextBySentenceLexemesLength (String text) {
        PartParser parser = SentenceParser.getInstance();
        TextComponent components = parser.parse(text);
        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent component : components.getChildList()) {
            if (component.getComponentType() == TextComponentType.SENTENCE) {
                sentences.add(component);
            }
        }
        sentences.sort(TextComponentComparator.LEXEME_LENGTH);
        return sentences;
    }

    public static List<TextComponent> sortTextBySentenceWordsLength (String text) {
        PartParser parser = SentenceParser.getInstance();
        TextComponent components = parser.parse(text);
        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent component : components.getChildList()) {
            if (component.getComponentType() == TextComponentType.SENTENCE) {
                sentences.add(component);
            }
        }
        sentences.sort(TextComponentComparator.WORD_LENGTH);
        return sentences;
    }
}
