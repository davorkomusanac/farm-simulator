/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.Collection;
import java.util.HashSet;
/**
 *
 * @author Davor
 */
public class Farm implements Alive {
    
    private String owner;
    private Barn barn;
    private Collection<Cow> cows;
    
    public Farm(String owner,Barn barn) {
        this.owner=owner;
        this.barn=barn;
        this.cows = new HashSet<Cow>();
    }
    
    public void addCow(Cow cow) {
        this.cows.add(cow);
    }
    
    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }        
    
    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }
    
    @Override
    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public String toString() {
        if (this.cows.isEmpty()) {
            return ("Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n"
                + "No cows.");               
        }                
        else {
            String text = "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n"
                + "Animals:" + "\n";
            String cowText = "";
            for (Cow cow : this.cows) {
                cowText += "        " + cow.toString() + "\n";
            }
            text += cowText;
            return text;
        }
    }
}
