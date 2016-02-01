/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class User {

    public static void main(String[] args) {

        CoffeeMachine cf = new CoffeeMachine(1500, 1000);
        System.out.println("to string method");
        System.out.println(cf);
//        //create 3 coffee machines in an array using different constructors
//        System.out.println("create 3 coffee machines in an array using different constructors");
//        CoffeeMachine[] machines = new CoffeeMachine[3];
//        machines[0] = new CoffeeMachine();
//        machines[1] = new CoffeeMachine(1000);
//        machines[2] = new CoffeeMachine(1500, 1000);
//
//        // turn the machines on
//        System.out.println("turn the machines on");
//        for (CoffeeMachine m : machines) {
//            m.powerOnOff();
//        }
//        
//        for (int i = 0; i < machines.length; i++) {
//            System.out.println("Iteration for machine No " + (i+1));
//            // fill beans and waters and make coffee
//            System.out.println("fill beans and waters and make coffee");
//            machines[i].fillBeansTank(1000);
//            machines[i].fillWaterTank(1000);
//            machines[i].makeRegularCoffeeNTimes(5);
//            machines[i].makeEspressoCoffeeNTimes(5);
//            
//            System.out.println("Turn off and try to use it");
//            // Turn off and try to use it
//            machines[i].powerOnOff();
//            machines[i].makeEspressoCoffee();
//            machines[i].makeRegularCoffee();
//            
//            System.out.println("Turn it on again");
//            // Turn it on again
//            machines[i].powerOnOff();
//            machines[i].makeEspressoCoffee();
//            machines[i].makeRegularCoffee();
//            
//            System.out.println("Try to overuse it");
//            // try to overuse it
//            machines[i].makeRegularCoffeeNTimes(20);
//            machines[i].makeEspressoCoffeeNTimes(20);
//            
//            // Turn off
//            machines[i].powerOnOff();
//        }

    }
}
