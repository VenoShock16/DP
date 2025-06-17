
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
 @Override
 public String showFinalInfo()
    {
        //TODO  implementar este método
        return "@@@SpecialDP "+ getName() +" at location "+ getLocation() + " - orders delivered: "+
        ordersDelivered() +" - non active for: " + getIdleCount() + " times  - total to be collected: "
        + obtainTotalCharge() + " -Valuation: "+ obtainValuation();

    }
    
}
