package com.verbitsky.task2.parser.impl;

import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;
import com.verbitsky.task2.composite.impl.TextComponentImpl;
import com.verbitsky.task2.parser.PartParser;

public class LexemeParser implements PartParser {
    private static final String LEXEME_DELIMITER = "[ ]+";
    private static final LexemeParser INSTANCE = new LexemeParser();

    private LexemeParser() {
    }

    public static LexemeParser getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String line) {
        TextComponent sentence = new TextComponentImpl(TextComponentType.SENTENCE);
        String[] lexemes = line.split(LEXEME_DELIMITER);
        for (String element : lexemes) {
            TextComponent lexeme = SymbolParser.getInstance().parse(element);
            sentence.add(lexeme);
        }
        return sentence;
    }
}
