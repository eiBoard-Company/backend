package dhbw.eiCompany.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://185.252.235.49", "http://185.252.235.49:80", "http://185.252.235.49:8089", "http://185.252.235.49:8090", "http://185.252.235.49:8080")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD") ;
    }
} 