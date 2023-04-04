package dhbw.eiCompany.timetable;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDay{
    private List<Lecture> lectureList = new ArrayList<Lecture>();

    public ScheduleDay() {
    }


    public  void clearAll(){
        lectureList = new ArrayList<Lecture>();
    }

    public void addLecture(Lecture l){
        lectureList.add(l);
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

}
