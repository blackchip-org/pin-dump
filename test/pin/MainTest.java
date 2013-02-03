/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcgann
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMain() throws Exception {
    }

    @Test
    public void testNibbles() {
        int b = 0xfe;

        int l = Main.low(b);
        int h = Main.high(b);

        assertEquals(0xe, l);
        assertEquals(0xf, h); 
    }

}