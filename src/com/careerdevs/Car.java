package com.careerdevs;

public class Car {

    private String make;
    private String model;
    private boolean isAvailable;

    Car (String make, String model){

        this.make = make;
        this.model = model;
        this.isAvailable = true;

    }

    public String getMake() {

        return make;
    }

    public String getModel() {

        return model;
    }

    public String getName() {

        return make + " " + model;
    }

    public boolean isAvailable() {

        return isAvailable;
    }

    public void setAvailability(boolean available) {

        isAvailable = available;
    }


    public String toString(){

        return  "Car{" +
                "make=\"" + make + "\"" +
                ", model=\"" + model + "\"" +
                ", isAvailable=" + isAvailable +
                "}";
    }


}
