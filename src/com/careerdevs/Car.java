package com.careerdevs;

public class Car {

    String make;
    String model;
    boolean isRented;

    Car (String make, String model, boolean isRented){

        this.make = make;
        this.model = model;
        this.isRented = isRented;

    }

    public String toString(){

        return  "Car{" +
                "make=\"" + make + "\"" +
                ", model=\"" + model + "\"" +
                ", isRented=" + isRented +
                "}";
    }


}
