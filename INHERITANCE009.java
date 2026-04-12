import java.util.*;
class Item {
    private String name;
    private double price;
    private double discount;
    public Item(String name, double price, double discount){
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    public double getPrice(){
        return this.price;
    }
    public double getDiscount(){
        return this.discount;
    }
    public String toString(){
        return this.name + " $" + String.format("%.2f",this.price) + 
            " (-$" + String.format("%.2f", this.discount) + ")"; 
    }
}
class Employee{
    private String name;
    public Employee(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
class GroceryBill{
    private Employee clerk;
    private List<Item> receipt;
    private double total;
    public GroceryBill(Employee clerk){
        this.clerk = clerk;
        this.receipt = new ArrayList<>();
    }
    public void add(Item i){
        receipt.add(i);
        this.total += i.getPrice();
    }
    public double getTotal(){
        return this.total;
    }
    public Employee getClerk(){
        return this.clerk;
    }
    public String toString(){
        String res = "items:\n" ;
        for(Item i : receipt){
            res += "   " +i.toString() + "\n";
        }
        res += "total: $" + String.format("%.2f", this.total) +"\n";
        res += "Clerk: " + this.clerk.getName();
        return res;
    }
}
class DiscountBill extends GroceryBill{
    private double discountAmount;
    private List<Item> list;
    public DiscountBill(Employee clerk){
        super(clerk);
        this.list = new ArrayList<>();
    }
    public void add(Item i){
        super.add(i); // them ca sp vao GroceryBill
        list.add(i);
        this.discountAmount += i.getDiscount();
    }
    @Override
    public String toString(){
        String res = "items:\n" ;
        double total = 0;
        for(Item i : list){
            res += "   " + i.toString() + "\n";
            total += i.getPrice();
        }
        res += "sub-total: $" + String.format("%.2f", total) + "\n";
        res += "discount: $" + String.format("%.2f",this.discountAmount) + "\n";
        res += "total: $" + String.format("%.2f",(total-this.discountAmount)) +"\n";
        res += "Clerk: " + super.getClerk().getName();
        return res;
    }
}
public class INHERITANCE009{
    public static void main(String [] args){
        Item i1 = new Item("item 1", 2.3, 0);
        Item i2 = new Item("item 2", 3.45, 0);
        Item i3 = new Item("item 3", 20, 15);
        Item i4 = new Item("item 4", 40, 35);
        Item i5 = new Item("item 5", 50, 35);
        Employee e = new Employee("Grocery Bill");
        GroceryBill gb = new GroceryBill(e);
        gb.add(i1); gb.add(i2);
        System.out.println(gb);
        System.out.println();
        Employee e1 = new Employee("Discount Bill");
        DiscountBill db = new DiscountBill(e1);
        db.add(i3); db.add(i4); db.add(i5);
        System.out.println(db);
    }
}