import java.util.*;

/**
 * Model the common elements of delivery persons.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public  abstract class DeliveryPerson 
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
    private TreeSet<Order> ordersToDeliver;
    
    private int ordersDelivered;
    
    private boolean asigned;
    
    private int valuation;
    
    private int maxLoad;
    
    private int totalCharged;
    
    private int ocupation;
    
    private boolean Working;
    
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
        ordersToDeliver =new TreeSet<Order>(new ComparadorOrderWareHouse());
        ordersDelivered=0;
        this.name=name;
        asigned=false;
        valuation=0;
        totalCharged=0;
        maxLoad=5;
        ocupation=0;
        Working=false;
        //TODO resto de inicializaciones pendientes
    }

    /**
     * @return the name of the delivery person
     */
    public String getName()
    {
        return name;
    }
    
    public int getOcupation(){
        return ocupation;
    }
    public int getMaxLoad(){
        return maxLoad;
    }
    
    public void incOcupation(){
        ocupation++;
    }
    public void decOcupation(){
        ocupation--;
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
      if(!ordersToDeliver.isEmpty()){
          return false;
        
      }else return true;
        
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        
        company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at an order's destination.
     */
    public void notifyOrderArrival(Order order)
    {
        company.arrivedAtDestination(this, order);
    }

    /**
     * Receive an order.
     * Set order's destination as its target location.
     * @param order The order.
     */
    public void pickup(Order order)
    {
        //El order que entra es el que esté en la primera posición de ordersToDeliver
        setTargetLocation(order.getDestination());
        setAsigned(true);

    }
    
    
    /**
     * Deliver the order.
     */
    public void deliverOrder()
    {
        Order o= ordersToDeliver.first();
        ordersToDeliver.remove(o);
        clearTargetLocation();
        incrementOrdersDelivered();
        
        incTotalCharged(o);
        incValuation(o);
        decOcupation();
        if(getOcupation()==0){
            setWorking(false);
        }
        if(!isFree()){
            setTargetLocation(ordersToDeliver.first().getDestination());
            setAsigned(true);
        }
         
        
    }
    //Se usa para el CommonDP para cuando descarga mas de un paquete en una sola ubicación
    public void deliverOrder(Order o)
    {
   // company addtodelivered de warehouse del arrived del destination
        ordersToDeliver.remove(o);
        clearTargetLocation();
        incrementOrdersDelivered();
        
        incTotalCharged(o);
        incValuation(o);
        decOcupation();
        if(getOcupation()==0){
            setWorking(false);
        }
        if(!isFree()){
            setTargetLocation(ordersToDeliver.first().getDestination());
            setAsigned(true);
        }
        
         
        
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
    public abstract void act();

public boolean getWorking(){
    return Working;
}
public void setWorking(boolean e){
     Working=e;
}

public void setOrdersToDeliver(TreeSet<Order>o){
    ordersToDeliver=o;
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
        ordersDelivered() +" - non active for: " + getIdleCount() + " times  - total to be collected: "
        + totalCharged + " -Valuation: "+ valuation;

    }
    
    public void incTotalCharged(Order o){
        totalCharged=totalCharged+o.charge();
    }
    
    public int obtainTotalCharge(){
        return totalCharged;
    }
    public int obtainValuation(){
        return valuation;
    }
    
    public void incValuation(Order o){
        valuation=valuation+o.calculateEvaluationDP();
    }
    
    public void setMaxLoad(int i){
        maxLoad=i;
    }
    public TreeSet getOrdersToDeliver(){
        return ordersToDeliver;
    }
    
   public  abstract boolean DeliveryValido();// Hacer con herencia
    public void introPickup(){
        
    }
    public void introDeliver(){
        
    }
    public int getTotalCharged(){
        return totalCharged;
    }
}
