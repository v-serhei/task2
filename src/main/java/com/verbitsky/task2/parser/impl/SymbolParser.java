package com.verbitsky.task2.parser.impl;

import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;
import com.verbitsky.task2.composite.impl.Letter;
import com.verbitsky.task2.composite.impl.SpecialSymbol;
import com.verbitsky.task2.composite.impl.TextComponentImpl;
import com.verbitsky.task2.parser.PartParser;

public class SymbolParser implements PartParser {
    private static final SymbolParser INSTANCE = new SymbolParser();

    private SymbolParser() {
    }

    public static SymbolParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String line) {
        TextComponent lexeme = new TextComponentImpl(TextComponentType.LEXEME);
        char[] chars = line.toCharArray();
        for (char symbol : chars) {
            if (Character.isLetterOrDigit(symbol)) {
                lexeme.add(new Letter(symbol));
            } else {
                lexeme.add(new SpecialSymbol(symbol));
            }
        }
        return lexeme;
    }
}

