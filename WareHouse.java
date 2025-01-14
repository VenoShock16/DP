import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;
import java.util.*;
/**
 * Write a description of class WareHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WareHouse
{
    private Location location;
    private TreeSet<Order> orders;
    private TreeMap<Order,DeliveryPerson> deliveredOrders;
    /**
     * Constructor for objects of class WareHouse
     */
    public WareHouse()
    {
     
        // initialise instance variables
      orders= new TreeSet<Order>(new ComparadorOrderWareHouse());
      location= new Location(5,5);
      deliveredOrders= new TreeMap<>(new ComparadorRemitenteHora());
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Location getLocation(){
        return location;
    }
    
    
    public void addOrder(Order order) {
        orders.add(order);
        
    }
    public TreeSet<Order> getOrders(){
        return orders;
    }
    
    public Order getOneOrder() {
    if (!orders.isEmpty()) {
        TreeSet<Order> o= getOrders(); 
        return orders.first(); 
    }else return null;  
}
    public void setOrders(TreeSet<Order>orders){
    this.orders=orders;
}

    public void addDeliveredOrder(Order order, DeliveryPerson deliveryPerson) {
        deliveredOrders.put(order, deliveryPerson);
        
    }
    
    public TreeMap<Order, DeliveryPerson> getDeliveredOrders(){
        return deliveredOrders;
    }

}
