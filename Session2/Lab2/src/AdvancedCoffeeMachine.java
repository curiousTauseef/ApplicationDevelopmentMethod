

import java.io.Serializable;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */

public class AdvancedCoffeeMachine extends CoffeeMachine implements Serializable {
    
    protected final int MAX_MILK = 2000;
    private int milkLevel;

    public int getMilkLevel() {
        return milkLevel;
    }
    
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
        this.milkLevel = 0;
        fillMilkTank(milkLevel);
    }
    
    public String fillMilkTank(int amount) {
        System.out.println("Trying to add " + amount + " ml of milk.");
        this.milkLevel += amount;
        if (milkLevel > MAX_MILK) {
            milkLevel = MAX_MILK;
        }
        return "\"message\":\"Finished filling up "+amount+"ml of milk\"";
    }
    
    public String makeCapuccinoCoffee() {
        if (this.waterLevel >= 50 && this.beansLevel >= 10 && this.milkLevel >= 10 && this.poweredOn) {
            this.waterLevel -= 50;
            this.beansLevel -= 10;
            this.milkLevel -= 50;
            coffeeDoneMessage("Capuccino");
        } else if (!this.poweredOn) {
            return machineOffMsg;
        } else {
            notEnoughSomethingMessage();
        }
        return "\"message\" : \"Capuccino is ready! Enjoy your Capuccino!\"";
    }

    public void makeCapuccinoNTimes(int n) {
        for (int i = 0; i < n; i++) {
            makeCapuccinoCoffee();
        }
    }
    protected String notEnoughSomethingMessage() {
        return "\"message\":\"The Coffee machine has not enough water, coffee beans, or milk\"";
    }
    @Override
    public String toString() {   
        return "\"MAX_WATER\":"+MAX_WATER+",\"MAX_BEANS\":"+MAX_BEANS+",\"MAX_MILK\":"+MAX_MILK
                +",\"waterLevel\":"+waterLevel+",\"beansLevel\":"+beansLevel+
                ",\"milkLevel\":"+milkLevel+",\"poweredOn\":"+poweredOn;
    }   
}