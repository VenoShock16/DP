
/**
 * Enumeration class Urgency - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Urgency
{
   EMERGENCY ("Emergency", 5), IMPORTANT ("Important", 3), NONESSENTIAL ("Non essential", 1);
        private int valor;
        private String nombre;
   
       /**
     * Constructor for objects of enum Urgency
     */
     Urgency(String nombre, int valor)
    {
        this.nombre=nombre;    
        this.valor=valor;
    }

    public int getValor()
    {
    return valor;
    }
    
    public String getNombre()
    {
    return nombre;
    }
    
    public void setValor(int valor)
    {
    this.valor=valor;
    }
    
    public String Show(){
        return "<urgency:  "+ nombre + "(value: "+ valor+ ")>";
    }

}
