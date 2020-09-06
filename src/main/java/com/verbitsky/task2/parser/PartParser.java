package com.verbitsky.task2.parser;

import com.verbitsky.task2.composite.TextComponent;

public interface PartParser {
    TextComponent parse(String line);
}
