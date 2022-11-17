package dhbw.eiCompany.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.time.LocalDate;

@Entity(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;
    private String typeName;
    private String typeDescribtion;
    private int priority;
    private Long entryID;
    private String foreignKey;

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescribtion() {
        return typeDescribtion;
    }

    public void setTypeDescribtion(String typeDescribtion) {
        this.typeDescribtion = typeDescribtion;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Long getEntryID() {
        return entryID;
    }

    public void setEntryID(Long entryID) {
        this.entryID = entryID;
    }
}
