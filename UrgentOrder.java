
/**
 * Write a description of class UrgentOrder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UrgentOrder extends Order
{
    
    

    /**
     * Constructor for objects of class UrgentOrder
     */
    public UrgentOrder (String sendingName, Location location, Location destination, int deliveryTime, 
    double weight, String destinationName,Surcharge surcharge, Urgency urgency)
    {
       super(sendingName, location, destination, deliveryTime, weight, destinationName,surcharge, urgency);
       
    }

    @Override
    public int charge(){
        return(super.charge()*2);
    }
    
    @Override
    public int calculateEvaluationDP(){
        return 10;
    }
}
