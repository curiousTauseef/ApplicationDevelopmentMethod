package Model;


import java.io.Serializable;


/**
 *
 * @author Won Seob
 */
public class CoffeeMachine implements Serializable {

    protected final int MAX_WATER = 3000;
    protected final int MAX_BEANS = 2000;
    protected int waterLevel;
    protected int beansLevel;
    protected boolean poweredOn;
    protected final String machineOffMsg = "\"message\":\"The machine is off. Please turn it on before you use it.\"";

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getBeansLevel() {
        return beansLevel;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }

    /**
     * default constructor
     */
    public CoffeeMachine() {
        this(0);
    }

    public CoffeeMachine(int waterLevel) {
        this(waterLevel, 0);
    }

    public CoffeeMachine(int waterLevel, int beansLevel) {
        this.waterLevel = 0;
        this.beansLevel = 0;
        fillWaterTank(waterLevel);
        fillBeansTank(beansLevel);
        this.poweredOn = false;
    }

    public String powerOnOff() {
        this.poweredOn = !this.poweredOn;
        if (poweredOn) {
            return "\"message\":\"The coffee machine is turned on\"";
        } else {
            return "\"message\":\"The coffee machine is turned off\"";
        }
    }

    public void makeRegularCoffeeNTimes(int n) {
        for (int i = 0; i < n; i++) {
            makeRegularCoffee();
        }
    }

    public String makeRegularCoffee() {
        if (this.waterLevel >= 150 && this.beansLevel >= 10 && this.poweredOn) {
            this.waterLevel = this.waterLevel - 150;
            this.beansLevel = this.beansLevel - 10;
            return coffeeDoneMessage("regular coffee");
        } else if (!this.poweredOn) {
            return machineOffMsg;
        } else {
            return notEnoughSomethingMessage();
        }
    }

    public String makeEspressoCoffee() {
        if (this.waterLevel >= 30 && this.beansLevel >= 8 && this.poweredOn) {
            this.waterLevel = this.waterLevel - 30;
            this.beansLevel = this.beansLevel - 8;
            return coffeeDoneMessage("espresso coffee");
        } else if (!this.poweredOn) {
            return machineOffMsg;
        } else {
            return notEnoughSomethingMessage();
        }
    }

    public void makeEspressoCoffeeNTimes(int n) {
        for (int i = 0; i < n; i++) {
            makeEspressoCoffee();
        }
    }

    protected String coffeeDoneMessage(String str) {
        return "\"message\":\"Here is your " + str + " Enjoy your coffee.\"";
    }

    protected String notEnoughSomethingMessage() {
        return "\"message\":\"The Coffee machine has not enough water or coffee beans\"";
    }

    public String fillWaterTank(int amount) {
        System.out.println("Trying to add " + amount + " beans.");
        this.waterLevel += amount;
        if (waterLevel > MAX_WATER) {
            waterLevel = MAX_WATER;
        }
        System.out.println("Currently " + this.waterLevel + " ml of water is left.");
        return "\"message\":\"Finished filling up "+amount+"ml of water\"";
    }

    public String fillBeansTank(int amount) {
        System.out.println("Trying to add " + amount + " beans.");
        this.beansLevel += amount;
        if (beansLevel > MAX_BEANS) {
            beansLevel = MAX_BEANS;
        }
        System.out.println("Currently " + this.beansLevel + " g of beans are left.");
        return "\"message\":\"Finished filling up "+amount+"g of coffee beans\"";
    }

    @Override
    public String toString() {   
        return "\"MAX_WATER\":"+MAX_WATER+",\"MAX_BEANS\":"+MAX_BEANS
                +",\"waterLevel\":"+waterLevel+",\"beansLevel\":"+beansLevel+",\"poweredOn\":"+poweredOn;
    }   
}
