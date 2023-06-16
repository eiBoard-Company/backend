package dhbw.eiCompany.configuration;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakAdminclient {

    static Keycloak keycloak = null;
     static String serverUrl = "http://185.252.235.49:8089";
    public  static String realm = "eiBoardKeycloak";
     static String clientId = "eiclient";
     static String clientSecret = "iJur3UqVPUMj9VCpK8uh1gP9djoRMJpN";
     static String userName = "user";
     static String password = "test";

    public KeycloakAdminclient() {
    }

    public static Keycloak getInstance(){
    	
    	
        if(keycloak == null){
        	Boolean test = false;
        	
        	if(test = true) {
        		serverUrl ="http://localhost:8089";
        		clientId = "eiClient";
        		clientSecret = "VRFwDMC5zGRTSukvRp9hmghLbI4mxyhq";
        		userName = "matteouser";
        		password ="test";
        	}
        	ResteasyClient client = new ResteasyClientBuilderImpl().connectionPoolSize(10).build();
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(client)
                    .build();
        }
        return keycloak;
    }
}