package dhbw.eiCompany.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	//ADD KEYCLOAK TOKEN
	private final static String TOKENURL = "http://localhost:8081/realms/SpringBootKeycloak/protocol/openid-connect/token";

	@Bean
	public OpenAPI springShopOpenAPI() {
		OAuthFlows flows = new OAuthFlows();
		OAuthFlow flow = new OAuthFlow();

		flow.setTokenUrl(TOKENURL);

		
		Scopes scopes = new Scopes();
		flow.setScopes(scopes);
		flows = flows.password(flow);

		return new OpenAPI()
				.components(new Components().addSecuritySchemes("keycloak",
						new SecurityScheme().type(SecurityScheme.Type.OAUTH2).flows(flows)))
				.info(new Info().title("EiCompany").description("Swagger UI for the EiCompany Backend").version("0.0.1"));
	}
}