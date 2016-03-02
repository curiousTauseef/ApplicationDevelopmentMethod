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
public class SimpleMathTest {
    
    public SimpleMathTest() {
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
     * Test of add method, of class SimpleMath.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int a = 5;
        int b = 6;
        SimpleMath instance = new SimpleMath();
        int expResult = 11;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of multiply method, of class SimpleMath.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        int a = 3;
        int b = 4;
        SimpleMath instance = new SimpleMath();
        int expResult = 12;
        int result = instance.multiply(a, b);
        assertEquals(expResult, result);
    }
    
}
