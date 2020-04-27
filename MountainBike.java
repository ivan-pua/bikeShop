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

// Subclass of Bike 
public class MountainBike extends Bike {
    private int suspensionDepth;
    
    // Default Constructor for MountainBike Object
    public MountainBike () {       
    }
    
    // Constructor for MountainBike Object with suspensionDepth
    public MountainBike (int suspensionDepth) {
        this.suspensionDepth = suspensionDepth;
    }
    
    // Constructor for MountainBike Object with more inputs
    public MountainBike (String owner, String model, int wheelDiameter, int gears, 
                    int kmsRidden, int suspensionDepth) {
        // Sets the user inputs into the superclass fields
        setOwner(owner);
        setModel(model);
        setWheelDiameter(wheelDiameter);
        setGears(gears);
        setKmsRidden(kmsRidden);
        this.suspensionDepth = suspensionDepth;
    }
    
    public void setSuspensionDepth (int suspensionDepth) {      
        this.suspensionDepth = suspensionDepth;       
    }
    
    public int getSuspensionDepth () {            
        return suspensionDepth;
    }
    
    // Overrides the toString() method in Bike superclass.
    // This method is modified to add the suspensionDepth as output
    @Override 
    public String toString(){
        String s = super.toString();
        return s + "|" + suspensionDepth;
    }

    // Overrides the getServiceInterval() method in Bike Superclass
    // Implementation is modified so that it returns 
    // the service interval of MoutainBike Object based on formula
    @Override
    public int getServiceInterval(){
        return getWheelDiameter()*getGears()-suspensionDepth;
    }
}
