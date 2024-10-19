package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Passenger implements Comparable<Passenger> {
    private String passengerId;
    private int survived;
    private PassengerClass passengerClass;
    private String name;
    private String gender;
    private int age;
    private int siblingsAndSpouses;
    private int parentsAndChildren;
    private String ticketNumber;
    private double fare;
    private String cabin;
    private String embarkedAt;

    public Passenger(String passengerId, int survived, int passengerClassAsNumber, String name,
                     String gender, int age, int siblingsAndSpouses, int parentsAndChildren,
                     String ticketNumber, double fare, String cabin, String embarkedAt) {
        this.passengerId = passengerId;
        this.survived = survived;

        if(passengerClassAsNumber==1)
            passengerClass=PassengerClass.FIRST;
        else if(passengerClassAsNumber==2)
            passengerClass=PassengerClass.SECOND;
        else if(passengerClassAsNumber==3)
            passengerClass=PassengerClass.THIRD;
        else if(passengerClassAsNumber==4)
            passengerClass=PassengerClass.UNKNOWN;

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.siblingsAndSpouses = siblingsAndSpouses;
        this.parentsAndChildren = parentsAndChildren;
        this.ticketNumber = ticketNumber;
        this.fare = fare;
        this.cabin = cabin;
        this.embarkedAt = embarkedAt;
    }

    @Override
    public int compareTo(Passenger other) {
        return this.passengerId.compareTo(other.passengerId);
    }



    //question 1
     public static ArrayList<String> getPassengerNames(ArrayList<Passenger> passengerList) {
         ArrayList<String> names = new ArrayList<>();

         for (Passenger passenger : passengerList) {
             names.add(passenger.getName());
         }

         return names;
     }

     //question2
     public static ArrayList<Passenger> getPassengersContainingName(ArrayList<Passenger> passengerList, String name) {
         ArrayList<Passenger> matchingPassengers = new ArrayList<>();

         for (Passenger passenger : passengerList) {
             if (passenger.getName().toLowerCase().contains(name.toLowerCase())) {
                 matchingPassengers.add(passenger);
             }
         }

         return matchingPassengers;
     }

     //question3
     public static ArrayList<Passenger> getPassengersOlderThan(ArrayList<Passenger> passengerList, int age) {
         ArrayList<Passenger> olderPassengers = new ArrayList<>();

         for (Passenger passenger : passengerList) {
             if (passenger.getAge() > age) {
                 olderPassengers.add(passenger);
             }
         }

         return olderPassengers;
     }

     //question4

    public static ArrayList<Passenger> countPassengersByGender(ArrayList<Passenger> passengerList, String gender) {
        ArrayList<Passenger> passengersByGender = new ArrayList<>();

        for (Passenger passenger : passengerList) {
            if (passenger.getGender().equalsIgnoreCase(gender)) {
                passengersByGender.add(passenger);
            }
        }

        return passengersByGender;
    }

    //question 5

    public static double sumFares(ArrayList<Passenger> passengerList) {
        double totalFare = 0.0;

        for (Passenger passenger : passengerList) {
            totalFare += passenger.getFare();
        }

        return totalFare;
    }

    //question 6

    public static ArrayList<String> maleSurvivors(ArrayList<Passenger> passengerList) {
        ArrayList<String> maleSurvivorNames = new ArrayList<>();

        for (Passenger passenger : passengerList) {
            if (passenger.getGender().equalsIgnoreCase("male") && passenger.getSurvived() == 1) {
                maleSurvivorNames.add(passenger.getName());
            }
        }

        return maleSurvivorNames;
    }

    //question 7

    public static Passenger ticketOwner(ArrayList<Passenger> passengerList, String ticketNumber) {
        for (Passenger passenger : passengerList) {
            if (passenger.getTicketNumber().equals(ticketNumber)) {
                return passenger;
            }
        }
        return null;
    }

    //question 8

    public static double averageAge(ArrayList<Passenger> passengerList) {
        double totalAge = 0.0;
        int count = 0;

        for (Passenger passenger : passengerList) {
            if (passenger.getAge() > 0) {
                totalAge += passenger.getAge();
                count++;
            }
        }

        return count > 0 ? totalAge / count : 0.0;
    }

    //question 9

    public static ArrayList<Passenger> getPassengersByTicketClass(ArrayList<Passenger> passengerList, PassengerClass passengerClass) {
        ArrayList<Passenger> passengersByClass = new ArrayList<>();

        for (Passenger passenger : passengerList) {
            if (passenger.getPassengerClass() == passengerClass) {
                passengersByClass.add(passenger);
            }
        }

        return passengersByClass;
    }

    //question 10

    public static ArrayList<Passenger> sortPassengersByPassengerId(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        Collections.sort(sortedList);
        return sortedList;
    }

    //question 11

    public static ArrayList<Passenger> sortPassengersByName(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        sortedList.sort(Comparator.comparing(Passenger::getName));
        return sortedList;
    }

    //question 12

    public static ArrayList<Passenger> sortPassengersByAgeThenName(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        sortedList.sort(Comparator.comparingInt(Passenger::getAge)
                .thenComparing(Passenger::getName));
        return sortedList;
    }

    //question 13

    public static ArrayList<Passenger> sortPassengersByGenderThenPassengerNumber(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        sortedList.sort(Comparator.comparing(Passenger::getGender)
                .thenComparing(Passenger::getPassengerId));
        return sortedList;
    }

    //question 14

    public static ArrayList<Passenger> sortPassengersByFareThenSurvival(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        sortedList.sort(Comparator.comparingDouble(Passenger::getFare)
                .thenComparingInt(Passenger::getSurvived).reversed());
        return sortedList;
    }

    //question 15

    public static ArrayList<Passenger> sortPassengersByTicketClass(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        sortedList.sort(Comparator.comparing(Passenger::getPassengerClass));
        return sortedList;
    }

    //question 16

    public static ArrayList<Passenger> sortPassengersByAge(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);


        sortedList.sort(new Comparator<Passenger>() {
            @Override
            public int compare(Passenger p1, Passenger p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });

        return sortedList;
    }

    //question 17

    public static ArrayList<Passenger> sortPassengersByTicketNumberLambda(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);


        sortedList.sort((p1, p2) -> p1.getTicketNumber().compareTo(p2.getTicketNumber()));

        return sortedList;
    }

    // question 18

    public static Comparator<Passenger> ticketNumberComparator = new Comparator<Passenger>() {
        @Override
        public int compare(Passenger p1, Passenger p2) {
            return p1.getTicketNumber().compareTo(p2.getTicketNumber());
        }
    };

    public static ArrayList<Passenger> sortPassengersByTicketNumberStatic(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);


        sortedList.sort(Passenger.ticketNumberComparator);

        return sortedList;
    }

    //question 19

    public static Passenger findPassengerByTicketNumber(ArrayList<Passenger> passengerList, String ticketNumber) {

        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        sortedList.sort(Passenger.ticketNumberComparator);


        Passenger searchKey = new Passenger("", 0, 0, "", "", 0, 0, 0, ticketNumber, 0.0, "", "");


        int index = Collections.binarySearch(sortedList, searchKey, Passenger.ticketNumberComparator);


        if (index >= 0) {
            return sortedList.get(index);
        } else {
            return null;
        }
    }

    // Question 20
    public static Passenger findPassengerByPassengerId(ArrayList<Passenger> passengerList, String passengerId) {
        ArrayList<Passenger> sortedList = new ArrayList<>(passengerList);
        Collections.sort(sortedList);


        Passenger searchKey = new Passenger(passengerId, 0, 0, "", "", 0, 0, 0, "", 0.0, "", "");


        int index = Collections.binarySearch(sortedList, searchKey);

        if (index >= 0) {
            return sortedList.get(index);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId='" + passengerId + '\'' +
                ", survived=" + survived +
                ", passengerClass=" + passengerClass +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", siblingsAndSpouses=" + siblingsAndSpouses +
                ", parentsAndChildren=" + parentsAndChildren +
                ", ticketNumber=" + ticketNumber +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarkedAt='" + embarkedAt + '\'' +
                '}';
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public PassengerClass getPassengerClass() {
        return passengerClass;
    }

    public void setPassengerClass(PassengerClass passengerClass) {
        this.passengerClass = passengerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSiblingsAndSpouses() {
        return siblingsAndSpouses;
    }

    public void setSiblingsAndSpouses(int siblingsAndSpouses) {
        this.siblingsAndSpouses = siblingsAndSpouses;
    }

    public int getParentsAndChildren() {
        return parentsAndChildren;
    }

    public void setParentsAndChildren(int parentsAndChildren) {
        this.parentsAndChildren = parentsAndChildren;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getHasCabin() {
        return cabin;
    }

    public void setHasCabin(String hasCabin) {
        this.cabin = hasCabin;
    }

    public String getEmbarkedAt() {
        return embarkedAt;
    }

    public void setEmbarkedAt(String embarkedAt) {
        this.embarkedAt = embarkedAt;
    }
}
