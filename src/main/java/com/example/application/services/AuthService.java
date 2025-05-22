package com.example.application.services;


import com.example.application.data.User;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class AuthService {
  
  public static boolean login(User user){
    Notification notification = new Notification();
    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    notification.setDuration(2000);
    
    if(!user.getName().equals("vaitomanocu")){    
      notification.setText("Email incorreto");
      notification.open();
     return false;
    }
    if(!user.getPassword().equals("123")){
      notification.setText("Senha incorreta");
      notification.open();

     return false;
    }

    Notification.show("Mamado");
    return true;
  }
}
