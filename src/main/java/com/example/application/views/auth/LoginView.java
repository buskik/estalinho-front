package com.example.application.views.auth;
import com.example.application.data.User;
import com.example.application.services.AuthService;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("login")
@Route("/login")
public class LoginView extends HorizontalLayout {
    public LoginView() {
        addClassName("login-rich-content");
        Div rightImage = new Div();
        rightImage.getElement();
        rightImage.addClassName("right-image");   

        LoginForm loginForm = new LoginForm();
        loginForm.getElement();
        loginForm.addLoginListener(e -> {
            User loginUser = new User(e.getUsername(), e.getPassword());
            boolean auth = AuthService.login(loginUser);
            if(!auth){
                loginForm.setEnabled(true);
            } 
            loginForm.getUI().ifPresent(ui -> {
                ui.navigate("register");
            });
        });
        add(loginForm, rightImage);

    }

}
