package org.launchcode.cheesemvc.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//Replaces string item in controller to store data
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15, message = "Name must be between 3 and 15 characters")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private CheeseType type;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Cheese() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
