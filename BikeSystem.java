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
 
// BikeSystem class maintains the different objects - 
// Bike, MountainBike, RoadBike
public class BikeSystem{
	
    private int numBikes;
    private int bikeCount = 0; // there are no bikes at the start
    private Bike bikes[];
    
    // Local fields are initilised for easy storage
    private String owner;
    private String model;
    private int wheelDiameter;
    private int gears;
    private int kmsRidden;

    // Default Constructor for Bike System, 
    // with the input being the number of bieks the system can hold
    public BikeSystem(int num){
        numBikes = num;
        Bike temp[] = new Bike[num];
        bikes = temp;
    }
    
    // Returns false if bike already exists or BikeSystem is full
    // Returns true is Bike object was succesfully created. 
    public boolean insertBike(String bikeString) {
        
        if(isFull() == true){ // isFull() method checks if the system is full
            return false;
        }
        
        // Parse the bikeString into various fields
        String[] tokens = bikeString.split("[|]");
        int length = tokens.length;
        
        owner = tokens[1];
        model = tokens[2];
        wheelDiameter = Integer.parseInt(tokens[3]); // convert string to int
        gears = Integer.parseInt(tokens[4]);
        kmsRidden = Integer.parseInt(tokens[5]);
        
        // Check if bike already exists
        if(bikeCount > 0 && bikeExists(tokens[1], tokens[2]) == true) {
            return false;
        }
        
        // Creates either a Bike, MountainBike, or RoadBike object
        if(length == 7) { 
            
            // MountainBike case
            if(tokens[0].equals("MTB")){ 
                int suspensionDepth = Integer.parseInt(tokens[6]);
                MountainBike b = new MountainBike(owner, model, 
                    wheelDiameter, gears, 
                    kmsRidden, suspensionDepth);
                b.setBikeType(tokens[0]);
                bikes[bikeCount] = b;
            
            //  RoadBike case
            } else {    
                int reflectorsFitted = Integer.parseInt(tokens[6]);
                RoadBike b = new RoadBike(owner, model, 
                    wheelDiameter, gears, 
                    kmsRidden, reflectorsFitted);
                b.setBikeType(tokens[0]);
                bikes[bikeCount] = b;
            }
        
        // Normal Bike Case
        } else {
            Bike b = new Bike(owner, model, wheelDiameter, 
                              gears, kmsRidden);
            b.setBikeType(tokens[0]);
            bikes[bikeCount] = b;
        }

        bikeCount = bikeCount + 1;
        // Successfully created Bike Object
        return true;
    }
    
    // Checks if the bike exists in the system.
    public boolean bikeExists(String owner, String model) {
        
        for (int i = 0; i < bikeCount; i++){
            String currentOwner = bikes[i].getOwner();
            String currentModel = bikes[i].getModel();
            // Compares owner and model strings
            if(currentOwner.equals(owner) && currentModel.equals(model)){
                return true;
            }           
        }
        return false;
    }
    
    // Prints the Bike details in the same format as the bikeString inputs.
    public void printSystem() {
        
        for(int i = 0; i < bikes.length; i++){
            System.out.println(bikes[i].toString());
        }
       
    }
    
    // Empties the bike shop and restores it to empty state.
    public void closeShop() {
        this.bikeCount = 0;
        for (int i = 0; i < bikes.length; i++) {
            bikes[i] = null;
        }
    }
    
    // Helper method to check if BikeSystem is full
    private boolean isFull(){
        
        if(bikeCount >= numBikes){
            return true;         
        }
        return false;
    }
    
    // Print a list of bike owner, models and service intervals
    public void printServiceIntervals() {
        
        for(int i = 0; i < bikes.length; i++){
            int serviceInterval = bikes[i].getServiceInterval();
            
            String s = bikes[i].getOwner() + ", " + bikes[i].getModel() + ", " 
                        + serviceInterval;
            System.out.println(s);
        }
    }
}
