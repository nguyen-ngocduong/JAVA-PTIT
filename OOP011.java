/*
OOP011 - Quản lí đơn hàng
 */
import java.util.*;
class Product {
    private String productId;
    private String name;
    private double price;
    //constructor
    public Product(String productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public double getPrice(){return price;}
    public String toString(){
        return "Sản phẩm: " + this.name + " (Mã: " + this.productId + ")"
            + "\n" + "Giá: " + this.price;
    }
}
class Order {
    private String orderId;
    private Product product;
    private int quantity;
    //constructor
    public Order(String orderId, Product product, int quantity){
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }
    public String getOrderId(){
        return orderId;
    }
    public double calculateTotal(){
        return quantity*product.getPrice();
    }
    public String toString(){
        return "Số lượng: " + this.quantity + "\n" 
            + "Tổng tiền: " + String.format("%.1f", calculateTotal());
    }
}
public class OOP011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String productId = sc.nextLine();
        String name = sc.nextLine();
        double price = Double.parseDouble(sc.nextLine());
        String orderId = sc.nextLine();
        int quantity = sc.nextInt();
        Product p = new Product(productId, name, price);
        Order o = new Order(orderId, p, quantity);
        System.out.println("--- Thông tin đơn hàng ---");
        System.out.println("Đơn hàng: " + o.getOrderId());
        System.out.println(p);
        System.out.println(o);
    }
}
