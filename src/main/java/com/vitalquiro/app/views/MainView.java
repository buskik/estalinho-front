package com.vitalquiro.app.views;

import com.vitalquiro.app.data.User;
import com.vitalquiro.app.security.AuthenticatedUser;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Optional;

@Route("")               // rota raiz
@PageTitle("Dashboard")  // título da aba
@AnonymousAllowed        // permite acesso mesmo sem estar logado, para podermos redirecionar ao login
public class MainView extends VerticalLayout implements BeforeEnterObserver {

    private final AuthenticatedUser authenticatedUser;

    public MainView(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
        // Monta o layout básico; o beforeEnter faz o redirecionamento
        add(new H1("Bem-vinda ao Dashboard!"));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<User> maybeUser = authenticatedUser.get();
        if (maybeUser.isEmpty()) {
            // Não está logado → vai para /login
            event.forwardTo("login");
        }
    }
}
