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

           rentalMenu();

           boolean someAvailable = false;

           for (int i = 0; i <= lastIndexOf(carInventory); i++) {

               if (carInventory.get(i).isAvailable()) {

                   someAvailable = true;


               }
           }

           if (someAvailable == false) {

               System.out.println("\nOur apologies. There are no more cars to rent.");
               break;
           }


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

//        if (lastIndexOf(getAvailableCars()) < 0) {
//
//            System.out.println("Our apologies. There are no more cars to rent.");
//            System.exit(0);
//        }

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
