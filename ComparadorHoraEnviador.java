import java.util.*; 
/**
 * Write a description of class ComparadorHoraEnviador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorHoraEnviador implements Comparator<Order>
{
    public int compare(Order o1, Order o2){  
        if(o1.getDeliveryTime()==o2.getDeliveryTime()){
            return o1.getSendingName().compareTo(o2.getSendingName());
            
        }else {
            if(o1.getDeliveryTime()>o2.getDeliveryTime()){
                return 1;
                
            }else return -1;
        }
    
}
}
