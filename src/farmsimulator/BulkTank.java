/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Davor
 */
public class BulkTank {
    
    private double capacity;
    private double volume = 0;
    
    public BulkTank() {
        this.capacity=2000;
    }
    
    public BulkTank(double capacity) {
        this.capacity=capacity;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity-this.volume;
    }
    
    public void addToTank(double amount) {
        if (amount > this.howMuchFreeSpace()) {
            this.volume = this.capacity;
        }
        else {
            this.volume += amount;
        } 
    }
    
    public double getFromTank(double amount) {
        double trueAmount = 0;
        if (amount > this.volume) {
            trueAmount = this.getVolume();
            this.volume = 0;
        }
        else {
            trueAmount = amount;
            this.volume -= amount;
        }
        return trueAmount;
    }
    
    public String toString() {
        return Math.ceil(this.getVolume()) + "/" + Math.ceil(this.getCapacity());
    }
}
