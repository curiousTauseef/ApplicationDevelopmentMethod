package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class User  {

    public static void main(String[] args) {

        //create 3 coffee machines in an array using different constructors
        System.out.println("create 4 coffee machines in an array using different constructors");
        AdvancedCoffeeMachine[] machines = new AdvancedCoffeeMachine[4];
        machines[0] = new AdvancedCoffeeMachine();
        machines[1] = new AdvancedCoffeeMachine(1000);
        machines[2] = new AdvancedCoffeeMachine(1500, 1000);
        machines[3] = new AdvancedCoffeeMachine(1500, 1000, 1000);

        // turn the machines on
        System.out.println("turn the machines on");
        for (AdvancedCoffeeMachine m : machines) {
            m.powerOnOff();
        }
        
        for (int i = 0; i < machines.length; i++) {
            System.out.println("Iteration for machine No " + (i+1));
            // fill beans and waters and make coffee
            System.out.println("fill beans and waters and make coffee");
            machines[i].fillBeansTank(1000);
            machines[i].fillWaterTank(1000);
            machines[i].fillMilkTank(1000);
            machines[i].makeRegularCoffeeNTimes(5);
            machines[i].makeEspressoCoffeeNTimes(5);
            machines[i].makeCapuccinoNTimes(5);
            
            System.out.println("Turn off and try to use it");
            // Turn off and try to use it
            machines[i].powerOnOff();
            machines[i].makeEspressoCoffee();
            machines[i].makeRegularCoffee();
            machines[i].makeCapuccinoCoffee();
            
            System.out.println("Turn it on again");
            // Turn it on again
            machines[i].powerOnOff();
            machines[i].makeEspressoCoffee();
            machines[i].makeRegularCoffee();
            machines[i].makeCapuccinoCoffee();
            
            System.out.println("Try to overuse it");
            // try to overuse it
            machines[i].makeRegularCoffeeNTimes(10);
            machines[i].makeEspressoCoffeeNTimes(10);
            machines[i].makeCapuccinoNTimes(10);
            // Turn off
            machines[i].powerOnOff();
        }
    }
}
