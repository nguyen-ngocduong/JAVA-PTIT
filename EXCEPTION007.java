//EXCEPTION007 - Quản lý nhiệt độ lò phản ứng
import java.util.*;
class IllegalArgumentException extends Exception{
    public IllegalArgumentException(String message){
        super(message);
    }
}
class OverheatException extends Exception{
    public OverheatException(String message){
        super(message);
    }
}
class Reactor{
    private double temparature;
    public Reactor(double temparature){
        this.temparature = temparature;
    }
    public void increaseTemperature(double amount) throws IllegalArgumentException, OverheatException{
        if(amount <= 0){
            throw new IllegalArgumentException("Lỗi: Giá trị tăng phải lớn hơn 0.");
        }
        else if(this.temparature + amount > 1000){
            throw new OverheatException("Lỗi: Vượt quá ngưỡng an toàn! Nhiệt độ nguy hiểm.");
        }
        else{
            this.temparature += amount;
        }
    }
    public double getTemparature(){return this.temparature;}
}
public class EXCEPTION007{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double temporature = sc.nextDouble();
        Reactor r = new Reactor(temporature);
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println("Nhập: " + s + " => Lỗi: Định dạng không hợp lệ.");
        Double test2 = sc.nextDouble(), test3 = sc.nextDouble(), test4 = sc.nextDouble();
        List<Double> list = new ArrayList<>();
        list.add(test2); list.add(test3); list.add(test4);
        for(int i = 0; i<3; i++){
            try{
            	r.increaseTemperature(list.get(i));
                System.out.println("Nhiệt độ hiện tại: " + r.getTemparature() +"độ C");
        	}catch(IllegalArgumentException e){
                System.out.println("Nhập: " + String.format("%.0f",list.get(i)) + " => " + e.getMessage());
            }catch(OverheatException e){
                System.out.println("Nhập: " + String.format("%.0f",list.get(i)) + " => " + e.getMessage());
            }
        }
	}
}