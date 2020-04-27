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

// Subclass of Bike Object
public class RoadBike extends Bike {
    
    private int reflectorsFitted;
    
    // Default Constructor of RoadBike Object
    public RoadBike () {
    }
    
    // Constructor of RoadBike Object with reflectorsFitted input
    public RoadBike (int reflectorsFitted) {
        this.reflectorsFitted = reflectorsFitted;
    }
    
    // Constructor of RoadBike Object with more inputs
    public RoadBike (String owner, String model, int wheelDiameter, int gears, 
                    int kmsRidden, int reflectorsFitted) {
        setOwner(owner);
        setModel(model);
        setWheelDiameter(wheelDiameter);
        setGears(gears);
        setKmsRidden(kmsRidden);
        this.reflectorsFitted = reflectorsFitted;
    }
    
    public void setReflectors (int reflectorsFitted) {      
        this.reflectorsFitted = reflectorsFitted;        
    }
    
    public int getReflectors () {      
        return reflectorsFitted;
    }
    
    // Overrides the toString() method in Bike superclass.
    // This method is modified to add the reflectorsFitted as output    
    @Override 
    public String toString(){
        String s = super.toString();
        return s + "|" + reflectorsFitted;
    }
    
    // Overrides the getServiceInterval() method in Bike Superclass
    // Implementation is modified so that it returns 
    // the service interval of RoadBike Object based on formula    
    @Override
    public int getServiceInterval(){
        return getKmsRidden()*reflectorsFitted; 
    }
    
}
