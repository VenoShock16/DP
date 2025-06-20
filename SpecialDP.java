import java.util.TreeSet;

/**
 * Write a description of class SpecialDP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class SpecialDP extends DeliveryPerson
{
    /**
     * Constructor for objects of class SpecialDP
     */
    public SpecialDP(DeliveryCompany company, Location location, String name)
    {
        super(company,  location,  name);
        setMaxLoad(1);
    }
    @Override
    public void act()
    {
        
      if(getTargetLocation()==null){
          incrementIdleCount();
      }else{
         setLocation(getLocation().nextLocation(getTargetLocation())); 
         System.out.println("@@@SpecialDeliveryPerson: "+ getName() + " moving to: "  + getLocation() );
         if(getLocation().equals(getTargetLocation())){
             if(!getWorking()){
            notifyPickupArrival();
        }else{
            TreeSet<Order>aux=getOrdersToDeliver();
            notifyOrderArrival(aux.first());
            deliverOrder();//Aqui se hace el incremento de dinero y valoracion.
            if(isFree())
            setAsigned(false);
        }
      }
        
    }
}
 @Override
 public String showFinalInfo()
    {
        //TODO  implementar este método
        return "SpecialDP "+ getName() +" at location "+ getLocation() + " - orders delivered: "+
        ordersDelivered() +" - non active for: " + getIdleCount() + " times  - total to be collected: "
        + obtainTotalCharge() + " -Valuation: "+ obtainValuation();

    }
    @Override
    public  boolean DeliveryValido(){
        boolean enc=false;
   
            if(getMaxLoad()==1)
            enc= true; 
            
        return enc;
    }
    @Override
    public void introPickup(){
        System.out.print("<<<<Special");
    }
    
    @Override
    public void introDeliver(){
       System.out.print("<<<<Special"); 
    }
}
