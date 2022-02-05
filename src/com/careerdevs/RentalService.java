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

        ArrayList<Car> availableCars = new ArrayList<>();
        for(int currentCarIndex = 0; currentCarIndex <= lastIndexOf(carInventory); currentCarIndex++) {

            if (!carInventory.get(currentCarIndex).isRented() ){

                availableCars.add(carInventory.get(currentCarIndex));
            }
        }

        System.out.println("\nAvailable Cars: \n");

        int listDisplayNumber = 1;

        for (int currentCarIndex = 0; currentCarIndex <= lastIndexOf(availableCars); currentCarIndex++) {

            System.out.println(listDisplayNumber + ") " + availableCars.get(currentCarIndex).getName());

            if (currentCarIndex == lastIndexOf(availableCars)){
                break;
            }

            listDisplayNumber++;
        }

        int userSelection = UI.readInt("Which vehicle you'd like to tour our facilities in? ", 1, listDisplayNumber);
        int userSelectionIndex = userSelection - 1;

        carInventory.get(userSelectionIndex).setRented(true);
        System.out.println(availableCars.get(userSelectionIndex).getName());
    }

    private static void createCarInventory() {

        carInventory = new ArrayList<>();

        Car darkKnight = new Car("Lamborghini", "Batmobile");
        Car nightRyder = new Car("Pontiac", "Kitt");
        Car pixar = new Car("Chevy", "Lightning McQueen");
        Car bueller = new Car("Ferrari", "GT California Spyder");

        carInventory.addAll(List.of(new Car[]{darkKnight, nightRyder, pixar, bueller}));


    }

     private static int lastIndexOf(ArrayList<Car> arrayList){

        return arrayList.size() - 1;

    }

}
