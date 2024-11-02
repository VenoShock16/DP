import java.util.*; 
/**
 * Write a description of class ComparadorOrderDeliveryPersonName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorOrderDeliveryPersonName implements Comparator<Order>
{
    public int compare(Order o1, Order o2){  
        return (o1.getSendingName().compareTo(o2.getSendingName()));
    } 
}
