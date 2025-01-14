import java.util.*;

/**
 * Write a description of class ComparadorOrderWareHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorOrderWareHouse implements Comparator<Order>
{
  public int compare(Order o1, Order o2){ 
      if(o1.getUrgency().getNombre()==o2.getUrgency().getNombre()){
          if(o1.getDeliveryTime()==o2.getDeliveryTime()){
              return o1.getDestinationName().compareTo(o2.getDestinationName());
          }else{
        if(o1.getDeliveryTime()>o2.getDeliveryTime()){
            return 1;  
        }else return -1;
        }   
        }else{
            return(o1.getUrgency().getNombre().compareTo(o2.getUrgency().getNombre()));
    }
}
}
