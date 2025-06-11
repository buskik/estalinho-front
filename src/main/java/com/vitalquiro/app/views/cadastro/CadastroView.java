package com.vitalquiro.app.views.cadastro;




import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.router.Menu;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Cadastro")
@Route("cadastro")
@Menu(order = 6, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@AnonymousAllowed
public class CadastroView extends VerticalLayout {

    @SuppressWarnings("unused")
    public CadastroView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        FormLayout formLayout = new FormLayout();

        TextField nameField = new TextField("Nome completo");
        EmailField emailField = new EmailField("Email");
        PasswordField passwordField = new PasswordField("Senha");
        passwordField.setHelperText("A senha deve ter pelo menos 8 caracteres");
        passwordField.setErrorMessage("Senha inválida. Deve ter pelo menos 8 caracteres");
        passwordField.setPattern(".{8,}"); 
        passwordField.setRequiredIndicatorVisible(true);
        TextField cpfField = new TextField("CPF");
        cpfField.setPattern("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        cpfField.setHelperText("Formato: 123.456.789-01");
        cpfField.setErrorMessage("CPF inválido. Use o formato 123.456.789-01");
        cpfField.setRequiredIndicatorVisible(true);
        passwordField.setRequiredIndicatorVisible(true);
        emailField.setRequiredIndicatorVisible(true);
        nameField.setRequiredIndicatorVisible(true);
        ComboBox<String> tipoField = new ComboBox<>("Tipo de usuário");
        tipoField.setItems("Usuário", "Médico", "Admin");

        Button cadastrarButton = new Button("Cadastrar");

        cadastrarButton.addClickListener(event -> {
            String nome = nameField.getValue();
            String email = emailField.getValue();
            String senha = passwordField.getValue();
            String cpf = cpfField.getValue();
            String tipo = tipoField.getValue();

            
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || tipo == null) {
                Notification.show("Por favor, preencha todos os campos.", 3000, Notification.Position.MIDDLE);
            } else {
                Notification.show("Cadastro realizado com sucesso!", 3000, Notification.Position.MIDDLE);
                nameField.clear();
                emailField.clear();
                passwordField.clear();
                cpfField.clear();
                tipoField.clear();
            }
        });

        formLayout.add(nameField, emailField, passwordField, cpfField, tipoField, cadastrarButton);
        formLayout.setWidth("400px");

        // Novo layout horizontal para centralizar o formulário horizontalmente
        HorizontalLayout centeredLayout = new HorizontalLayout(formLayout);
        centeredLayout.setSizeFull();
        centeredLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeredLayout.setAlignItems(Alignment.CENTER);

        add(centeredLayout);
    }
}




/*
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
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
        ((HasSize) loginForm).setWidth("min-content");
        getContent().add(loginForm);
    }
}
*/