import java.util.*;

/**
 * Model the operation of a taxi company, operating different
 * delivery persons. This version operates a single type of delivery person.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2024.10.07 DP classes
 */
public class DeliveryCompany  
{
    // TODO definir todos sus campos
    private String name;  //nombre de la compañía
    private List<DeliveryPerson> deliveryPersons;
    private WareHouse wareHouse;
    private List<Order> OrderDelivered;
    /**
     * Constructor for objects of class DeliveryCompany
     */
    public DeliveryCompany(String name)
    {
        this.name = name;
        deliveryPersons= new ArrayList<>();
        wareHouse= new WareHouse();
        OrderDelivered= new ArrayList<>();

    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The list of delivery persons.
     */
    public List<DeliveryPerson> getDeliveryPersons()
    {       
        //TODO implementar el método 
        return deliveryPersons;

        
    }
    public List<Order> getOrderDelivered()
    {       
        //TODO implementar el método 
        return OrderDelivered;

        
    }

    /**
     * @return The list of orders.
     */
    public List<Order> getOrders()
    {
        return wareHouse.getOrders();
    }

    /**
     * @param Add a new delivery person.
     */
    public void addDeliveryPerson(DeliveryPerson dp)
    {
        //TODO implementar el método 
        
        deliveryPersons.add(dp);

    }

    /**
     * Add a new order in the whare house of the company.
     * @param order The new order.
     */
    public void addOrder(Order order)
    {
        //TODO implementar el método 
        wareHouse.addOrder(order);

    }

    /**
     * Find a the most closed free delivery person to the whare house's location, if any.
     * @return A free delivery person, or null if there is none.
     */
    private DeliveryPerson getDeliveryPerson()
    {
        //TODO implementar el método 
    int i=0;
    boolean enc=false;
    Collections.sort(deliveryPersons, new  ComparadorCercaniaNombreDelivery());
    while(i<deliveryPersons.size()&&!enc){
        if(deliveryPersons.get(i).isFree()&&deliveryPersons.get(i).getAsigned()==false){
            enc=true;
            deliveryPersons.get(i).setAsigned(enc);
        }
        else i++;
    }
    if(enc){
          return   deliveryPersons.get(i);
    }   
    else return null;

        
    }

    /**
     * Request a pickup for the given order.
     * @param order The order to be delivered.
     * @return Whether a free delivery person is available.
     */
    public boolean requestPickup(Order order)
    {
        //TODO implementar el método 
       DeliveryPerson dpAux=getDeliveryPerson();
       if(dpAux==null){
           return false;
       }else{
           dpAux.setPickupLocation(wareHouse.getLocation());
            System.out.println("<<<< DeliveryPerson " +dpAux.getName() + " at location " +dpAux.getLocation() + " go to pick up order from  " +order.getSendingName()+ " at location " +dpAux.getTargetLocation());
           
        }
       
        
        return true;
    }

    /**
     * A delivery person has arrived at a pickup point.
     * @param dp The delivery person at the pickup point.
     */
    public void arrivedAtPickup(DeliveryPerson dp)
    {
        Order o= wareHouse.getOneOrder();
        //TODO implementar el método
        if(o!=null&&dp.isFree()){
        if(dp.getLocation().equals(wareHouse.getLocation())){
            List<Order>O=wareHouse.getOrders();
            OrderDelivered.add(o);
            O.remove(o);
            wareHouse.setOrders(O);
            dp.pickup(o);
            System.out.println("<<<<  DeliveryPerson " +dp.getName()+ " at " + dp.getLocation() + " Picks up Order from " + o.getSendingName()+ " to: "+ o.getDestination());
            o.setDeliveryPersonName(dp.getName());
        }
        
        
    }
    }

    /**
     * A delivery person has arrived at a orders's destination.
     * @param dp The delivery person at the destination.
     * @param order The order being dropped off.
     */
    public void arrivedAtDestination(DeliveryPerson dp, Order order) {
        if(!dp.isFree()&& dp.getLocation().equals(order.getDestination())){
        System.out.println("<<<<DeliveryPerson " + dp.getName()+ " at location "+dp.getLocation()  + " delivers Order at: " + order.getDeliveryTime()+ " from: " + order.getSendingName()+ " to: "+ order.getDestinationName());
        
        }
    }
}