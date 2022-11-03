package Product;


/**
 * мій клас продуктів
 * id - це айді продукту
 * Name - Найменування
 * creator - виробник
 * price - ціна
 * life - термін дії
 * number - кількість
 */

public class product {

    private int id;
    private String Name;
    private  String  creator;
    private int price;
    private  int life;
    private int number;

    /**
     * сетери
     */
    public void setid(int id)
    {this.id = id;}

    public void setName(String Name)
    {this.Name = Name;}
    public void setCreator(String creator)
    {this.creator = creator;}

    public void setPrice(int price)
    {this.price = price;}

    public void setLife(int life)
    {this.life =life;}

    public void setNumber(int number)
    {this.number = number;}
    /**
     * вивід на екран
     */
    public String toString()
    {
        return "-------------------------------------------------------------------------\n"+id+"\n"+Name+"\n"+creator+"\n"+price+"\n"+life+"d"+"\n"+number+"\n";
    }
    /**
     * getPrice - повертає ціну продукту
     * getLife - повертає термін дії продукту
     * getName - повертає найменування продукту
     */
    public int getPrice()
    {return price;}
    public int getLife()
    {return life;}
    public String getName()
    {return Name;}
}
