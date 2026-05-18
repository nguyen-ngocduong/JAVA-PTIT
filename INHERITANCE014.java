/**
 * INHERITANCE014 - Xe cộ
 */
import java.util.*;

class Vehical{
    private double price;
    public Vehical(double price){
        this.price = price;
    }
    public double calculateTax(){return 0;}
    public double getPrice(){return this.price;}
    public String getType(){return "";}
    public String toString(){return "";}
}
class Car extends Vehical{
    private int numberOfSeats;
    public Car(double price, int numberOfSeats){
        super(price);
        this.numberOfSeats = numberOfSeats;
    }
    @Override
    public double calculateTax(){
        return super.getPrice() * 0.05;
    }
    @Override
    public String getType(){
        return "Car";
    }
    @Override
    public String toString(){
        return this.getType() + " - Giá: " + String.format("%.2f",super.getPrice()) + ", Số ghế: " + this.numberOfSeats + ", Thuế: " + String.format("%.2f",this.calculateTax());
    }
}
class Truck extends Vehical{
    private double loadCapacity;
    public Truck(double price, double loadCapacity){
        super(price);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public double calculateTax(){
        return super.getPrice() * 0.1 + this.loadCapacity * 1000;
    }
    @Override
    public String getType(){
        return "Truck";
    }
    @Override
    public String toString(){
        return this.getType() + " - Giá: " + String.format("%.2f",super.getPrice()) + ", Tải trọng: " + String.format("%.2f",this.loadCapacity) + " tấn, Thuế: " + String.format("%.2f",this.calculateTax());
    }
}
public class INHERITANCE014{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<Vehical> listVehical = new ArrayList<>();
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            String type = line[0];
            Vehical v = null;
            if(type.equals("Car")){
                double price = Double.parseDouble(line[1]);
                int numberOfSeats = Integer.parseInt(line[2]);
                v = new Car(price, numberOfSeats);
            }
            else if(type.equals("Truck")){
                double price = Double.parseDouble(line[1]);
                double loadCapacity = Double.parseDouble(line[2]);
                v = new Truck(price, loadCapacity);
            }
            listVehical.add(v);
        }
        System.out.println("Danh sách phương tiện và thuế:");
        double sum = 0;
        for(Vehical v : listVehical){
            System.out.println(v);
            sum += v.calculateTax();
        }
        System.out.println("Tổng thuế phải đóng: " + String.format("%.2f",sum));
    }
}