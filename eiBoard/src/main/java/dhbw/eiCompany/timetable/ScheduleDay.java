package dhbw.eiCompany.timetable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDay{
    private List<Lecture> lectureList = new ArrayList<Lecture>();
    private static List<ScheduleDay> scheduleDays = new ArrayList<ScheduleDay>();
    private LocalDate date;

    private ScheduleDay(LocalDate date) {
    	this.date = date;
    }

    public static ScheduleDay getInstance(LocalDate date){
        for (ScheduleDay day : scheduleDays){
            if(day.getDate() != null && day.getDate().toString().equalsIgnoreCase(date.toString())){
                return day;
            }
        }
        ScheduleDay day = new ScheduleDay(date);
        scheduleDays.add(day);
      
        return day;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public  void clearAll(){
        scheduleDays = new ArrayList<ScheduleDay>();
        lectureList = new ArrayList<Lecture>();
    }

    public void addLecture(Lecture l){
        lectureList.add(l);
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public static List<ScheduleDay> getScheduleDays() {
        return scheduleDays;
    }
}
