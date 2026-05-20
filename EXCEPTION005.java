import java.util.*;
import java.io.*;

class InsufficientFundsException extends Exception{
    /*So du ko du*/
    public InsufficientFundsException(String message){
        super(message);
    }
}
class IllegalArgumentException extends Exception{
    /*So tien rut am*/
    public IllegalArgumentException(String message){
        super(message);
    }
}
class InputException extends Exception{
    //Nhap sai
    public InputException(String message){
        super(message);
    }
}
class BankAccount{
    private double balance;
    public BankAccount(double balance){
        this.balance = balance;
    }
    public void withdraw(String amount) throws InsufficientFundsException, IllegalArgumentException, InputException{
        double value = 0;
        try{
            value = Double.parseDouble(amount);
        }catch(NumberFormatException e){
            System.out.print("Lỗi: ");
            throw new InputException("Vui lòng nhập số hợp lệ!");
        }
        if(value < 0){
            System.out.print("Lỗi: ");
            throw new InsufficientFundsException("Số tiền rút không được âm!");
        }
        else if(this.balance < value){
            System.out.print("Lỗi: ");
            throw new InsufficientFundsException("Số dư không đủ để rút " + String.format("%.1f", value));
        }
        else{
            System.out.println("Rút tiền thành công! Số dư còn lại: " + String.format("%.1f", this.balance - value));
        }
    }
}
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            double balance = Double.parseDouble(sc.nextLine());
            BankAccount b = new BankAccount(balance);
            while(sc.hasNextLine()){
                String amount = sc.nextLine();
                try{
                    b.withdraw(amount);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}