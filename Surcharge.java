
/**
 * Write a description of class Surcharge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Surcharge
{
    
    MEDIUM("Medium",10),LOW("Low",4);
    
    private int valor;
    private String nombre;

    /**
     * Constructor for objects of enum Surcharge
     */
     Surcharge(String nombre, int valor)
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
        return "<charge:  "+ nombre + "(value: "+ valor+ ")>";
    }
}



