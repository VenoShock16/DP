import java.util.*; 

/**
 * Write a description of class ComparadorHoraEntrega here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorHoraEntrega implements Comparator<Order>
{
    public int compare(Order o1, Order o2){  
        if (o1.getDeliveryTime()== o2.getDeliveryTime()){
            return new ComparadorHoraEntrega().compare(o1,o2);
            
        }
        else
        if (o1.getDeliveryTime()> o2.getDeliveryTime()){
            return 1;
            
        }else return -1;
    } 
     
}
