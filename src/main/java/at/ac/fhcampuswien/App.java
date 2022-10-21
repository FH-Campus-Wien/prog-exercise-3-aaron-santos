package at.ac.fhcampuswien;

import java.nio.file.LinkPermission;
import java.util.Random;
import java.util.Scanner;

public class App {

        public static void oneMonthCalendar ( int days, int start){
            for (int i = 1; i < 3 * start - 2; i++)
                System.out.print(" ");

            int j;
            for (j = 1; j <= days; j++) {
                int length = String.valueOf(j).length();
                if (length == 1)
                    System.out.print(" ");
                System.out.print(j + " ");
                if ((j + start - 1) % 7 == 0)
                    System.out.println();
            }
            j--;
            if ((j + start - 1) % 7 != 0)
                System.out.println();
        }

// todo 2
        public static long[] lcg ( long first_number){
            long next_number;
            final long a = 1103515245;
            final long c = 12345;
            final long m = (long) Math.pow((double) 2, (double) 31);
            long numbers[] = new long[10];
            for (int i = 0; i < 10; i++) {
                next_number = (a * first_number + c) % m;
                first_number = next_number;
                numbers[i] = first_number;
            }
            for (int i = 0; i < 10; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return numbers;
        }
        // todo 3
        public static void guessingGame ( int numberToGuess){
            Scanner scan = new Scanner(System.in);
            randomNumberBetweenOneAndHundred();
            int count = 1;
            int value;
            while (count <= 10) {
                System.out.print("Guess number " + count + ": ");
                value = scan.nextInt();
                if (count == 10)
                    break;
                if (value < numberToGuess) {
                    System.out.println("The number AI picked is higher than your guess.");
                } else if (value > numberToGuess) {
                    System.out.println("The number AI picked is lower than your guess.");
                } else {
                    System.out.println("You won wisenheimer!");
                    return;
                }
                count++;
            }
            System.out.println("You lost! Have you ever heard of divide & conquer?");

        }

        public static int randomNumberBetweenOneAndHundred () {
            Random random = new Random();
            return random.nextInt(100) + 1;
        }

        // todo 4
        public static boolean swapArrays ( int arr1[], int arr2[]){
            int length1 = arr1.length;
            int length2 = arr2.length;

            if (length1 != length2)
                return false;

            int aux[] = new int[length1];
            for (int i = 0; i < length1; i++) {
                aux[i] = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = aux[i];
            }
            return true;
        }
        // todo 5
        public static String camelCase (String input){
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != ' ' && (int) input.charAt(i) >= 67 && (int) input.charAt(i) <= 122) {
                    char nextChar = input.charAt(i);
                    if (i != 0) {
                        int val_c = (int) nextChar;
                        if (val_c >= 65 && val_c <= 90) {
                            nextChar = (char) (nextChar + 32);
                        }
                        result.append(nextChar);
                    } else {
                        nextChar = input.charAt(i);
                        int val_c = (int) nextChar;
                        if (val_c >= 97 && val_c <= 122) {
                            nextChar = (char) (nextChar - 32);
                        }
                        result.append(nextChar);
                    }
                } else if (input.charAt(i) == ' ') {
                    char next_c = input.charAt(i + 1);
                    int val_c = (int) next_c;
                    if (val_c >= 97 && val_c <= 122) {
                        next_c = (char) (next_c - 32);

                    }
                    result.append(next_c);
                    i++;
                }
            }

            return result.toString();
        }
        public static int checkDigit ( int[] array){
            int length = array.length;
            int array2[] = new int[length];
            int array3[] = new int[length];
            for (int i = 0; i < length; i++)
                array2[i] = i + 2;

            for (int i = 0; i < length; i++)
                array3[i] = array[i] * array2[i];

            int sum = 0;
            for (int i = 0; i < length; i++)
                sum += array3[i];

            int rest = sum % 11;
            int diff = 11 - rest;

            if (diff == 11)
                return 5;
            else if (diff == 10)
                return 0;

            return diff;
        }
    }