package dhbw.eiCompany.utils;

import dhbw.eiCompany.controller.DateController;
import dhbw.eiCompany.timetable.Lecture;
import dhbw.eiCompany.timetable.ScheduleDay;
import dhbw.timetable.rapla.exceptions.NoConnectionException;

import java.net.MalformedURLException;
import java.time.LocalDate;

public class LoadDays {

    public static ScheduleDay loadDays(LocalDate date){
        RaplaAPI api = null;
        try {
            api = new RaplaAPI(date, date);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NoConnectionException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        api.getService().getData().forEach(t -> ScheduleDay.getInstance(t.getDate()).clearAll());
    
        for(Lecture l : api.getService().getData()){
           ScheduleDay.getInstance(l.getDate()).addLecture(l);
        }
        
        return ScheduleDay.getInstance(date);
    }
}
