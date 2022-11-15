package dhbw.eiCompany.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.time.LocalDate;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;

    private String name;
    private Color color;
    private LocalDate date;
    private String category;
    private String describtion;
    private String user;
    private String typId;

    public String getTypId() {
        return typId;
    }

    public void setTypId(String typId) {
        this.typId = typId;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
