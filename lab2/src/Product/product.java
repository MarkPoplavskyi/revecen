package Product;


/**
 * мій клас продуктів
 */

public class product {

    private int id;
    private String Name;
    private  String  creator;
    private int price;
    private  int life;
    private int number;

    /**
     * сеттери
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
     * вивід на єкран
     */
    public void PrintValue()
    {
        System.out.print("-------------------------------------------------------------------------\n");
        System.out.print("\n"+id+"\n"+Name+"\n"+creator+"\n"+price+"\n"+life+"d"+"\n"+number+"\n");
    }
    /**
     * getter
     */
    public int getPrice()
    {return price;}
    public int getLife()
    {return life;}
    public String getName()
    {return Name;}
}
