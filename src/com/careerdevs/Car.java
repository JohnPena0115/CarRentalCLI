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

    public String toStringRent(){

        return "Thank you, you are now returning the " +
                make + " " + model + ".\n" +
                "Enjoy the Oasis autobahn.";
    }

    public String toStringReturn(){

        return "Thank you, you have returned the " +
                make + " " + model + ".\n" +
                "Be sure to stop by the souvenir shop on the way out.";
    }
}
