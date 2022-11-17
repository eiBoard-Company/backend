package dhbw.eiCompany.database;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;

@Entity(name = "Entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;

    @Column
    private String name;
    @Column
    private Color color;
    @Column
    private LocalDate date;
    @Column
    private String category;
    @Column
    private String description;
    @ManyToOne
    private Person person;
    @Column
    private String typId;

    public Entry(){}

    public Entry(Long entryId, String name, Color color, LocalDate date, String category, String description, Person person, String typId) {
        this.entryId = entryId;
        this.name = name;
        this.color = color;
        this.date = date;
        this.category = category;
        this.description = description;
        this.person = person;
        this.typId = typId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
