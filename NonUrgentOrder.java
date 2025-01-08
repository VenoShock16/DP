
/**
 * Write a description of class NonUrgentOrder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NonUrgentOrder extends Order
{
    

    /**
     * Constructor for objects of class NonUrgentOrder
     */
    public NonUrgentOrder (String sendingName, Location location, Location destination, int deliveryTime, 
    double weight, String destinationName,Surcharge surcharge, Urgency urgency)
    {
       super(sendingName, location, destination, deliveryTime, weight, destinationName,surcharge, urgency);
    }

    @Override
    public int charge(){
        return super.charge();
    }
    
    @Override
    public int calculateEvaluationDP(){
        return 5;
    }
}
