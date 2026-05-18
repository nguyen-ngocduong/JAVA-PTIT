/*
INHERITANCE015 - Thiết bị
*/
import java.util.*;

class Device{
    private double basePrice;
    public Device(double basePrice){
        this.basePrice = basePrice;
    }
    public double calculateWarrantyCost(){return 0;}
    public double getBasePrice(){return this.basePrice;}
    public String getType(){return "";}
    public String toString(){return "";}
}
class Laptop extends Device{
    private int ramSize;
    public Laptop(double basePrice, int ramSize){
        super(basePrice);
        this.ramSize = ramSize;
    }
    @Override
    public double calculateWarrantyCost(){
        return super.getBasePrice() * 0.07;
    }
    @Override 
    public String getType(){return "Laptop";}
    @Override
    public String toString(){
        return this.getType() + " - Giá gốc: " + String.format("%.2f",super.getBasePrice())
            + ", Dung lượng RAM: " + this.ramSize + " GB, Chi phí bảo hành: " + String.format("%.2f",this.calculateWarrantyCost());
    }
}
class Smartphone extends Device{
    private double screenSize;
    public Smartphone(double basePrice, double screenSize){
        super(basePrice);
        this.screenSize = screenSize;
    }
    @Override
    public double calculateWarrantyCost(){
        return super.getBasePrice() * 0.05 + this.screenSize * 50;
    }
    @Override
    public String getType(){return "Smartphone";}
    @Override
    public String toString(){
        return this.getType() + " - Giá gốc: " + String.format("%.2f",super.getBasePrice())
            + ", Kích thước màn hình: " + String.format("%.2f",this.screenSize) + " inch, Chi phí bảo hành: " + String.format("%.2f",this.calculateWarrantyCost());
    }
}
public class INHERITANCE015{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<Device> listDevice = new ArrayList<>();
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            String tenThietBi = line[0];
            double basePrice = Double.parseDouble(line[1]);
            Device d = null;
            if(tenThietBi.equals("Laptop")){
                int ramSize = Integer.parseInt(line[2]);
                d = new Laptop(basePrice, ramSize);
            }
            else if(tenThietBi.equals("Smartphone")){
                double screenSize = Double.parseDouble(line[2]);
                d = new Smartphone(basePrice, screenSize);
            }
            listDevice.add(d);
        }
        System.out.println("Danh sách thiết bị và chi phí bảo hành:");
        double sum = 0;
        for(Device d : listDevice){
            System.out.println(d);
            sum += d.calculateWarrantyCost();
        }
        System.out.println("Tổng chi phí bảo hành: " + String.format("%.2f", sum));
    }
}