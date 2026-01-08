package br.com.nerds.patrimonio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController(
                "/equipamentos/",
                "/equipamentos"
        );
        registry.addRedirectViewController(
                "",
                "/equipamentos"
        );
        registry.addRedirectViewController(
                "/equipamentos/numero-de-serie",
                "/equipamentos"
        );

        registry.addRedirectViewController(
                "/equipamentos/numero-de-serie/",
                "/equipamentos"
        );
    }
    
}