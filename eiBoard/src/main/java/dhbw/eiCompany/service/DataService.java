package dhbw.eiCompany.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.timetable.Lecture;

@Component
public interface DataService {

    List<Lecture> getData();

    void addData(Lecture lecture);
}
