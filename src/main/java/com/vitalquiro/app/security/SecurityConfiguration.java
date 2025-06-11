package com.vitalquiro.app.security;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import com.vitalquiro.app.views.login.LoginView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Define o serviço de autenticação
        http.userDetailsService(userDetailsService);

        // Libera os recursos estáticos sem precisar de login
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(new AntPathRequestMatcher("/images/*.png")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/line-awesome/**/*.svg")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/@fontsource/**/*.css")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/VAADIN/**")).permitAll() // muito importante pro Vaadin funcionar
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico")).permitAll()
        );

        // Continua com a configuração do Vaadin
        super.configure(http);

        // Define a view de login e a URL padrão de redirecionamento após login bem-sucedido
        setLoginView(http, LoginView.class, "/");
    }
}
