
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
    double weight, String destinationName, Urgency urgency ,Surcharge surcharge)
    {
       super(sendingName, location, destination, deliveryTime, weight, destinationName, urgency);
       setSurcharge(surcharge);
    }

    @Override
    public int charge(){
        return super.charge();
    }
    
    @Override
    public int calculateEvaluationDP(){
        return 5;
    }
    
    @Override
    public String ShowInitialInfo(){
        return "NonUrgent Order from: "+ getSendingName()+" to: "+getDestinationName()+ 
        " at "+ getDeliveryTime() +" weight " +getWeight()+ " from : "+ getLocation().toString()
        + " to: "+ getDestination().toString()+ getUrgency().Show()+" "+getSurcharge().Show();
    }
    @Override
    public String showFinalInfo()
    {
        
        return " NonUrgentOrder Delivered at: "+ getDeliveryTime() +" by:  "+ getDeliveryPersonName() + " to: "+
        getDestinationName() +" from: " + getSendingName();
    }
}
