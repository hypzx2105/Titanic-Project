package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "titanic-data-100.csv";
        ArrayList<Passenger> passengerList = new ArrayList<>();

        loadPassengerDataFromFile(passengerList, fileName);

        System.out.println("Question 1: Passenger Names");
        System.out.println(Passenger.getPassengerNames(passengerList));

        System.out.println("Question 2: Passengers Containing Name 'John'");
        System.out.println(Passenger.getPassengersContainingName(passengerList, "John"));

        System.out.println("Question 3: Passengers Older Than 30");
        System.out.println(Passenger.getPassengersOlderThan(passengerList, 30));

        System.out.println("Question 4: Passengers by Gender (Male)");
        System.out.println(Passenger.countPassengersByGender(passengerList, "male"));

        System.out.println("Question 5: Total Fares");
        System.out.println(Passenger.sumFares(passengerList));

        System.out.println("Question 6: Male Survivors");
        System.out.println(Passenger.maleSurvivors(passengerList));

        System.out.println("Question 7: Ticket Owner for Ticket 'A/5 21171'");
        System.out.println(Passenger.ticketOwner(passengerList, "A/5 21171"));

        System.out.println("Question 8: Average Age");
        System.out.println(Passenger.averageAge(passengerList));

        System.out.println("Question 9: Passengers by First Class");
        System.out.println(Passenger.getPassengersByTicketClass(passengerList, PassengerClass.FIRST));

        System.out.println("Question 10: Passengers Sorted by ID");
        System.out.println(Passenger.sortPassengersByPassengerId(passengerList));

        System.out.println("Question 11: Passengers Sorted by Name");
        System.out.println(Passenger.sortPassengersByName(passengerList));

        System.out.println("Question 12: Passengers Sorted by Age, Then Name");
        System.out.println(Passenger.sortPassengersByAgeThenName(passengerList));

        System.out.println("Question 13: Passengers Sorted by Gender, Then ID");
        System.out.println(Passenger.sortPassengersByGenderThenPassengerNumber(passengerList));

        System.out.println("Question 14: Passengers Sorted by Fare, Then Survival");
        System.out.println(Passenger.sortPassengersByFareThenSurvival(passengerList));

        System.out.println("Question 15: Passengers Sorted by Ticket Class");
        System.out.println(Passenger.sortPassengersByTicketClass(passengerList));

        System.out.println("Question 16: Passengers Sorted by Age");
        System.out.println(Passenger.sortPassengersByAge(passengerList));

        System.out.println("Question 17: Passengers Sorted by Ticket Number (Lambda)");
        System.out.println(Passenger.sortPassengersByTicketNumberLambda(passengerList));

        System.out.println("Question 18: Passengers Sorted by Ticket Number (Static Comparator)");
        System.out.println(Passenger.sortPassengersByTicketNumberStatic(passengerList));

        System.out.println("Question 19: Find Passenger by Ticket Number 'A/5 21171'");
        System.out.println(Passenger.findPassengerByTicketNumber(passengerList, "A/5 21171"));

        System.out.println("Question 20: Find Passenger by Passenger ID '1'");
        System.out.println(Passenger.findPassengerByPassengerId(passengerList, "1"));

        System.out.println("Finished, Goodbye!");
    }

    public static void loadPassengerDataFromFile(ArrayList<Passenger> passengerList, String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))
                .useDelimiter("[,\\r\\n]+")) {
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNext()) {
                String passengerId = sc.next();
                int survived = sc.nextInt();
                int passengerClass = sc.nextInt();
                String name = sc.next();
                String gender = sc.next();
                int age = sc.nextInt();
                int siblingsAndSpouses = sc.nextInt();
                int parentsAndChildren = sc.nextInt();
                String ticketNumber = sc.next();
                double fare = sc.nextDouble();
                String cabin = sc.next();
                String embarkedAt = sc.next();

                passengerList.add(new Passenger(passengerId, survived, passengerClass,
                        name, gender, age, siblingsAndSpouses, parentsAndChildren, ticketNumber,
                        fare, cabin, embarkedAt));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("FileNotFoundException caught. The file " + fileName + " may not exist." + exception);
        }
    }
}
