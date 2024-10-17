import java.util.List;
import java.util.ArrayList;
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
    // instance variables - replace the example below with your own
    private Location location;
    private List<Order> orders;
    /**
     * Constructor for objects of class WareHouse
     */
    public WareHouse()
    {
        // initialise instance variables
      orders= new ArrayList<>();
      
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
        this.orders.sort(Comparator.comparingInt((Order o) -> o.getDeliveryTime()).thenComparing(Order::getSendingName));
        
    }
    public List<Order> getOrders(){
        return orders;
    }
    
    public Order getOneOrder() {
    if (!orders.isEmpty()) {
        return orders.get(0);  
    }else return null;  
}
}
