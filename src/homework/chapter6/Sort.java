package homework.chapter6;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) throws IOException {

        // Version 1
        int[] array1 = {4, 7, 1, 3, 9, 0, 2, -4};
        System.out.print("Version 1\nHere is the first unsorted array: ");
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[i] > array1[j]) {
                    int perm = array1[j];
                    array1[j] = array1[i];
                    array1[i] = perm;
                }
            }
        }
        System.out.print("My manually sorted array is: [ ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("] \n");


        // Version 2
        int[] array2 = {3, 8, 18, 888, 0, 0, -65, 9, 10, 11, -65, 1};
        System.out.print("Version 2\nHere is the second unsorted array: ");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
        Arrays.sort(array2);
        System.out.print("The second array was sorted with \"Arrays.sort\" method: [ ");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println("] \n");


        // Version 3
        System.out.println("Version 3\nThis version is interactive\nPlease enter numbers and separate them with white spaces.\nAfter you done, press \"Enter\".");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numberStrings = input.split(" ");

        int[] array3 = new int[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            array3[i] = Integer.parseInt(numberStrings[i]);
        }
        Arrays.sort(array3);
        System.out.print("The third was also sorted with \"Arrays.sort\" method: [ ");
        for (int i : array3) {
            System.out.print(i + " ");
        }
        System.out.println("] \n");

        System.out.print("The reverse sorted array is here: ");
        int[] reversed = new int[array3.length];
        for (int i = 0; i < array3.length; i++) {
            reversed[i] = array3[array3.length - 1 - i];
        }
        for (int i : reversed) {
            System.out.print(i + " ");
        }
        System.out.println("\nThanks for reviewing my program");
    }
}
