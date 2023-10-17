package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter a list size: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        System.out.println("Please enter an increment value: ");
        int increment = scanner.nextInt();

        System.out.println("Please enter a value to search for: ");
        int value = scanner.nextInt();
        scanner.nextLine();

        boolean validAPISelection;
        String searchAPI = "";

        do {
            validAPISelection = true;
            System.out.println("Would you like to use the ITERATIVE or RECURSION api?: ");
            searchAPI = scanner.nextLine();
            searchAPI = searchAPI.toUpperCase();
            try {
                SearchAPI.valueOf(searchAPI);
            } catch (IllegalArgumentException e){
                System.out.println("Invalid Selection");
                validAPISelection = false;

            }
        } while (validAPISelection == false);

        Binary binary = new Binary();

        binary.createList(size, increment);



        int indexFound = -1;

        if (SearchAPI.valueOf(searchAPI) == SearchAPI.ITERATIVE) {
            indexFound = binary.findIntegerIndex(value);
        }

        if (SearchAPI.valueOf(searchAPI) == SearchAPI.RECURSION) {
            indexFound = binary.findIntegerIndexRecursion(value);
        }


        System.out.println(String.format("The value was found at index %d." +
                "%nThis search took %d iteration(s) using %s.", indexFound, binary.getCount(), searchAPI));

    }
}