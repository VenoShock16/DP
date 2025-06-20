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
    public TreeSet<Order> getOrders()
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
    private DeliveryPerson getDeliveryPerson(Order o)
    {
        //TODO implementar el método 
    int i=0;
    boolean enc=false;
    Collections.sort(deliveryPersons, new  ComparadorCercaniaNombreDelivery());
    while(i<deliveryPersons.size()&&!enc){
        if(deliveryPersons.get(i).getOcupation()<deliveryPersons.get(i).getMaxLoad() && deliveryPersons.get(i).getAsigned()==false){// Mira si cabe y si no esta ya en reparto
            if(DeliveryValido(o,deliveryPersons.get(i))){
            deliveryPersons.get(i).incOcupation();
            enc=true;
            if(deliveryPersons.get(i).getOcupation()==deliveryPersons.get(i).getMaxLoad()){
                deliveryPersons.get(i).setAsigned(enc);
                
            }
            }
            else i++;
        }
        else i++;
    }
    if(enc){
          return   deliveryPersons.get(i);
    }   
    else return null;

        
    }
    
    public boolean DeliveryValido(Order o, DeliveryPerson dp){// Hacer con herencia
        int u= o.getUrgency().getValor();
        boolean enc=false;
        switch (u){
            case 1:// NONESSENTIAL
            if(dp.getMaxLoad()==4)
            enc= true;
            break;
            case 3://IMPORTANT
            if(dp.getMaxLoad()==4||dp.getMaxLoad()==2)
            enc= true;
            break;
            case 5://EMERGENCY
             if(dp.getMaxLoad()==1)
            enc= true; 
            break;
            
        }
        return enc;
    }

    /**
     * Request a pickup for the given order.
     * @param order The order to be delivered.
     * @return Whether a free delivery person is available.
     */
    public boolean requestPickup(Order order)
    {
   
       DeliveryPerson dpAux=getDeliveryPerson(order);
       if(dpAux==null){
           return false;
       }else{
           dpAux.setPickupLocation(wareHouse.getLocation());
            System.out.println("<<<< DeliveryPerson " +dpAux.getName() + " at location " +dpAux.getLocation() + " go to pick up order from  " +order.getSendingName()+ " at location " +dpAux.getTargetLocation());
            TreeSet<Order>ToDeliver=dpAux.getOrdersToDeliver();
            ToDeliver.add(order);
            dpAux.setOrdersToDeliver(ToDeliver);
             
        }
       //Aqui no se elimina del warehouse, hacer en el deliver(arrived at destination)
        
        return true;
    }

    /**
     * A delivery person has arrived at a pickup point.
     * @param dp The delivery person at the pickup point.
     */
    public void arrivedAtPickup(DeliveryPerson dp)
    {
        
        
        if(dp.getLocation().equals(wareHouse.getLocation())){
            
            TreeSet<Order>aux=dp.getOrdersToDeliver();
            Order o1;
            if(aux!=null){
                o1=aux.first();
                dp.pickup(o1);
            }
            for(Order o: aux){
            System.out.println("<<<<  DeliveryPerson " +dp.getName()+ " at " + dp.getLocation() + " Picks up Order from " + o.getSendingName()+ " to: "+ o.getDestination());
            o.setDeliveryPersonName(dp.getName());
            }
            dp.setWorking(true);
            
        }
        
        
    
    }

    /**
     * A delivery person has arrived at a orders's destination.
     * @param dp The delivery person at the destination.
     * @param order The order being dropped off.
     */
    public void arrivedAtDestination(DeliveryPerson dp, Order order) {
        if(dp.getAsigned()&& dp.getLocation().equals(order.getDestination())){
        System.out.println("<<<<DeliveryPerson " + dp.getName()+ " at location "+dp.getLocation()  + " delivers Order at: " + order.getDeliveryTime()+ " from: " + order.getSendingName()+ " to: "+ order.getDestinationName());
        wareHouse.addDeliveredOrder(order, dp);
        TreeSet<Order>O=wareHouse.getOrders();
            O.remove(order);
            wareHouse.setOrders(O);
        }
    }
    public WareHouse getWareHouse(){
        return wareHouse;
    }
}