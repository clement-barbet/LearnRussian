package fr.brbt.learnrussian;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class RepoConfiguration extends WebMvcConfigurationSupport {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String myExternalFilePath = "file:/home/brbt/Bureau/media/";
        registry.addResourceHandler("/media/**").addResourceLocations("file:/home/brbt/Bureau/media/");
    }
}
