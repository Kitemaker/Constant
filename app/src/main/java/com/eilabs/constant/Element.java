package com.eilabs.constant;

/**
 * Created by Farheena on 27-07-2015.
 */
public class Element {
    // This class represents a single entry (post) in the XML feed.
    // It includes the data members "title," "link," and "summary."

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String ID="";
    public String AtomicNumer="";
    public String Symbol="";
    public String Element="";
    public String OriginofName="";
    public String Period="";
    public String AtomicWeight="";
    public String MeltingPoint="";
    public String BoilingPoint="";
    public String SpecificHeat="";

    public String getAtomicNumer() {
        return AtomicNumer;
    }

    public void setAtomicNumer(String atomicNumer) {
        AtomicNumer = atomicNumer;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getElement() {
        return Element;
    }

    public void setElement(String element) {
        Element = element;
    }

    public String getOriginofName() {
        return OriginofName;
    }

    public void setOriginofName(String originofName) {
        OriginofName = originofName;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getAtomicWeight() {
        return AtomicWeight;
    }

    public void setAtomicWeight(String atomicWeight) {
        AtomicWeight = atomicWeight;
    }

    public String getMeltingPoint() {
        return MeltingPoint;
    }

    public void setMeltingPoint(String meltingPoint) {
        MeltingPoint = meltingPoint;
    }

    public String getBoilingPoint() {
        return BoilingPoint;
    }

    public void setBoilingPoint(String boilingPoint) {
        BoilingPoint = boilingPoint;
    }

    public String getSpecificHeat() {
        return SpecificHeat;
    }

    public void setSpecificHeat(String specificHeat) {
        SpecificHeat = specificHeat;
    }


    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String Unit;

        public Element(String id, String AtomicNumer ) {
            this.ID = id;
            this.AtomicNumer=AtomicNumer;
        }
    @Override
    public String toString() {

        return  this.Symbol  +"\t"+ this.Element;
    }

}
