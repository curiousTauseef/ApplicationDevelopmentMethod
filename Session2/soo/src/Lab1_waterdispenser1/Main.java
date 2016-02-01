/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_waterdispenser1;

/**
 *
 * @author WONSEOB
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        WaterDispenser1 waterDispenser = new WaterDispenser1();
        waterDispenser.powerOnOff();
        waterDispenser.coverOnOff();
        waterDispenser.fillTank(100);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.dispenseWater(20);
        waterDispenser.fillTank(20);
        waterDispenser.dispenseWater(120);
        waterDispenser.dispenseWater(20);
    }
}
