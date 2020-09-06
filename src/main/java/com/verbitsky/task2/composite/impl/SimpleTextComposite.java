package com.verbitsky.task2.composite.impl;

import com.verbitsky.task2.composite.SimpleTextComponent;
import com.verbitsky.task2.composite.SimpleTextComponentType;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextComposite implements SimpleTextComponent {
    public static final String LEXEME_DELIMITER = " ";
    public static final String PARAGRAPH_DELIMITER = "\n\t";
    private SimpleTextComponentType componentType;
    private List<SimpleTextComponent> componentList;

    public SimpleTextComposite(SimpleTextComponentType componentType) {
        this.componentType = componentType;
        componentList = new ArrayList<>();
    }

    @Override
    public void add(SimpleTextComponent component) {
        if (component != null) {
            componentList.add(component);
        }
    }

    @Override
    public void remove(SimpleTextComponent component) {
        componentList.remove(component);
    }

    @Override
    public SimpleTextComponent getChild(int index) {
        return componentList.get(index);
    }

    @Override
    public SimpleTextComponentType getComponentType() {
        return componentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleTextComposite)) return false;
        SimpleTextComposite that = (SimpleTextComposite) o;
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
        for (SimpleTextComponent component : componentList) {
            if (SimpleTextComponentType.PARAGRAPH.equals(component.getComponentType())){
                stringBuilder.append(PARAGRAPH_DELIMITER);
            }
            if (SimpleTextComponentType.LEXEME.equals(component.getComponentType())){
                stringBuilder.append(LEXEME_DELIMITER);
            }
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }
}
