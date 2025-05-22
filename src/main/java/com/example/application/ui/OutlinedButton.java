package com.example.application.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Input;

@Tag("input")
public class OutlinedButton extends Input {
  private String value;
  private boolean isSubmit;

  public OutlinedButton(String value, boolean isSubmit) {
    this.value = value;
    this.isSubmit = isSubmit;

    addClassName("outlined-btn");
    getElement().setAttribute("value", value);
    getElement().setAttribute("type", (isSubmit) ? "submit" : "button");
    getElement();
  }
}
