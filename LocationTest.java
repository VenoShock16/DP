import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class LocationTest
{
    Location startLocation;
    Location destination;
    //TODO
    //crear más campos (si es necesario) 

    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
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
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        startLocation=null;
        destination=null;
    }

    /**
     * Test the distance method of the Location class.
     */
    @Test
    public void testDistance()
    {
        assertEquals(startLocation.distance(new Location(5, 7)), 5);
        assertEquals(startLocation.distance(destination), 1);
        assertTrue(startLocation.distance(destination) == 1);
    }

    /**
     * Run tests of the nextLocation method of the Location class.
     */
    @Test
    public void testAdjacentLocations()
    {
        
        Location next= startLocation.nextLocation(destination);
        assertEquals(startLocation.distance(next), 1);
    }
}
