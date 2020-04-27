/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package ass2PartB;

/**
 *
 * @author puaqieshang
 */

// Main tester/driver file
import java.util.Scanner;

public class TestBikeSystem{
	
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("How many bikes are there: ");
        int num = scan.nextInt();

        BikeSystem system = new BikeSystem(num);
        String newLine = scan.nextLine(); // for new line
        System.out.println("Please input bikes (press enter twice to stop):  ");
        // Continues scanning until no more bikeString input i.e. 
        // there is a new empty line
        while (scan.hasNextLine()) {
            String bikeString = scan.nextLine();
            
            // To terminate scan
            if (bikeString.equals(newLine)){
                scan.close(); 
                break;
            }
            
            // If System is full or bike already exists, continue
            if(system.insertBike(bikeString) == false) {
                continue;
            }
        }
        
        // Methods to be called
        system.printSystem();
        
        System.out.println("Service Intervals: ");
        system.printServiceIntervals();
        system.closeShop();
    }

	
}
