package dhbw.eiCompany;

import dhbw.eiCompany.service.DataService;
import dhbw.eiCompany.utils.RaplaAPI;
import dhbw.timetable.rapla.data.event.Appointment;
import dhbw.timetable.rapla.exceptions.NoConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class },scanBasePackages = "dhbw.eiCompany")
public class EiBoardApplication {
	
	
	public static void main(String[] args) throws MalformedURLException, NoConnectionException, IllegalAccessException {
		SpringApplication.run(EiBoardApplication.class, args);
		new EiBoard().postRun();

	}
}
