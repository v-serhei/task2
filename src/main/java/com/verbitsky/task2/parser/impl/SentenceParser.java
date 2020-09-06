package com.verbitsky.task2.parser.impl;

import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;
import com.verbitsky.task2.composite.impl.TextComponentImpl;
import com.verbitsky.task2.parser.PartParser;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements PartParser {
    private static final String SENTENCE_DELIMITER = "[\\.]+|[\\?!]";
    private static final SentenceParser INSTANCE = new SentenceParser();

    private SentenceParser() {
    }

    public static SentenceParser getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String line) {
        Queue<String> delimiters = getDelimitersFromParagraph(line);
        TextComponent paragraph = new TextComponentImpl(TextComponentType.PARAGRAPH);
        String[] sentencesArray = line.split(SENTENCE_DELIMITER);
        for (String element : sentencesArray) {
            String delimiter = delimiters.poll();
            if (delimiter != null) {
                element = element.concat(delimiter);
            }
            TextComponent sentence = LexemeParser.getINSTANCE().parse(element);
            paragraph.add(sentence);
        }
        return paragraph;
    }

    private Queue<String> getDelimitersFromParagraph(String line) {
        Pattern pattern = Pattern.compile(SENTENCE_DELIMITER);
        Matcher matcher = pattern.matcher(line);
        Queue<String> result = new LinkedList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }
}
