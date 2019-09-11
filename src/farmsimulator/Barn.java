/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.Collection;
/**
 *
 * @author Davor
 */
public class Barn {
    
    private BulkTank tank;
    private MilkingRobot robot;
    
    public Barn(BulkTank tank) {
        this.tank=tank;
    }
    
    public BulkTank getBulkTank() {
        return this.tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);
    }
    
    public void takeCareOf(Cow cow) {
        try {
            this.robot.milk(cow);
        } catch (Exception e ) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for (Cow cow : cows) {
            this.takeCareOf(cow);
        }
    }
    
    @Override
    public String toString() {
        return this.tank.toString();
    }
}
