import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


/**
 * The test class DeliveryPersonTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
class Urgency {}
public class DeliveryPersonTest
{
    DeliveryPerson dp;
    Order order;
    Urgency urgency;
    DeliveryCompany company;
    //TODO
    //crear más campos (si es necesario) 
    /**
     * Default constructor for test class DeliveryPersonTest
     */
    public DeliveryPersonTest()
    {
    }

    /**
     * Create a delivery person.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        company = new DeliveryCompany("Compañía DP Delivery Cáceres");
        Location dpLocation = new Location(0, 0);
        Location pickup = new Location(1, 2);
        Location destination = new Location(5, 6);
        urgency = new Urgency();
        order = new Order("Kevin", pickup, destination, 10, 1.2, "Decathlon",urgency );
        dp = new DeliveryPerson(company, dpLocation,"DP1");
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        dp=null;
        order=null;
        
    }

    /**
     * Test creation and the initial state of a delivery person.
     */
    @Test
    public void testCreation()
    {
        assertEquals(true, dp.isFree());
        assertEquals("DP1", dp.getName());
        assertEquals(new Location(0, 0), dp.getLocation());
    }

    /**
     * Test that a delivery person is no longer free after this person has
     * picked up an order.
     */
    @Test
    public void testPickup()
    {
        TreeSet<Order> orders = new TreeSet<>();
        orders.add(order);
        dp.setOrdersToDeliver(orders);
        
        dp.pickup(order);
        assertFalse(dp.isFree());
        assertEquals(order.getDestination(), dp.getTargetLocation());
    }

    /**
     * Test that a delivery person becomes free again after delivering
     * an order.
     */
    @Test
    public void testDeliverOrder()
    {
        TreeSet<Order> orders = new TreeSet<>();
        orders.add(order);
        dp.setOrdersToDeliver(orders);
        dp.setWorking(true);
        
        dp.deliverOrder();
        assertTrue(dp.isFree());
        assertEquals(1, dp.ordersDelivered());
    }

    /**
     * Test that a delivery person picks up and delivers an order within
     * a reasonable number of steps.
     */
    @Test
    public void testDelivery()
    {
        TreeSet<Order> orders = new TreeSet<>();
        orders.add(order);
        dp.setOrdersToDeliver(orders);
        dp.setPickupLocation(order.getLocation());
        
        dp.act();
        dp.act();
        assertEquals(dp.getLocation(), dp.getTargetLocation());
        assertEquals(false, dp.isFree());
        dp.act();
        dp.act();
        dp.act();
        dp.act();
        assertEquals(dp.getLocation(), dp.getTargetLocation());
        assertEquals(true, dp.isFree());
        assertEquals(1, dp.ordersDelivered());
        
    }
}

