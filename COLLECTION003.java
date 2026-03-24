/*
COLLECTION003 - Quản lí kho nâng cao (2)
 */
import java.util.*;
class Product_3{
    private String name;
    private int price;
    private int stock;
    //constructor
    public Product_3(String name, int price,int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName(){return this.name;}
    public int getStock(){return this.stock;}
    public int getPrice(){return this.price;}
    public void setStock(int stock){this.stock = stock;}
}
class Warehouse_3{
    ArrayList<Product_3> listProduct = new ArrayList<>();
    public void addProduct(Product_3 p){
        listProduct.add(p);
    }
    //lấy danh sách sản phẩm
    public ArrayList<Product_3> getProduct(){
        return listProduct;
    }
    //lấy giá sản phẩm
    public int Price(String sanPham){
        for(Product_3 p : listProduct){
            if(p.getName().equals(sanPham)){
                return p.getPrice();
            }
        }
        return -99;
    }
    //lấy stock
    public int Stock(String sanPham){
        for(Product_3 p : listProduct){
            if(p.getName().equals(sanPham)){
                return p.getStock();
            }
        }
        return 0;
    }
    //take
    public boolean take(String sanPham){
        for(Product_3 p : listProduct){
            if(p.getName().equals(sanPham) && p.getStock() >= 1){
                p.setStock(p.getStock()-1);
                return true;
            }
        }
        return false;
    }
}
public class COLLECTION003 {
    public static void main(String[] args) {
        Product_3 p1 = new Product_3("milk",3,10);
        Product_3 p2 = new Product_3("coffee",5,6);
        Product_3 p3 = new Product_3("buttermilk",2,2);
        Product_3 p4 = new Product_3("yogurt",2,20);
        Warehouse_3 w = new Warehouse_3(); 
        w.addProduct(p1); w.addProduct(p2); 
        w.addProduct(p3); w.addProduct(p4);
        w.take("buttermilk"); w.take("milk");w.take("buttermilk");
        ArrayList<String> name = new ArrayList<>();
        for(Product_3 p : w.getProduct()){
            if(p.getStock() >= 1) name.add(p.getName());
        }
        for(int i = name.size() - 1; i>= 0; i--){
            System.out.println(name.get(i));
        }
    }
}
