package com.example.application.views.auth;

import com.example.application.data.User;
import com.example.application.services.AuthService;
import com.example.application.ui.IconInput;
import com.example.application.ui.OutlinedButton;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./themes/my-app/views/login.css")
@PageTitle("login")
@Route("/login")
public class LoginView extends Div {
    public LoginView() {
        LoginI18n i18n = LoginI18n.createDefault();
        FormLayout form = new FormLayout();
        Div rightImage = new Div();

        addClassName("login-rich-content");

        rightImage.getElement();
        rightImage.addClassName("right-image");

        IconInput emailInput = new IconInput("fa-solid fa-envelope", "Insira seu e-mail",
                "email");
        IconInput pwdInput = new IconInput("fa-solid fa-lock", "Insira sua senha",
                "password");
        OutlinedButton submit = new OutlinedButton("Entrar", true);

        form.add(emailInput, pwdInput, submit);
        // form.addLoginListener(e -> {
        // User loginUser = new User(e.getUsername(), e.getPassword());
        // boolean auth = AuthService.login(loginUser);
        // if (!auth) {
        // loginForm.setEnabled(true);
        // }
        // loginForm.getUI().ifPresent(ui -> {
        // ui.navigate("register");
        // });
        // });

        add(form, rightImage);

    }

}
