package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
// pojo - using objects to represent data - not tied to the framework
// - base class Cheese with fields, getters, and setters
public class Cheese {

    // since these fields are private, we need getters and setters to access them
    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private CheeseType type;

    private int cheeseId;
    private static int nextId = 1;

    // constructor - initializes a newly created object with this. keyword
    // when it is invoked at runtime via new keyword eg Cheese obj = new Cheese(name, desc);
    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    // getters and setters are needed if we need to access these fields outside of Cheese class
    // since these fields are private
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}