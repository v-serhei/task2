package com.verbitsky.task2.composite;

public interface SimpleTextComponent {
    void add(SimpleTextComponent component);

    void remove(SimpleTextComponent component);

    SimpleTextComponent getChild(int index);

    SimpleTextComponentType getComponentType();
}
