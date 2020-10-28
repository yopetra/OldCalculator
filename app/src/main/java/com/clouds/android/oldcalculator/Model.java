package com.clouds.android.oldcalculator;

public class Model {

    private double mValue = 0;

    public Model(){}

    public void setValue(Double value){
        this.mValue = value;
    }

    public Double getValue(){
        return this.mValue;
    }

    public void clearValue(){
        this.mValue = 0;
    }
}
