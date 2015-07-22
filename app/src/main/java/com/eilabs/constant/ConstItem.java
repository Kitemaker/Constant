package com.eilabs.constant;

public class ConstItem {

    private int constItemID;
    private String Name;
    private String description;


    public ConstItem(int constItemID, String Name, String description) {
        this.constItemID = constItemID;
        this.Name = Name;
        this.description = description;

    }

    public int getConstItemID() {
        return constItemID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return Name;
    }
}
