package com.verbitsky.task2.parser.impl;

import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;
import com.verbitsky.task2.composite.impl.TextComponentImpl;
import com.verbitsky.task2.parser.PartParser;

public class ParagraphParser implements PartParser {

    public static final String PARAGRAPH_DELIMITER = "\n";

    @Override
    public TextComponent parse(String line) {
        TextComponent text = new TextComponentImpl(TextComponentType.TEXT);
        String[] paragraphs = line.split(PARAGRAPH_DELIMITER);
        for (String element : paragraphs) {
            TextComponent paragraph = SentenceParser.getINSTANCE().parse(element);
            text.add(paragraph);
        }
        return text;
    }
}
