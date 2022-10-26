package dhbw.eiCompany;

import java.net.MalformedURLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import dhbw.eiCompany.service.DataService;
import dhbw.eiCompany.service.DataServiceImp;
import dhbw.eiCompany.utils.RaplaAPI;
import dhbw.timetable.rapla.exceptions.NoConnectionException;

public class EiBoard {

	@Autowired
	private  DataService serviceTest;
	
	public void postRun() {
		serviceTest = new DataServiceImp();
		try {
			RaplaAPI api = new RaplaAPI(LocalDate.of(2022,10,3), LocalDate.of(2022,10,10));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serviceTest.getData();
	}
}
