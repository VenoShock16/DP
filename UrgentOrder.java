
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
    double weight, String destinationName,Urgency urgency ,Surcharge surcharge)
    {
       super(sendingName, location, destination, deliveryTime, weight, destinationName, urgency);
       setSurcharge(surcharge);
    }

    @Override
    public int charge(){
        return(super.charge()*2);
    }
    
    @Override
    public int calculateEvaluationDP(){
        return 10;
    }
    @Override
    public String ShowInitialInfo(){
        return "Urgent Order from: "+ getSendingName()+" to: "+getDestinationName()+ 
        " at "+ getDeliveryTime() +" weight " +getWeight()+ " from : "+ getLocation().toString()
        + " to: "+ getDestination().toString()+ getUrgency().Show()+" "+getSurcharge().Show();
    }
    @Override
    public String showFinalInfo()
    {
        
        return " UrgentOrder Delivered at: "+ getDeliveryTime() +" by:  "+ getDeliveryPersonName() + " to: "+
        getDestinationName() +" from: " + getSendingName();
    }
}
