//EXCEPTION005 - Rút tiền ngân hàng
import java.util.*;
class IllegalArgumentException extends Exception{
    public IllegalArgumentException(String s){
        super(s);
    }
}
class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String s){
        super(s);
    }
}
class BankAccount{
    private double balance;
    public BankAccount(double balance){
        this.balance = balance;
    }
    public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException{
        if(amount > this.balance){
            throw new InsufficientFundsException("Lỗi: Số dư không đủ để rút " + amount);
        }
        else if(amount < 0){
            throw new IllegalArgumentException("Lỗi: Số tiền rút không được âm!");
        }
        else if(amount > 0 && amount <= this.balance){
            this.balance -= amount;
        }
    }
    public double getBalance(){
        return this.balance;
    }
}
public class EXCEPTION005{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            double balance = Double.parseDouble(sc.nextLine());
            BankAccount account = new BankAccount(balance);
            String s = sc.nextLine();
            try{
                double test1 = Double.parseDouble(s);
                account.withdraw(test1);
            }catch(NumberFormatException e){
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(InsufficientFundsException e){
                System.out.println(e.getMessage());
            }
            double test2 = sc.nextDouble();
            double test3 = sc.nextDouble();
            double test4 = sc.nextDouble();
            List<Double> list = new ArrayList<>();
            list.add(test2);
            list.add(test3);
            list.add(test4);
            for(int i = 0; i<3; i++){
                try{
                    account.withdraw(list.get(i));
                    System.out.println("Rút tiền thành công! Số dư còn lại: " + account.getBalance());
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }catch(InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}