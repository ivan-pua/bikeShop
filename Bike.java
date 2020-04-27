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
// Superclass
public class Bike {
    
    private String type;
    private String owner;
    private String model;
    private int wheelDiameter;
    private int gears;
    private int kmsRidden;
    
    // Default constructor for Bike Object
    public Bike(){       
    }
    
    // Constructor for Bike Object with more parameters
    public Bike(String owner, String model, int wheelDiameter, int gears, 
                int kmsRidden) {
        this.owner = owner;
        this.model = model;
        this.wheelDiameter = wheelDiameter;
        this.gears = gears;
        this.kmsRidden = kmsRidden;
        
    }
    
    // Setters and Getters
    public void setBikeType(String type){
        this.type = type;       
    }
    
    public String getBikeType(){
        return this.type;       
    }
    
    public void setOwner(String owner){
        this.owner = owner;       
    }
    
    public String getOwner(){
        return this.owner;       
    }
    
    public void setModel(String model){
        this.model = model;       
    }
    
    public String getModel(){
        return this.model;       
    }

    public void setGears(int gears){
        this.gears = gears;       
    }
    
    public int getGears(){
        return this.gears;       
    }
    
    public void setWheelDiameter(int wheelDiameter){
        this.wheelDiameter = wheelDiameter;       
    }
    
    public int getWheelDiameter(){
        return this.wheelDiameter;       
    }
  
    public void setKmsRidden(int kmsRidden){
        this.kmsRidden = kmsRidden;       
    }

    public int getKmsRidden(){
        return this.kmsRidden;       
    }

    // Prints in the same format as bikeString inputs
    public String toString(){
        String s = this.type + "|" + this.owner + "|" + this.model + "|"
                    + this.wheelDiameter + "|" 
                    + this.gears + "|" + this.kmsRidden;
        
        return s;
    }
    
    // Returns the service interval of Bike Object based on formula
    public int getServiceInterval (){
        int nameLength = owner.length();
        return nameLength*gears;
    }
    
}
