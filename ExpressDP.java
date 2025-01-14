import java.util.*;

/**
 * Write a description of class ExpressDP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExpressDP extends DeliveryPerson
{
   public ExpressDP(DeliveryCompany company, Location location, String name)
    {
        super(company,  location,  name);
        setMaxLoad(2);
    }
    
    @Override
    public void act()
    {
      if(getTargetLocation()==null){
          incrementIdleCount();
      }else{
         setLocation(getLocation().nextLocation(getTargetLocation())); 
         System.out.println("@@@  DeliveryPerson: "+ getName() + " moving to: "  + getLocation() );
         if(getLocation().equals(getTargetLocation())){
             if(isFree()){
            notifyPickupArrival();
        }else{
            TreeSet<Order>aux=getOrdersToDeliver();
            notifyOrderArrival(aux.first());
            deliverOrder();//Aqui se hace el incremento de dinero y valoracion.
            
            setAsigned(false);
            if(getTargetLocation()!=null){
                if(getLocation().equals(getTargetLocation())){
                    aux=getOrdersToDeliver();
                    notifyOrderArrival(aux.first());
                    deliverOrder();
                }
            }
        }
      }
        
    }
}
}
