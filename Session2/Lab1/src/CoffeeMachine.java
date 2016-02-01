
/**
 *
 * @author Won Seob
 */
public class CoffeeMachine {

    private final int MAX_WATER = 3000;
    private final int MAX_BEANS = 2000;
    private int waterLevel;
    private int beansLevel;
    private boolean poweredOn;
    /**
     * How many times this coffee machine is used after it was rinsed
     */
    private int time;

    /**
     * default constructor
     */
    public CoffeeMachine() {
        this(0, 0);
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
        this.time = 0;
    }

    public void powerOnOff() {
        this.poweredOn = !this.poweredOn;
        if (poweredOn) {
            System.out.println("The coffee machine is turned on");
        } else {
            System.out.println("The coffee machine is turned off");
        }
    }

    public void makeRegularCoffeeNTimes(int n) {
        for (int i = 0; i < n ; i++) {
            makeRegularCoffee();
        }
    }
    
    public void makeRegularCoffee() {
        if (this.waterLevel >= 150 && this.beansLevel >= 10 && this.poweredOn) {
            coffeeDoneMessage("regular coffee");
            this.waterLevel = this.waterLevel - 150;
            this.beansLevel = this.beansLevel - 10;
            this.time++;
            showCurrent();
            if (this.time > 10) {
                clean();
            }
        } else if (!this.poweredOn) {
            System.out.println("The machine is off.");
        } else {
            notEnoughSomethingMessage();
        }
    }

    public void makeEspressoCoffee() {
        if (this.waterLevel >= 30 && this.beansLevel >= 8 && this.poweredOn) {
            coffeeDoneMessage("espresso coffee");
            this.waterLevel = this.waterLevel - 30;
            this.beansLevel = this.beansLevel - 8;
            time++;
            showCurrent();
            if (this.time > 10) {
                clean();
            }
        } else if (!this.poweredOn) {
            System.out.println("The machine is off.");
        } else {
            notEnoughSomethingMessage();
        }
    }

    public void makeEspressoCoffeeNTimes(int n) {
        for (int i = 0; i < n ; i++) {
            makeEspressoCoffee();
        }
    }
    
    private void coffeeDoneMessage(String str) {
        System.out.println("Here is your " + str + " Enjoy your coffee.");
    }
    
    private void notEnoughSomethingMessage() {
        System.out.println("The Coffee machine has not enough water or coffee beans.");
    }
    
    private void showCurrent() {
        System.out.println("This is coffee machine's water level: " + this.waterLevel);
        System.out.println("This is coffee machine's bean level: " + this.beansLevel);
        System.out.println("You used coffee machine for the " + this.time + " times so far.");
    }

    public void fillWaterTank(int amount) {
        System.out.println("Trying to add " + amount + " beans.");
        this.waterLevel += amount;
        if (waterLevel > MAX_WATER) {
            waterLevel = MAX_WATER;
        }
        System.out.println("Currently " + this.waterLevel + " ml of water is left.");
    }

    public void fillBeansTank(int amount) {
        System.out.println("Trying to add " + amount + " beans.");
        this.beansLevel += amount;
        if (beansLevel > MAX_BEANS) {
            beansLevel = MAX_BEANS;
        }
        System.out.println("Currently " + this.beansLevel + " g of beans are left.");
    }

    public void clean() {
        System.out.println("You used coffee machine for the " + this.time + " times so far.");
        this.time = 0;
        System.out.println("Machine cleaned.");
    }

    @Override
    public String toString() {
        return "\"MAX_WATER\":"+MAX_WATER+",\"MAX_BEANS\":"+MAX_BEANS
                +",\"waterLevel\":"+waterLevel+",\"beansLevel\":"+beansLevel+",\"poweredOn\":"+poweredOn; //To change body of generated methods, choose Tools | Templates.
    }
}
