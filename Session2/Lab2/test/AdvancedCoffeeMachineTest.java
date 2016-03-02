/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class AdvancedCoffeeMachineTest {
    
    public AdvancedCoffeeMachineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fillMilkTank method, of class AdvancedCoffeeMachine.
     */
    @Test
    public void testFillMilkTank() {
        System.out.println("fillMilkTank");
        int amount = 50;
        AdvancedCoffeeMachine instance = new AdvancedCoffeeMachine();
        String expResult = "\"message\":\"Finished filling up "+amount+"ml of milk\"";
        String result = instance.fillMilkTank(amount);
        assertEquals(expResult, result);
    }

    /**
     * Test of makeCapuccinoCoffee method, of class AdvancedCoffeeMachine.
     */
    @Test
    public void testMakeCapuccinoCoffee() {
        System.out.println("makeCapuccinoCoffee");
        AdvancedCoffeeMachine instance = new AdvancedCoffeeMachine();
        instance.powerOnOff();
        String expResult = "\"message\" : \"Capuccino is ready! Enjoy your Capuccino!\"";
        String result = instance.makeCapuccinoCoffee();
        assertEquals(expResult, result);
    }

    /**
     * Test of makeCapuccinoNTimes method, of class AdvancedCoffeeMachine.
     */
    @Test
    public void testMakeCapuccinoNTimes() {
        System.out.println("makeCapuccinoNTimes");
        int n = 0;
        AdvancedCoffeeMachine instance = new AdvancedCoffeeMachine();
        instance.makeCapuccinoNTimes(n);
        
    }

    /**
     * Test of notEnoughSomethingMessage method, of class AdvancedCoffeeMachine.
     */
    @Test
    public void testNotEnoughSomethingMessage() {
        System.out.println("notEnoughSomethingMessage");
        AdvancedCoffeeMachine instance = new AdvancedCoffeeMachine();
        String expResult = "\"message\":\"The Coffee machine has not enough water, coffee beans, or milk\"";
        String result = instance.notEnoughSomethingMessage();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class AdvancedCoffeeMachine.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AdvancedCoffeeMachine instance = new AdvancedCoffeeMachine();
        String expResult = "\"MAX_WATER\":"+instance.MAX_WATER+",\"MAX_BEANS\":"+instance.MAX_BEANS+",\"MAX_MILK\":"+instance.MAX_MILK
                +",\"waterLevel\":"+instance.waterLevel+",\"beansLevel\":"+instance.beansLevel+
                ",\"milkLevel\":"+instance.getMilkLevel()+",\"poweredOn\":"+instance.poweredOn;
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
