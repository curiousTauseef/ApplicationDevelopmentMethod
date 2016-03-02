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
public class CoffeeMachineTest {
    
    public CoffeeMachineTest() {
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
     * Test of getWaterLevel method, of class CoffeeMachine.
     */
    @Test
    public void testGetWaterLevel() {
        System.out.println("getWaterLevel");
        CoffeeMachine instance = new CoffeeMachine();
        int expResult = 0;
        int result = instance.getWaterLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBeansLevel method, of class CoffeeMachine.
     */
    @Test
    public void testGetBeansLevel() {
        System.out.println("getBeansLevel");
        CoffeeMachine instance = new CoffeeMachine();
        int expResult = 0;
        int result = instance.getBeansLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPoweredOn method, of class CoffeeMachine.
     */
    @Test
    public void testIsPoweredOn() {
        System.out.println("isPoweredOn");
        CoffeeMachine instance = new CoffeeMachine();
        boolean expResult = false;
        boolean result = instance.isPoweredOn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of powerOnOff method, of class CoffeeMachine.
     */
    @Test
    public void testPowerOnOff() {
        System.out.println("powerOnOff");
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.powerOnOff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeRegularCoffeeNTimes method, of class CoffeeMachine.
     */
    @Test
    public void testMakeRegularCoffeeNTimes() {
        System.out.println("makeRegularCoffeeNTimes");
        int n = 0;
        CoffeeMachine instance = new CoffeeMachine();
        instance.makeRegularCoffeeNTimes(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeRegularCoffee method, of class CoffeeMachine.
     */
    @Test
    public void testMakeRegularCoffee() {
        System.out.println("makeRegularCoffee");
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.makeRegularCoffee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeEspressoCoffee method, of class CoffeeMachine.
     */
    @Test
    public void testMakeEspressoCoffee() {
        System.out.println("makeEspressoCoffee");
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.makeEspressoCoffee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeEspressoCoffeeNTimes method, of class CoffeeMachine.
     */
    @Test
    public void testMakeEspressoCoffeeNTimes() {
        System.out.println("makeEspressoCoffeeNTimes");
        int n = 0;
        CoffeeMachine instance = new CoffeeMachine();
        instance.makeEspressoCoffeeNTimes(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coffeeDoneMessage method, of class CoffeeMachine.
     */
    @Test
    public void testCoffeeDoneMessage() {
        System.out.println("coffeeDoneMessage");
        String str = "";
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.coffeeDoneMessage(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notEnoughSomethingMessage method, of class CoffeeMachine.
     */
    @Test
    public void testNotEnoughSomethingMessage() {
        System.out.println("notEnoughSomethingMessage");
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.notEnoughSomethingMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillWaterTank method, of class CoffeeMachine.
     */
    @Test
    public void testFillWaterTank() {
        System.out.println("fillWaterTank");
        int amount = 0;
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.fillWaterTank(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillBeansTank method, of class CoffeeMachine.
     */
    @Test
    public void testFillBeansTank() {
        System.out.println("fillBeansTank");
        int amount = 0;
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.fillBeansTank(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CoffeeMachine.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CoffeeMachine instance = new CoffeeMachine();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
