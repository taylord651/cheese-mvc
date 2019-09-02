package org.launchcode.cheesemvc.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Replaces string item in controller to store data
public class Cheese {

    @NotNull
    @Size(min=3, max=15, message = "Name must be between 3 and 15 characters")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;


    // Unique number to identify each object created from the cheese class
    // Allow us to delete a cheese object even if it share its name with another object
    private int cheeseId;

    private static int nextId = 1;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
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
}
