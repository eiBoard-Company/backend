package dhbw.eiCompany.controller;

import dhbw.eiCompany.timetable.ScheduleDay;
import dhbw.eiCompany.utils.LoadDays;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DateController {

    @GetMapping(path = "/lectures/{date}")

    public @ResponseBody ScheduleDay scheduleDay(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return LoadDays.loadDays(date);

    }

}
