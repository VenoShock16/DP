import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrderTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class OrderTest
{
    /**
     * Default constructor for test class OrderTest
     */
    Order Oaux;
    Urgency urgency;
    public OrderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
        {
        Oaux = new Order("Pep Guardiola", new Location(5,5), new Location(9,1), 13, 
            1.4, "Manchester", urgency);
        }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
       Oaux= null;
    }

    /**
     * Test basic creation of an order.
     * Ensure that the location and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {
      
         assertEquals("Pep Guardiola", Oaux.getSendingName());
        assertEquals(new Location(9,1), Oaux.getDestination());
        assertEquals(13, Oaux.getDeliveryTime());
        assertEquals("Manchester", Oaux.getDestinationName());
        assertEquals(urgency, Oaux.getUrgency());
    }
    

    /**
     * Test of the getDeliveryPersonName method.
     * Ensure that this method gets and returns the name of the delivery person correctly.
     */
    @Test
    public void testGetDeliveryPersonName()
    {
        
        Oaux.setDeliveryPersonName("DP1");
        String aux=Oaux.getDeliveryPersonName();
        assertEquals("DP1", aux);
    }

    /**
     * Test of the getDestination method.
     * Ensure that this method gets and returns the destination location correctly.
     */
    @Test
    public void testGetDestination ()
    {
        Location aux= Oaux.getDestination();
        assertEquals(new Location(9,1) ,  aux );
    }
}
