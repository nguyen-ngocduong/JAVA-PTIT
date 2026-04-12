//EXCEPTION003 : Xe cộ đã sử dụng
import java.util.*;
class UsedCarException extends Exception{
    public UsedCarException(String message){
        super(message);
    }
}
class UsedCar{
    private String vin;
    private String make;
    private int year, mileage, price;
    public UsedCar(String vin, String make, int year, int mileage, int price) throws UsedCarException{
        this.vin = vin; this.make = make;
        this.year = year; this.mileage = mileage;
        this.price = price;
        if(this.vin.length() != 4 || !(this.make.equals("Ford") || this.make.equals("Honda") || this.make.equals("Toyota") || this.make.equals("Chrysler")) || (this.year < 1990 || this.year > 2014) || this.mileage < 0){
            throw new UsedCarException("Invalid UsedCar: VIN " + this.vin);
        }
    }
    public String toString(){
        return "UsedCar{vin='" + this.vin +"', make='" + this.make 
            + "', year=" + this.year +", mileage=" + this.mileage + ", price=" + String.format("%.1f", (double)this.price) + "}";
    }
}
public class EXCEPTION003{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        List<UsedCar> list = new ArrayList<>();
        while(t-->0){
            String [] part = sc.nextLine().split(",");
            String vin = part[0], make = part[1];
            int year = Integer.valueOf(part[2]), mileage = Integer.valueOf(part[3]), price = Integer.valueOf(part[4]);
            try{
                UsedCar u = new UsedCar(vin, make, year, mileage, price);
                list.add(u);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("List of successfully constructed UsedCar objects:");
        if(list.size() == 0){
            System.out.print("No used cars");
        }
        for(UsedCar u : list){
            System.out.println(u);
        }
    }
}