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
         System.out.println("@@@DeliveryPerson: "+ getName() + " moving to: "  + getLocation() );
         if(getLocation().equals(getTargetLocation())){
             if(!getWorking()){
            notifyPickupArrival();
            }else{
            if(getLocation().equals(getTargetLocation())){
            TreeSet<Order>aux=getOrdersToDeliver();
            notifyOrderArrival(aux.first());
            setAsigned(false);
            deliverOrder();//Aqui se hace el incremento de dinero y valoracion.
            
            
            
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

@Override
 public String showFinalInfo()
    {
        //TODO  implementar este método
        return "ExpressDP"+ getName() +" at location "+ getLocation() + " - orders delivered: "+
        ordersDelivered() +" - non active for: " + getIdleCount() + " times  - total to be collected: "
        + obtainTotalCharge() + " -Valuation: "+ obtainValuation();

    }
}
