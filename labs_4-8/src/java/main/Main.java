package main;

import device.AvailableDevices;
import device.ElectronicDevice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);


    public static void mainMenu(){

        ArrayList<ElectronicDevice> allDevices = new ArrayList<>(AvailableDevices.baseDevices());
        int choice = 0;
        do{
            MenuManaging.mainMenuText();
            choice = input.nextInt();
            MenuManaging.menuManaging(choice, allDevices);

        }while(choice != 5);
    }

    public static void main(String[] args){
        mainMenu();
    }
}