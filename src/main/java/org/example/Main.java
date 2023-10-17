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

        Binary binary = new Binary();

        binary.createList(size, increment);

        int indexFound = binary.findIntegerIndex(value);

        System.out.println(String.format("The value was found at index %d." +
                "%nThis search took %d iteration(s).", indexFound, binary.getCount()));

    }
}