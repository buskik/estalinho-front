package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;

@Tag("custom-component")
public class CustomComponent extends Component {
    public CustomComponent() {
        getElement().setText("This is a custom component");
    }
}
