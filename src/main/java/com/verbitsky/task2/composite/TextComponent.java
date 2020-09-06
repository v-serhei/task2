package com.verbitsky.task2.composite;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getChild(int index);

    TextComponentType getComponentType();
}
