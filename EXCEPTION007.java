/*
*EXCEPTION007 - Quản lý nhiệt độ lò phản ứng
*/
import java.util.*;
import java.io.*; 
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
class InputException extends IOException{
    public InputException(String message){
        super(message);
    }
}
class Reactor{
    private double temperature;
    public Reactor(double temperature){
        this.temperature = temperature;
    }
    public void increaseTemperature(String amount) throws IllegalArgumentException, OverheatException, InputException{
        double value = 0;
        try{
            value = Double.parseDouble(amount);
        }catch(NumberFormatException e){
            System.out.print("Nhập: " + amount + " => ");
            throw new InputException("Lỗi: Định dạng không hợp lệ.");
        }
        if(value <= 0){
            System.out.print("Nhập: " + amount + " => ");
            throw new IllegalArgumentException("Lỗi: Giá trị tăng phải lớn hơn 0.");
        }
        else if(this.temperature + value > 1000){
            System.out.print("Nhập: " + amount + " => ");
            throw new OverheatException("Lỗi: Vượt quá ngưỡng an toàn! Nhiệt độ nguy hiểm.");
        }
        else {
            System.out.println("Nhiệt độ hiện tại: " + (this.temperature += value) + "độ C");
        }
    }
}
public class EXCEPTION007{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        double temp = Double.parseDouble(sc.nextLine());
        Reactor r = new Reactor(temp);
        while(sc.hasNextLine()){
            String amount = sc.nextLine(); 
            try{
            	r.increaseTemperature(amount);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}