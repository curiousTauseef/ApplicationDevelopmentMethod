package Model;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class AdvancedCoffeeMachine extends CoffeeMachine implements Serializable {
    
    private final int MAX_MILK = 2000;
    private int milkLevel;
    
    /**
     * default constructor
     */
    public AdvancedCoffeeMachine() {
        this(0);
    }

    public AdvancedCoffeeMachine(int waterLevel) {
        this(waterLevel, 0);
    }

    public AdvancedCoffeeMachine(int waterLevel, int beansLevel) {
        this(waterLevel, beansLevel, 0);
    }
    
    public AdvancedCoffeeMachine(int waterLevel, int beansLevel, int milkLevel) {
        super(waterLevel, beansLevel);
        this.milkLevel = milkLevel;
    }
    
    public void fillMilkTank(int amount) {
        System.out.println("Trying to add " + amount + " ml of milk.");
        this.milkLevel += amount;
        if (milkLevel > MAX_MILK) {
            milkLevel = MAX_MILK;
        }
        System.out.println("Currently " + this.milkLevel + " ml of milk is left.");
    }
    
    public void makeCapuccinoCoffee() {
        if (this.waterLevel >= 50 && this.beansLevel >= 10 && this.milkLevel >= 10 && this.poweredOn) {
            coffeeDoneMessage("espresso coffee");
            this.waterLevel -= 50;
            this.beansLevel -= 10;
            this.milkLevel -= 50;
        } else if (!this.poweredOn) {
            System.out.println("The machine is off.");
        } else {
            notEnoughSomethingMessage();
        }
    }
   

    public void makeCapuccinoNTimes(int n) {
        for (int i = 0; i < n; i++) {
            makeCapuccinoCoffee();
        }
    }
}