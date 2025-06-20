import java.util.*;

/**
 * Write a description of class CommonDP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommonDP extends DeliveryPerson 
{
    int popularidad;
      public CommonDP(DeliveryCompany company, Location location, String name)
    {
        super(company,  location,  name);
        setMaxLoad(4);
        popularidad=6;
    }
    
    @Override
    public void act()
    {
      if(getTargetLocation()==null){
          incrementIdleCount();
      }else{
         setLocation(getLocation().nextLocation(getTargetLocation())); 
         System.out.println("@@@CommonDeliveryPerson: "+ getName() + " moving to: "  + getLocation() );
         if(getLocation().equals(getTargetLocation())){
             if(!getWorking()){
            notifyPickupArrival();
        }else{
            TreeSet<Order>aux=getOrdersToDeliver();
            adjustPopularity(aux.first());
            notifyOrderArrival(aux.first());
            setAsigned(false);
            deliverOrder();//Aqui se hace el incremento de dinero y valoracion.
            
            
            if(getTargetLocation()!=null){
            aux=getOrdersToDeliver();
            TreeSet<Order> auxCopy = new TreeSet<>(aux);
            Iterator<Order> iter=auxCopy.iterator();
            Order o= aux.first();
            while(iter.hasNext()){
               if(getLocation().equals(o.getDestination())){
                    adjustPopularity(o);
                    notifyOrderArrival(o);
                    deliverOrder(o);    //Al iterar sobre el set se modifica, por lo que hay
                    aux=getOrdersToDeliver(); // que actualizarlo
                    auxCopy = new TreeSet<>(aux);
                    iter=auxCopy.iterator();
                    o= aux.first();
                }else o= iter.next();
                
            }
                
            }
        }
      }
        
    }
}

public void adjustPopularity(Order o){ 
 if(o.getUrgency().getValor()==3){
     popularidad=popularidad+4;
 }
 else popularidad++;
     
    
}
 @Override
 public String showFinalInfo()
    {
        //TODO  implementar este método
        return "CommonDP"+ getName() +" at location "+ getLocation() + " - orders delivered: "+
        ordersDelivered() +" - non active for: " + getIdleCount() + " times  - total to be collected: "
        + obtainTotalCharge() + " -Valuation: "+ obtainValuation();

    }   
  @Override
    public  boolean DeliveryValido(){
        boolean enc=false;
   
            if(getMaxLoad()==4)
            enc= true; 
            
        return enc;
    } 
    @Override
    public void introPickup(){
        System.out.print("<<<<Common");
    }
    
    @Override
    public void introDeliver(){
       System.out.print("<<<<Common"); 
    }
}
