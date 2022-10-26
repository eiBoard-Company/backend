package dhbw.eiCompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dhbw.eiCompany.timetable.Lecture;

@Component
public class DataServiceImp implements DataService{
    private final List<Lecture> lectures;

    public DataServiceImp(){
        this.lectures = new ArrayList<>();
    }

    public void addData(Lecture lecture){
        this.lectures.add(lecture);
    }

    public List<Lecture> getData(){
        return this.lectures;
    }

}
