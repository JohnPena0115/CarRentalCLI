package com.careerdevs;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

    private static ArrayList<Car> carInventory;

    public static void main(String[] args) {

//        System.out.println("");
//        System.out.println("Welcome to the Charlie Chocolate Factory Rent-a-Car.\n");

        createCarInventory();

        System.out.println("\nWelcome to Java Car Rentals!");

        mainMenu();





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

    private static ArrayList<Car> getRentedCars() {

        ArrayList<Car> rentedCars = new ArrayList<>();
        for(int currentCarIndex = 0; currentCarIndex <= lastIndexOf(carInventory); currentCarIndex++) {

            if (!carInventory.get(currentCarIndex).isAvailable()){

                rentedCars.add(carInventory.get(currentCarIndex));
            }
        }

        return rentedCars;
    }

    private static void mainMenu() {

        System.out.println("\nMain Menu");
        System.out.println("----------");

        int userSelection = UI.readInt("Would you like to ...\n" +
                "1) Rent\n" +
                "2) Return\n" +
                "3) Exit the program\n", 1, 3 );

        switch(userSelection) {

            case 1:
                rentalMenu();
                break;

            case 2:
                returnMenu();
                break;

            case 3:
                System.exit(0);

        }
    }

    private static void returnMenu() {

        if (!currentRentalsOut()) {

            System.out.println("\nWe currently have no active rentals in our inventory." +
                    "\nBrining you back to the main menu ...");

            mainMenu();
        }

        ArrayList<Car> rentedCars = getRentedCars();

        System.out.println("\nRented Cars: \n");

        int listDisplayNumber = 1;

        for (int currentCarIndex = 0; currentCarIndex <= lastIndexOf(rentedCars); currentCarIndex++) {

            System.out.println(listDisplayNumber + ") " + rentedCars.get(currentCarIndex).getName());

            if (currentCarIndex == lastIndexOf(rentedCars)){
                break;
            }

            listDisplayNumber++;
        }

        int userSelection = UI.readInt("\nWhich vehicle would you like to return?", 1, listDisplayNumber);
        int userSelectionIndex = userSelection - 1;

        rentedCars.get(userSelectionIndex).setAvailability(true);
        System.out.println("\nCongratulations, you have successfully returned the " + rentedCars.get(userSelectionIndex).getName() + "." +
                "\nBringing you back to the main menu ... ");

        mainMenu();
    }



    private static void rentalMenu() {

        System.out.println("\nRental Menu");
        System.out.println("-----------");

        if (!inventoryAvailable()) {
            System.out.println("\nOur apologies. We currently have no more cars available." +
                    "\nBringing you back to the main menu ... ");
            mainMenu();
        }

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

        int userSelection = UI.readInt("Which vehicle would you like to tour our facilities in? ", 1, listDisplayNumber);
        int userSelectionIndex = userSelection - 1;

        availableCars.get(userSelectionIndex).setAvailability(false);
        System.out.println("\nCongratulations, you have successfully rented a " + availableCars.get(userSelectionIndex).getName() + "." +
                "\nBringing you back to the main menu ... ");

        mainMenu();
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

    private static boolean currentRentalsOut() {

        boolean returnsExist = false;

        for (int currentCarIndex = 0; currentCarIndex <= lastIndexOf(carInventory); currentCarIndex++) {

            if (!carInventory.get(currentCarIndex).isAvailable()) {

                returnsExist = true;
                break;

            }
        }

        return returnsExist;
    }
}
