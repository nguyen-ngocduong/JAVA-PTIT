/*
COLLECTION001 - Nhà kho
 */
import java.util.*;

class Product_1{
    private String name;
    private int price;
    private int stock;
    //constructor
    public Product_1(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public int getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
}
class Warehouse{
    ArrayList<Product_1> listProduct = new ArrayList<>();
    public void addProduct(Product_1 product){
        listProduct.add(product);
    }
    public int getPrice(String sanPham){
        for(Product_1 p : listProduct){
            if(p.getName().equals(sanPham)){
                return p.getPrice();
            }
        }
        return -99;
    }
}
public class COLLECTION001 {
    public static void main(String[] args) {
        Product_1 p1 = new Product_1("milk", 3, 10);
        Product_1 p2 = new Product_1("coffee", 5, 7);
        Warehouse w = new Warehouse();
        w.addProduct(p1); w.addProduct(p2);
        System.out.println("prices:");
        System.out.println("milk: " + w.getPrice("milk"));
        System.out.println("coffee: " + w.getPrice("coffee"));
        System.out.println("sugar: " + w.getPrice("sugar"));
    }
}
