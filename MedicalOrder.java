
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
    double weight, String destinationName, Urgency urgency)
    {
       super(sendingName, location, destination, deliveryTime, weight, destinationName, urgency);
       
    }

    @Override
    public int charge(){
        return 0;
    }
    
    @Override
    public int calculateEvaluationDP(){
        return 15;
    }
    @Override
    public String ShowInitialInfo(){
        return "Medical Order from: "+ getSendingName()+" to: "+getDestinationName()+ 
        " at "+ getDeliveryTime() +" weight " +getWeight()+ " from : "+ getLocation().toString()
        + " to: "+ getDestination().toString()+ getUrgency().Show();
    }
    @Override
    public String showFinalInfo()
    {
        
        return " MedicalOrder Delivered at: "+ getDeliveryTime() +" by:  "+ getDeliveryPersonName() + " to: "+
        getDestinationName() +" from: " + getSendingName();
    }
}
