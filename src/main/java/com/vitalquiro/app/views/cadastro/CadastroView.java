package com.vitalquiro.app.views.cadastro;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Cadastro")
@Route("cadastro")
@Menu(order = 6, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@AnonymousAllowed
public class CadastroView extends Composite<VerticalLayout> {

    public CadastroView() {
        LoginForm loginForm = new LoginForm();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, loginForm);
        loginForm.setWidth("min-content");
        getContent().add(loginForm);
    }
}
