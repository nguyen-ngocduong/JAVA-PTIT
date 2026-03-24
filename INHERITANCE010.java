//INHERITANCE010 - Thương mại điện tử
import java.util.*;
abstract class Product{
    private String name;
    private double price;
    private int quantity;
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public int getQuantity(){return this.quantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}
    public Product(String name, double price, int quantity){
        this.name = name; this.price = price;
        this.quantity = quantity;
    }
    public abstract double calculateCost(int quantity);
    public void displayDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Price: $" + this.price);
        System.out.println("Available Quantity: " + this.quantity);
    }
}
class Book extends Product{
    private String author;
    public Book(String name, double price, int  quantity, String author){
        super(name, price, quantity);
        this.author = author;
    }
    @Override
    public double calculateCost(int quantity){
        return super.getPrice() * quantity;
    }
    @Override
    public void displayDetails(){
        System.out.println("Name: " + super.getName());
        System.out.println("Price: $" + super.getPrice());
        System.out.println("Available Quantity: " + super.getQuantity());
        System.out.println("Author: " + this.author);
    }
}
class Electronics extends Product{
    private String brand;
    public Electronics(String name, double price, int quantity, String brand){
        super(name, price, quantity);
        this.brand = brand;
    }
    @Override
    public double calculateCost(int quantity){
        return super.getPrice() * quantity * 1.1;
    }
    @Override
    public void displayDetails(){
        System.out.println("Name: " + super.getName());
        System.out.println("Price: $" + super.getPrice());
        System.out.println("Available Quantity: " + super.getQuantity());
        System.out.println("Brand: " + this.brand);
    }
}
class User {
    private String username;
    private double totalSpent;
    public User(String username){
        this.username = username; 
    }
    public void buyProduct(Product product, int quantity){
        // quantity o day la so luong san pham ma nguoi dung muon mua
        if(quantity <= product.getQuantity()){
            // Cập nhật số lượng mới trong kho
            product.setQuantity(product.getQuantity() - quantity);

            double cost = product.calculateCost(quantity);
            this.totalSpent += cost;
            System.out.printf("User: %s bought %d %s for $%.1f\n",this.username, quantity, product.getName(), cost);
        }
        else{
            System.out.println("Insufficient quantity of " + product.getName() + " available.");
        }
    }
    public double getTotalSpent(){
        //return String.format("$%.1f", this.totalSpent);
        return this.totalSpent;
    }
    public String getUsername(){return this.username;}
}
public class INHERITANCE010{
    public static void main(String [] args){
        Electronics e1 = new Electronics("laptop", 20, 10, "Dell");
        Book b1 = new Book("Harry Potter", 10, 12, "camnh");
        User u1 = new User("Alice"), u2 = new User("Bob"), u3 = new User("Charlie");
        u1.buyProduct(e1, 3); u1.buyProduct(b1,10);
        u2.buyProduct(e1,1); u3.buyProduct(b1, 5);
        System.out.println("====");
        ArrayList<User> users = new ArrayList<>();
        users.add(u1); users.add(u2); users.add(u3);
        for(int i = 0; i < users.size(); i++){
            for(int j = 0; j< users.size()- i - 1; j++){
                if(users.get(j).getTotalSpent() < users.get(j + 1).getTotalSpent()){
                    User u = users.get(j);
                    users.set(j, users.get(j+1));
                    users.set(j+1, u);
                }
            }
        }
        System.out.println("Users with Highest Total Spent:");
        for(int i = 0; i< users.size(); i++){
            System.out.println(i+1 + ". " + users.get(i).getUsername() + ": $" + users.get(i).getTotalSpent());
        }
        System.out.println("====");
        e1.displayDetails();
        System.out.println("---");
        b1.displayDetails();
    }
}