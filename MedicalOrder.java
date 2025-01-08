
/**
 * Write a description of class MedicalOrder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MedicalOrder extends Order
{
   
    

    /**
     * Constructor for objects of class NonUrgentOrder
     */
    public MedicalOrder (String sendingName, Location location, Location destination, int deliveryTime, 
    double weight, String destinationName,Surcharge surcharge, Urgency urgency)
    {
       super(sendingName, location, destination, deliveryTime, weight, destinationName,surcharge, urgency);
    }

    @Override
    public int charge(){
        return 0;
    }
    
    @Override
    public int calculateEvaluationDP(){
        return 15;
    }
}
