package com.careerdevs;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

    private static ArrayList<Car> carInventory;

    public static void main(String[] args) {

//        System.out.println("");
//        System.out.println("Welcome to the Charlie Chocolate Factory Rent-a-Car.\n");

        createCarInventory();

       while(true) {

           if (!inventoryAvailable()) {
               System.out.println("\nOur apologies. We currently have no more cars available.");
               break;
           }

           rentalMenu();
       }
    }

    private static ArrayList<Car> getAvailableCars() {

        ArrayList<Car> availableCars = new ArrayList<>();
        for(int currentCarIndex = 0; currentCarIndex <= lastIndexOf(carInventory); currentCarIndex++) {

            if (carInventory.get(currentCarIndex).isAvailable() ){

                availableCars.add(carInventory.get(currentCarIndex));
            }
        }

        return availableCars;
    }

    private static void rentalMenu() {

        ArrayList<Car> availableCars = getAvailableCars();

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

        availableCars.get(userSelectionIndex).setAvailability(false);
        System.out.println("Congratulations, you have successfully rented a " + availableCars.get(userSelectionIndex).getName() + ".");
    }

    private static void createCarInventory() {

        carInventory = new ArrayList<>();

        Car darkKnight = new Car("Lamborghini", "Batmobile");
        Car nightRyder = new Car("Pontiac", "Kitt");
        Car pixar = new Car("Chevy", "Lightning McQueen");
        Car bueller = new Car("Ferrari", "GT California Spyder");

        carInventory.addAll(List.of(new Car[]{darkKnight, nightRyder, pixar, bueller}));


    }

     private static int lastIndexOf(ArrayList<?> arrayList){

        return arrayList.size() - 1;

    }

    private static boolean inventoryAvailable() {

        boolean someAvailable = false;

        for (int currentCarIndex = 0; currentCarIndex <= lastIndexOf(carInventory); currentCarIndex++) {

            if (carInventory.get(currentCarIndex).isAvailable()) {

                someAvailable = true;
                break;
            }
        }

        return someAvailable;
    }
}
