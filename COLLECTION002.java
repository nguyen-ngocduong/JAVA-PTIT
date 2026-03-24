/*
COLLECTION002 - Nhà kho nâng cao
 */
import java.util.*;
class Product_2 {
    private String name;
    private int price;
    private int stock;
    //constructor
    public Product_2(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName(){return this.name;}
    public int getStock() {return this.stock;}
    public void setStock(int stock){this.stock = stock;}
    public int getPrice() {return this.price;}
}
class Warehouse_2{
    ArrayList<Product_2> listProduct = new ArrayList<>();
    public void addProduct(Product_2 product){
        listProduct.add(product);
    }
    public ArrayList<Product_2> getProduct(){
        return listProduct;
    }
    //lấy giá sản phẩm
    public int Price(String sanPham){
        for(Product_2 p : listProduct){
            if(p.getName().equals(sanPham)){
                return p.getPrice();
            }
        }
        return -99;
    }
    //lấy số lượng tồn kho
    public int Stock(String sanPham){
        for(Product_2 p : listProduct){
            if(p.getName().equals(sanPham)){
                return p.getStock();
            }
        }
        return 0;
    }
    public boolean take(String sanPham){
        for(Product_2 p : listProduct){
            if(p.getName().equals(sanPham) && p.getStock() >= 1){
                p.setStock(p.getStock() - 1);
                return true;
            }
        }
        return false;
    }
}
public class COLLECTION002 {
    public static void main(String[] args) {
        Product_2 p1 = new Product_2("coffee", 5,1);
        Warehouse_2 w = new Warehouse_2();
        w.addProduct(p1);
        System.out.println("stock:");
        System.out.println("coffee:  "+w.Stock("coffee"));
        System.out.println("sugar: "+w.Stock("sugar"));
        System.out.println("taking coffee" + " " + w.take("coffee"));
        System.out.println("taking coffee" + " " + w.take("coffee"));
        System.out.println("taking sugar" + " " + w.take("sugar"));
        System.out.println("stock:");
        System.out.println("coffee:  "+w.Stock("coffee"));
        System.out.println("sugar: "+w.Stock("sugar"));
    }
}