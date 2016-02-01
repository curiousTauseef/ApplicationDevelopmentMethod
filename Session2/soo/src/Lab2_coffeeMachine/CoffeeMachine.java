/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachine;

/**
 *
 * @author HyeSoo
 */
public class CoffeeMachine {

    private final int MAXWATER = 30000;
    private final int MAXBEANS = 1800;
    private int waterTankLevel;
    private int beansTankLevel;
    private boolean powerOn;
    private int time;

    /**
     * @param args the command line arguments
     */
    public CoffeeMachine() {
        this.waterTankLevel = 0;
        this.beansTankLevel = 0;
        this.powerOn = false;
        this.time = 0;
    }

    public void powerOnOff() {
        this.powerOn = !this.powerOn;
        rinse();
    }

    public void makeRegularcoffee() {
        if (this.waterTankLevel >= 150 && this.beansTankLevel >= 10 && this.powerOn) {
            givingCoffeeMessage("regular coffee");
            this.waterTankLevel = this.waterTankLevel - 150;
            this.beansTankLevel = this.beansTankLevel - 10;
            this.time++;
            showCurrent();
            if (this.time > 10) {
                clean();
            }
        } else if (!this.powerOn) {
            System.out.println("The machine is off.");
        } else {
            System.out.println("The Coffee machine has a lack of water or coffee beans.");
        }
    }

    public void makeEspressocoffee() {
        if (this.waterTankLevel >= 30 && this.beansTankLevel >= 8 && this.powerOn) {
            givingCoffeeMessage("espresso coffee");
            this.waterTankLevel = this.waterTankLevel - 30;
            this.beansTankLevel = this.beansTankLevel - 8;
            time++;
            showCurrent();
            if (this.time > 10) {
                clean();
            }
        } else if (!this.powerOn) {
            System.out.println("The machine is off.");
        } else {
            System.out.println("The Coffee machine has a lack of water or coffee beans.");
        }
    }

    private void givingCoffeeMessage(String str) {
        System.out.println("Welcome to Metropolia Cafe :D");
        System.out.println("Thank you for ordering " + str + " Enjoy your coffee.");
    }

    private void showCurrent() {
        System.out.println("This is coffee machine's water level: " + this.waterTankLevel);
        System.out.println("This is coffee machine's bean level: " + this.beansTankLevel);
        System.out.println("You used coffee machine for the " + this.time + " times so far.");
    }

    public void fillWaterTank(int amount) {
        this.waterTankLevel += amount;
        if (waterTankLevel > MAXWATER) {
            waterTankLevel = MAXWATER;
        }
        System.out.println("Currently " + this.waterTankLevel + " ml of water is left.");
    }

    public void fillBeansTank(int amount) {
        this.beansTankLevel += amount;
        if (beansTankLevel > MAXBEANS) {
            beansTankLevel = MAXBEANS;
        }
        System.out.println("Currently " + this.beansTankLevel + " g of beans are left.");
    }

    public void clean() {
        if (waterTankLevel >= 300 && powerOn) {
            this.waterTankLevel -= 300;
            System.out.println("You used coffee machine for the " + this.time + " times so far.");
            this.time = 0;
            System.out.println("Machine cleaned.");
        } else if (!powerOn) {
            System.out.println("Machine is not turned on.");
        } else {
            System.out.println("Not enough water.");
        }
    }

    public void rinse() {
        if (waterTankLevel >= 25) {
            this.waterTankLevel -= 25;
            this.time--;
            if (this.time < 0) {
                this.time = 0;
            }
            System.out.println("Machine rinsed.");
        } else {
            System.out.println("Not enough water. Rinsing failed.");
        }
    }

}
