package dhbw.eiCompany;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dhbw.timetable.rapla.exceptions.NoConnectionException;

@SpringBootApplication( scanBasePackages = "dhbw.eiCompany")
@EnableJpaRepositories(basePackages = {"dhbw.eiCompany.repositories"})
@EnableAutoConfiguration
@EnableConfigurationProperties
@EntityScan(basePackages = {"dhbw.eiCompany.model"})
public class EiBoardApplication {
	
	
	public static void main(String[] args) throws MalformedURLException, NoConnectionException, IllegalAccessException {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(EiBoardApplication.class, args);

	}
}
