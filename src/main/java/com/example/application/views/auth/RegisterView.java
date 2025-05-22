package com.example.application.views.auth;
import com.example.application.data.User;
import com.example.application.services.AuthService;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("register")
@Route("/register")
public class RegisterView extends HorizontalLayout {
    public RegisterView() {
        LoginI18n i18n = LoginI18n.createDefault();
        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Register");
        i18n.setForm(i18nForm);
        addClassName("login-rich-content");
        
        Div rightImage = new Div();
        rightImage.getElement();
        rightImage.addClassName("right-image");   
        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(i18n);
        loginForm.getElement();
        loginForm.addLoginListener(e -> {
            User loginUser = new User(e.getUsername(), e.getPassword());
           loginForm.setEnabled(!AuthService.login(loginUser)); 
        });
        add(loginForm, rightImage);

    }

}
