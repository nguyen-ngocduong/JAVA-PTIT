import java.util.*;
class Product{
    private String name, location;
    private int weight;
    public Product(String name, String location, int weight){
        this.name = name; this.location = location;
        this.weight = weight;
    }
    public Product(String name){
        this(name, "shelf", 1);
    }
    public Product(String name, String location){
        this(name, location, 1);
    }
    public Product(String name, int weight){
        this(name, "shelf",weight);
    }
    public String toString(){
        return this.name + " (" + this.weight + "kg) can be found from the " + this.location;
    }
}
public class OOP010{
    public static void main(String [] args){
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("Tape measure"));
        listProduct.add(new Product("Plaster", "home improvement section"));
        listProduct.add(new Product("Tyre", 5));
        for(Product p : listProduct){
            System.out.println(p);
        }
    }
}