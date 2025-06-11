package com.vitalquiro.app.views;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.dom.Element;

@Route("")
public class RootRedirectView implements BeforeEnterObserver, RouterLayout {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        event.forwardTo("login");
    }

    @Override
    public Element getElement() {
        // Return an empty element as this view only redirects
        return new Element("div");
    }
}
