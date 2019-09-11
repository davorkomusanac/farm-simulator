/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Davor
 */
public class Cow implements Milkable, Alive {

    private String name;
    private double udderCapacity;
    private double availableMilk;
    private Random random = new Random();
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = this.randomCowName();
        this.udderCapacity = this.randomUdderCapacity();
    }

    public Cow(String name) {
        this.name = name;
        this.udderCapacity = this.randomUdderCapacity();
    }

    private String randomCowName() {
        int numberName = random.nextInt(NAMES.length);
        return NAMES[numberName];
    }

    private int randomUdderCapacity() {
        return 15 + random.nextInt(26);
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.udderCapacity;
    }

    public double getAmount() {
        return this.availableMilk;
    }

    public String toString() {
        return this.getName() + " " + Math.ceil(this.getAmount()) + "/" + Math.ceil(this.getCapacity());
    }

    @Override
    public double milk() {
        double milk = this.availableMilk;
        this.availableMilk = 0;
        return milk;
    }

    @Override
    public void liveHour() {
        double milkMade = 0.7 + (2 - 0.7) * this.random.nextDouble();
        if ((this.availableMilk + milkMade) > this.udderCapacity) {
            this.availableMilk = this.udderCapacity;
        } else {
            this.availableMilk += milkMade;
        }
    }

}
