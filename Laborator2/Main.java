package com.lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Problema 1

        int[] studentAge = new int[25];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        for (; i < studentAge.length; i++) {

            int value = scanner.nextInt();
            if (value == -1) break;
            else {
                studentAge[i] = value;
                sum += value;
            }
        }

        System.out.println("The average is:" + (double) sum / i);


        // Problema 2

        System.out.println("Problema 2");
        System.out.println("--------------------------------");


        Person p1 = new Person("John", "Doe", "24", 1123444, "student");
        Person p2 = new Person("Jane", "Roe", "56", 2233444, "teacher");

        p1.displayPersonData();
        p2.displayPersonData();

        // Problema 3
        System.out.println("Problema 3");
        System.out.println("--------------------------------");


        Room r1 = new Room("12A", "normal", 3);
        Room r2 = new Room("12B", "tech", 7);

        r1.displayRoom();
        r2.displayRoom();


        // Problema 4
        System.out.println("Problema 4");
        System.out.println("--------------------------------");
        Subject s1 = new Subject(r1, 30, p1);
        Subject s2 = new Subject(r2, 31, p2);

        s1.displaySubject();
        s2.displaySubject();
    }
}
