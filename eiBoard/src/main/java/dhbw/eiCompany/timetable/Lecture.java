package dhbw.eiCompany.timetable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lecture {
    private String lecturer;
    private String room;
    private String lecture;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDate date;

    public Lecture(){

    }
    public Lecture(String lecturer, String room, String lecture, LocalDateTime start, LocalDateTime end, LocalDate date){
        this.lecturer = lecturer;
        this.room = room;
        this.lecture = lecture;
        this.start= start;
        this.end = end;
        this.date = date;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return this.end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
