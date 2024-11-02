import java.util.*; 
/**
 * Write a description of class ComparadorCercaniaNombreDelivery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorCercaniaNombreDelivery implements Comparator<DeliveryPerson>
{   Location L= new Location(5,5);
    public int compare(DeliveryPerson dp1, DeliveryPerson dp2){  
        if (dp1.getLocation().distance(L)== dp2.getLocation().distance(L)){
            return new ComparadorNombreDeliveryPerson().compare(dp1,dp2);
            
        }
        else
        if (dp1.getLocation().distance(L)> dp2.getLocation().distance(L)){
            return 1;
            
        }else return -1;
    }
}
