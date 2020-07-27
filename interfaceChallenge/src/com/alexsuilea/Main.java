package com.alexsuilea;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player alex = new Player("Alex", 20, 25);
        System.out.println(alex.toString());
        saveObject(alex);

        alex.setHitPoints(25);
        System.out.println(alex);
        alex.setWeapon("AK47");
        saveObject(alex);
        //loadObject(alex);
        System.out.println(alex);

        ISavable werewolf = new Monster("Werewolf", 30,40);
        System.out.println("Strength = " +((Monster) werewolf).getStrength());
        System.out.println(werewolf);
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISavable objectToSave){
        for(int i=0; i<objectToSave.write().size(); i++){
            System.out.println("Saving " +objectToSave.write().get(i)+ " to storage device");
        }
    }

    public static void loadObject(ISavable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
