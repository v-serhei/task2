package com.verbitsky.task2.composite.impl;

import com.verbitsky.task2.composite.TextComponent;
import com.verbitsky.task2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComponentImpl implements TextComponent {
    public static final String LEXEME_DELIMITER = " ";
    public static final String PARAGRAPH_DELIMITER = "\n\t";
    public static final String SENTENCE_DELIMITER = ".";
    private TextComponentType componentType;
    private List<TextComponent> componentList;

    public TextComponentImpl(TextComponentType componentType) {
        this.componentType = componentType;
        componentList = new ArrayList<>();
    }

    @Override
    public void add(TextComponent component) {
        if (component != null) {
            componentList.add(component);
        }
    }

    @Override
    public void remove(TextComponent component) {
        componentList.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return componentList.get(index);
    }

    @Override
    public TextComponentType getComponentType() {
        return componentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextComponentImpl)) return false;
        TextComponentImpl that = (TextComponentImpl) o;
        if (componentType != that.componentType) return false;
        return componentList != null ? componentList.equals(that.componentList) : that.componentList == null;
    }

    @Override
    public int hashCode() {
        int result = componentType != null ? componentType.hashCode() : 0;
        result = 31 * result + (componentList != null ? componentList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : componentList) {
            if (TextComponentType.PARAGRAPH.equals(component.getComponentType())){
                stringBuilder.append(PARAGRAPH_DELIMITER);
            }
            if (TextComponentType.LEXEME.equals(component.getComponentType())){
                stringBuilder.append(LEXEME_DELIMITER);
            }
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }
}
