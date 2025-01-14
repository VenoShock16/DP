
/**
 * Write a description of class SpecialDP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialDP extends DeliveryPerson
{
    /**
     * Constructor for objects of class SpecialDP
     */
    public SpecialDP(DeliveryCompany company, Location location, String name)
    {
        super(company,  location,  name);
        setMaxLoad(1);
    }

    
}
