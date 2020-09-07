package com.verbitsky.task2.parser.impl;

import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;
import com.verbitsky.task2.composite.impl.TextComponentImpl;
import com.verbitsky.task2.parser.PartParser;

public class ParagraphParser implements PartParser {
    private static final String PARAGRAPH_DELIMITER = "\n\t";
    private static final ParagraphParser INSTANCE = new ParagraphParser();

    private ParagraphParser() {
    }

    public static ParagraphParser getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String line) {
        TextComponent text = new TextComponentImpl(TextComponentType.TEXT);
        String[] paragraphs = line.split(PARAGRAPH_DELIMITER);
        for (String element : paragraphs) {
            if (!element.isEmpty()) {
                TextComponent paragraph = SentenceParser.getINSTANCE().parse(element);
                text.add(paragraph);
            }
        }
        return text;
    }
}
