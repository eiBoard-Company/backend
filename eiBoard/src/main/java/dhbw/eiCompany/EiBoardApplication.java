package dhbw.eiCompany;

import dhbw.eiCompany.service.DataService;
import dhbw.eiCompany.utils.RaplaAPI;
import dhbw.timetable.rapla.data.event.Appointment;
import dhbw.timetable.rapla.exceptions.NoConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}, scanBasePackages = "dhbw.eiCompany")
@EnableJpaRepositories(basePackages = {"dhbw.eiCompany.repositories"})
@EntityScan(basePackages = {"dhbw.eiCompany.database"})
public class EiBoardApplication {
	
	
	public static void main(String[] args) throws MalformedURLException, NoConnectionException, IllegalAccessException {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(EiBoardApplication.class, args);

	}
}
