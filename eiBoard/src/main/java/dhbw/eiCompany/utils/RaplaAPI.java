package dhbw.eiCompany.utils;

import dhbw.eiCompany.service.DataServiceImp;
import dhbw.eiCompany.timetable.Lecture;
import dhbw.timetable.rapla.data.event.Appointment;
import dhbw.timetable.rapla.exceptions.NoConnectionException;
import dhbw.timetable.rapla.parser.DataImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;


import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class RaplaAPI {
    private DataServiceImp service;
    private LocalDate start;
    private LocalDate end;
    private String url;
    Map<LocalDate, ArrayList<Appointment>> data;
    public RaplaAPI(LocalDate start, LocalDate end) throws MalformedURLException, NoConnectionException, IllegalAccessException {
        this.start = start;
        this.end = end;
        this.url = "https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=eisenbiegler&file=TINF21B4";
        this.service = new DataServiceImp();

        this.data = DataImporter.ImportWeekRange(start, end, url);
        this.run();

    }
    public Map<LocalDate, ArrayList<Appointment>> getData() {
        return data;
    }

    public void setData(Map<LocalDate, ArrayList<Appointment>> data) {
        this.data = data;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DataServiceImp getService() {
        return service;
    }

    public void run() {

        for(ArrayList<Appointment> value  : data.values()){
            for(Appointment app : value){
                final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                final LocalDate dt =  LocalDate.parse(app.getDate(), dtf);
                dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Lecture lecture = new Lecture(app.getPersons(), app.getResources(), app.getTitle(), app.getStartDate(), app.getEndDate(), dt );
                service.addData(lecture);
            }
        }
        System.out.println(service);
    }
}
