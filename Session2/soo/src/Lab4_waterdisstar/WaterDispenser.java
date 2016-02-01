/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterdisstar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WONSEOB
 */
public class WaterDispenser implements Runnable {

    private int waterLevel;
    private boolean powerOn;
    private boolean coverOn;
    private boolean valveOn;
    private int maxCapacity;
    private int waterAmount;

    public WaterDispenser() {
        this.waterLevel = 0;
        this.powerOn = false;
        this.coverOn = false;
        this.valveOn = false;
        this.maxCapacity = 100;
    }

    public void powerOnOff() {
        this.powerOn = !this.powerOn;
    }

    public void coverOnOff() {
        this.coverOn = !this.coverOn;
    }

    public void valveOn() {
        this.valveOn = !this.valveOn;
    }

    public void dispenseWater(int amount) {
        if ((amount > 0 && amount <= this.waterLevel) && this.powerOn && this.valveOn) {
            this.waterLevel -= amount;
            System.out.println("Water is ready! Enjoy :D");
            for (int i = 0; i < amount; i++) {
                System.out.print("*");
            }
            System.out.print("  ->  ");
            System.out.println("This current water Level :" + this.waterLevel);
            autoFill();
        } else if (!this.powerOn) {
            System.out.println("The machine is off.");
        } else {
            System.out.println("We don't have enough water as amount as you want:D");
            System.out.println("Currently " + this.waterLevel + " ml of water is left.");
            autoFill();
        }
    }

    private void autoFill() {
        if (waterLevel < 50) {
            fillTank(100);
            System.out.println("The water was filled automatically.");
        }
    }

    public void fillTank(int amount) {
        this.waterLevel += amount;
        if (waterLevel > maxCapacity) {
            waterLevel = maxCapacity;
        }
        System.out.println("Currently " + this.waterLevel + " ml of water is left.");
    }

    public void run() {

        powerOnOff();
        coverOnOff();
        valveOn();
        fillTank(1300);
        dispenseWater(20);
        dispenseWater(30);
        fillTank(20);
        dispenseWater(120);
        dispenseWater(20);
    }
}
