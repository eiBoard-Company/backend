package dhbw.eiCompany.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dhbw.eiCompany.service.DataService;
import dhbw.eiCompany.service.DataServiceImp;

@Configuration
public class DataConfiguration {
	@Bean
    public  DataService myService() {
        return new DataServiceImp();
    }
}
