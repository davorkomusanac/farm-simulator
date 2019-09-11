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
public class MilkingRobot {
    
    private BulkTank bulkTank;
    
    public MilkingRobot() {
        
    }
    
    public BulkTank getBulkTank() {
        return this.bulkTank;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.bulkTank=tank;
    }
    
    public void milk(Milkable milkable) {
        try {            
            this.bulkTank.addToTank(milkable.milk());
        } catch (Exception e) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");            
        }
    }
}
