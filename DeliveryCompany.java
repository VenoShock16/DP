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
    /**
     * Constructor for objects of class DeliveryCompany
     */
    public DeliveryCompany(String name)
    {
        this.name = name;
        deliveryPersons= new ArrayList<>();
        wareHouse= new WareHouse();

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
    this.deliveryPersons.sort(Comparator.comparingInt((DeliveryPerson dp) -> dp.getLocation().distance(wareHouse.getLocation())).thenComparing(DeliveryPerson::getName));

    while(i<deliveryPersons.size()&&!enc){
        if(deliveryPersons.get(i).isFree()){
            enc=true;
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
           dpAux. setPickupLocation(wareHouse.getLocation());
           
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
            O.remove(o);
            wareHouse.setOrders(O);
            dp.pickup(o);
            System.out.println("<<<<  DeliveryPerson " +dp.getName()+ " at " + dp.getLocation().toString() + " delivers Order from " + o.getSendingName()+ "to: "+ o.getDestination().toString());
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
        System.out.println("DeliveryPerson" + dp.getName()+ " at "+dp.getLocation().toString()  + " delivers Order at " + order.getDeliveryTime()+ " from" + wareHouse.getLocation().toString()+ "to"+ order.getDestination().toString());
        
        }
    }
}