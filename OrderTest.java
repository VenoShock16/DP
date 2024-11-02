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
        
        Oaux= new Order("Pep Guardiola",new Location(5,5), new Location(9,1), 13, 
         1.4,  "Manchester");
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
        //TODO implementar este método
        // Testear la creación correcta de objetos de tipo Order comprobando 
        // que la inicialización de campos como dirección de recogida y destino es correcta.
        Order Oaux= new Order("Pep Guardiola",new Location(5,5), new Location(9,1), 13, 
         1.4,  "Manchester");
         assertEquals(Oaux.getSendingName(), "Pep Guardiola");
        assertEquals(Oaux.getDestination(), new Location(9,1));
        assertEquals(Oaux.getDeliveryTime(), 13);
        assertEquals(Oaux.getDestinationName(), "Manchester");
    }
    

    /**
     * Test of the getDeliveryPersonName method.
     * Ensure that this method gets and returns the name of the delivery person correctly.
     */
    @Test
    public void testGetDeliveryPersonName()
    {
        Order Oaux= new Order("Pep Guardiola",new Location(5,5), new Location(9,1), 13, 
         1.4,  "Manchester");
         Oaux.setDeliveryPersonName("DP1");
        //TODO implementar este método
        // Testear el método que devuelve el nombre del la persona que ha hecho el 
        // reparto
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
        Order Oaux= new Order("Pep Guardiola",new Location(5,5), new Location(9,1), 13, 
         1.4,  "Manchester");
        //TODO implementar este método
        // Testear el método que devuelve la dirección de envío del objeto.
        Location aux= Oaux.getDestination();
        assertEquals(new Location(9,1) ,  aux );
    }
}
