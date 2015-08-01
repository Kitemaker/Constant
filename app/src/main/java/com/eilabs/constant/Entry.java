package com.eilabs.constant;

/**
 * Created by Farheena on 27-07-2015.
 */
public class Entry {
    // This class represents a single entry (post) in the XML feed.
    // It includes the data members "title," "link," and "summary."

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

        public  String ID;
        public  String Name;
        public  String Value;

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String Unit;

        public Entry(String id, String name, String value,String unit) {
            this.ID = id;
            this.Name = name;
            this.Value = value;
            this.Unit=unit;
        }
    @Override
    public String toString() {
        return Name;
    }

}
