package com.example.application.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.icon.FontIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@Tag("icon-input")
public class IconInput extends HorizontalLayout {
    private String icon;
    private String placeholder;
    private String type;

    public IconInput(String icon, String placeholder, String type) {
        this.icon = icon;
        this.placeholder = placeholder;
        this.type = type;
        
        addClassName("form-input-group");

        Input input = new Input();
        input.addClassName("form-input");
        input.getElement().setProperty("type", type);
        input.getElement().setProperty("placeholder", placeholder);

        FontIcon inputIcon = new FontIcon(icon);

        add(input, inputIcon);
        getElement();

    }
}
