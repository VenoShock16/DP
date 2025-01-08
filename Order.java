/**
 * Model an order to be delivered from one
 * location to another.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class Order
{
    private String sendingName;
    private Location location;
    private Location destination;
    private int deliveryTime;
    private double weight;
    private String destinationName;
    private String deliveryPersonName;
    private Surcharge surcharge;
    private Urgency urgency;
    
    
    /**
     * Constructor for objects of class Order
     * @param sendingName The sender's name.
     * @param location The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param deliveryTime The hour of delivery.
     * @param weight  The order's weight
     * @param destinationName The name of the person receiving the order.
     * @throws NullPointerException If either location is null.
     */
    public Order(String sendingName, Location location, Location destination, int deliveryTime, 
    double weight, String destinationName,Surcharge surcharge, Urgency urgency)
    {
       
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        //this.location = location;
        this.location= new Location(5,5);
        this.destination = destination;
        this.sendingName=sendingName;
        this.deliveryTime=deliveryTime;
        this.weight= weight;
        this.destinationName=destinationName;
        this.surcharge= surcharge;
        this.urgency=urgency;
        
        
    }

    /**
     * @return The name of the delivery person.
     */
    public String getDeliveryPersonName()
    {
    //TODO Debe poder devolver el nombre de la persona de reparto.
    return deliveryPersonName;
    }

    /**
     * Set the new name of the delivery person.
     * @param The new name of the delivery person.
     */
    public void setDeliveryPersonName(String deliveryPersonName)
    {
    //TODO Debe poder modificarse el nombre de la persona de reparto.
    this.deliveryPersonName=deliveryPersonName;
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
     //TODO Debe poder devolver la localización donde hay que llevar el Order.
        return destination;
    }
    public int getDeliveryTime()
    {
     //TODO Debe poder devolver la localización donde hay que llevar el Order.
        return deliveryTime;
    }
    public String getSendingName()
    {
     //TODO Debe poder devolver la localización donde hay que llevar el Order.
        return sendingName;
    } 
    public String getDestinationName()
    {
     //TODO Debe poder devolver la localización donde hay que llevar el Order.
        return destinationName;
    }
    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return "Order from:  "+ sendingName + " to: "  + destinationName + " at: "  + deliveryTime + " weight: "  + weight
        + " from: "  + location + " to: "  + destination;
    }

    /**
     * Show the final information about the order, including the sender's name, the 
     * destination and name of the deliveryPerson who delivers it.
     */
    public String showFinalInfo()
    {
        // TODO
        return " Order Delivered at: "+ getDeliveryTime() +" by:  "+ getDeliveryPersonName() + " to: "+
        getDestinationName() +" from: " + getSendingName();
    }
    
    public int charge(){
        return surcharge.getValor();
    }
    
    public int calculateEvaluationDP(){
        return 0;
    }

}
