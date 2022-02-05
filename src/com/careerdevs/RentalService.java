package com.careerdevs;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

    private static ArrayList<Car> carInventory;

    public static void main(String[] args) {

//        System.out.println("");
//        System.out.println("Welcome to the Charlie Chocolate Factory Rent-a-Car.\n");

//        int testInt = UI.readInt("Enter a number: ", 1, 10);
//        System.out.println(testInt);

        createCarInventory();
        rentalMenu();
    }

    private static void rentalMenu() {

        System.out.println("\nAvailable Cars: \n");

        int listNumber = 1;
        int lastIndex = carInventory.size() - 1;

        for (int currentIndex = 0; currentIndex <= lastIndex; currentIndex++) {

            if (!carInventory.get(currentIndex).isRented()) {

                System.out.println(listNumber + ") " + carInventory.get(currentIndex).getName());

            }

            if (currentIndex == lastIndex){

                break;
            }

            listNumber++;
        }

        int userSelection = UI.readInt("Which vehicle you'd like to tour our facilities in? ", 1, listNumber);
        System.out.println(carInventory.get(userSelection-1).getName());
    }

    private static void createCarInventory() {

        carInventory = new ArrayList<>();

        Car darkKnight = new Car("Lamborghini", "Batmobile");
        Car nightRyder = new Car("Pontiac", "Kitt");
        Car pixar = new Car("Chevy", "Lightning McQueen");
        Car bueller = new Car("Ferrari", "GT California Spyder");

        carInventory.addAll(List.of(new Car[]{darkKnight, nightRyder, pixar, bueller}));


    }

}
