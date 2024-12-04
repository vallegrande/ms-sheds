package pe.edu.vallegrande.shed.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

public class SwaggerConfig implements WebFluxConfigurer {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://9000-vallegrandea-mssupplier-d5m1zs6fian.ws-us116.gitpod.io/"))
                .info(new Info()
                        .title("Oracle ATP Rest API")
                        .description("Especificacion de REST API services")
                        .license(new License().name("Valle Grande").url("https://vallegrande.edu.pe"))
                        .version("1.0.0")
                );
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todas las rutas
                .allowedOrigins("*") // Permitir todas las orígenes (ajusta según tus necesidades)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*"); // Permitir todos los headers
    }
}
