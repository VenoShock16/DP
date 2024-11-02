/**
 * Model the common elements of delivery persons.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class DeliveryPerson 
{
    // The Delivery Company of this DeliveryPerson.
    private DeliveryCompany company;   //TODO cambiar a private
    // Where the person is.
    private Location location;     //TODO cambiar a private
    // Where the person is headed.
    private  Location targetLocation;   //TODO cambiar a private
    // Record how often the person has nothing to do.
    private int idleCount;       //TODO cambiar a private
    //name of the delivery person
    private String name; //TODO cambiar a private
    //TODO añadir campos necesarios
    private Order order;
    
    private int ordersDelivered;
    
    private boolean asigned;
    
    
    
    /**
     * Constructor of class DeliveryPerson
     * @param company The delivery person's company. Must not be null.
     * @param location The delivery person's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public DeliveryPerson(DeliveryCompany company, Location location, String name)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.company = company;
        this.location = location;
        targetLocation = null;
        idleCount = 0;
        order =null;
        ordersDelivered=0;
        this.name=name;
        asigned=false;
        //TODO resto de inicializaciones pendientes
    }

    /**
     * @return the name of the delivery person
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the location.
     * @return Where this delivery person is currently located.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this delivery person is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }
    public boolean getAsigned()
    {
        return asigned;
    }
    
    public void setAsigned(boolean asigned){
       this.asigned=asigned; 
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }

    /**
     * Has the delivery person a target Location?
     * @return Whether or not this delivery person has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }

    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return on how many steps this delivery person has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }

    /**
     * Increment the number of steps on which this delivery person
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Return details of the delivery person, such as where he/she is.
     * @return A string representation of the delivery person.
     */
    public String toString()
    {
        return getClass().getName() + " " +getName()+" at " + getLocation();
    }

    /**
     * Is the delivery person free?
     * @return Whether or not this delivery person is free.
     */
    public boolean isFree()
    {
      if(order!=null){
          return false;
        
      }else return true;
        
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        
        //TODO  implementar este método
        company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at an order's destination.
     */
    public void notifyOrderArrival(Order order)
    {
        //TODO  implementar este método
        company.arrivedAtDestination(this, order);
    }

    /**
     * Receive an order.
     * Set order's destination as its target location.
     * @param order The order.
     */
    public void pickup(Order order)
    {
        //TODO  implementar este método
        this.order=order;
        setTargetLocation(order.getDestination());

    }
    public void setOrder(Order order){
        this.order=order;
    }
    
    /**
     * Deliver the order.
     */
    public void deliverOrder()
    {
        //TODO  implementar este método
        order=null;
        clearTargetLocation();
        incrementOrdersDelivered();
         
        
    }

    /**
     * @return how many orders this delivery person has delivered.
     */
    public int ordersDelivered()
    {
        //TODO  implementar este método
        return ordersDelivered;
    }

    /**
     * Increment the number of orders this delivery person has delivered.
     */
    protected void incrementOrdersDelivered()
    {
        ordersDelivered++;
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
          return location.distance(targetLocation);
        

    }

    /**
     * Carry out a delivery person's actions.
     */
    public void act()
    {
      if(targetLocation==null){
          incrementIdleCount();
      }else{
         location= location.nextLocation(targetLocation); 
         System.out.println("@@@  DeliveryPerson: "+ name + " moving to: "  + location );
         if(location.equals(targetLocation)){
             if(isFree()){
            notifyPickupArrival();
        }else{
            notifyOrderArrival(order);
            deliverOrder();
            asigned=false;
        }
      }
        
    }
}
 
    /**
     * Return details of the delivery person, such as the name, the location,
     * number of delivered orders and time (steps) without moving.
     * @return A string representation of the delivery person.
     */
    public String showFinalInfo()
    {
        //TODO  implementar este método
        return "DeliveryPerson"+ getName() +" at location "+ getLocation() + " - orders delivered: "+
        ordersDelivered() +" - non active for: " + getIdleCount() + " times ";

    }

}
