import java.util.ArrayList;

/*
Class: CSE 1322L
Section: WJ1
Term: Summer 2022
Instructor: Maneesha Kumari Penmetsa
Name: Briana O'Neal
Lab#: Assignment 3
*/

import java.util.*;
class Vehicle {
    //attributes
    private String make;
    private String model;
    private String color;
    private int mileage;
    private int originCost;
    private boolean rented;

    //default constructor
    public Vehicle() {
        make = "";
        model = "";
        color = "";
        mileage = 0;
        originCost = 0;
        rented = false;
    }

    //overloaded constructor
    public Vehicle(String make, String model, String color, int mileage, int originCost) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.originCost = originCost;
    }

    //setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setOriginCost(int originCost) {
        this.originCost = originCost;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    //getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public int originCost() {
        return originCost;
    }

    public boolean getRented() {
        return rented;
    }

    //toString override
    @Override
    public String toString() {
        if (!getRented()) {
            return "Available: " + getColor() + " " + getMake() + " " + getModel() + " with " + getMileage() + " miles";
        }
        return "Rented: " + getColor() + " " + getMake() + " " + getModel() + " with " + getMileage() + " miles";

    }
}
class Economy_Car extends Vehicle{
    int daily_rental_rate;

    Economy_Car(){
        super();
        daily_rental_rate = 0;
    }
    Economy_Car(String make, String model, String color, int mileage, int originCost, int daily_rental_rate){
        super(make, model, color, mileage, originCost);
        this.daily_rental_rate = daily_rental_rate;
    }

    @Override
    public String toString(){
        return "Economy Car: " + super.toString();
    }
}

class Midsize_Car extends Vehicle{
    int daily_rental_rate;

    Midsize_Car(){
        super();
        daily_rental_rate = 0;
    }
    Midsize_Car(String make, String model, String color, int mileage, int originCost, int daily_rental_rate){
        super(make, model, color, mileage, originCost);
        this.daily_rental_rate = daily_rental_rate;
    }

    @Override
    public String toString(){
        return "Midsized Car: " + super.toString();
    }
}

class SUV extends Vehicle{
    int daily_rental_rate;

    SUV(){
        super();
        daily_rental_rate = 0;
    }
    SUV(String make, String model, String color, int mileage, int originCost, int daily_rental_rate){
        super(make, model, color, mileage, originCost);
        this.daily_rental_rate = daily_rental_rate;
    }

    @Override
    public String toString(){
        return "CSE1322L.SUV: " + super.toString();
    }
}

class Assignment3{
    public static ArrayList<Vehicle> myCars = new ArrayList<>();

    public static void show_cars(ArrayList<Vehicle> list){
        System.out.println("0. Return");
        for(int i = 0; i < list.size(); i++){
            System.out.println((i+1)+ ". " + list.get(i).toString());
        }
    }
    public static void rent_cars(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Choose a car to rent: ");
            show_cars(myCars);
            int choice = scan.nextInt();

            switch (choice){
                case 0:
                    main_menu();
                    break;
                case 1:
                    myCars.get(0).setRented(true);
                    break;
                case 2:
                    myCars.get(1).setRented(true);
                    break;
                case 3:
                    myCars.get(2).setRented(true);
                    break;
                case 4:
                    myCars.get(3).setRented(true);
                    break;
                case 5:
                    myCars.get(4).setRented(true);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }
    public static void return_cars(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Choose a car to return: ");
            show_cars(myCars);
            int choice = scan.nextInt();
            switch (choice){
                case 0:
                    main_menu();
                    break;
                case 1:
                    myCars.get(0).setRented(false);
                    break;
                case 2:
                    myCars.get(1).setRented(false);
                    break;
                case 3:
                    myCars.get(2).setRented(false);
                    break;
                case 4:
                    myCars.get(3).setRented(false);
                    break;
                case 5:
                    myCars.get(4).setRented(false);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }
    public static void main_menu(){
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("1. Rent cars");
            System.out.println("2. Return Cars");
            System.out.println("3. Quit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    rent_cars();
                    break;
                case 2:
                    return_cars();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        myCars.add(new Economy_Car("Nissan", "Versa", "Blue", 105, 14500, 25));
        myCars.add(new Economy_Car("Toyota", "Yaris", "White", 8422, 17500, 25));
        myCars.add(new Midsize_Car("Dodge", "Avenger", "Green", 15720, 15000, 45));
        myCars.add(new Midsize_Car("Ford", "Focus", "Yellow", 2368, 14500, 45));
        myCars.add(new SUV("Toyota", "Rav4", "Silver", 432, 26150, 80));

        main_menu();
    }
}
