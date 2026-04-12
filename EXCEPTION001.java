import java.util.*;
class Amount{
    private String currency;
    private int amount;
    public Amount(String currency, int amount){
        this.currency = currency;
        this.amount = amount;
    }
    public String getCurrency(){return this.currency;}
    public int getAmount(){return this.amount;}
    public void add(Amount other){
        if (this.currency.equals(other.currency)) {
            this.amount += other.amount;
            System.out.println(this.getAmount());
        } else {
            System.out.println("Currency doesn't match");
        }
    }
}
public class EXCEPTION001{
    public static void main(String [] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String [] part = sc.nextLine().split("\\s+");
            String currency1 = part[0], currency2 = part[2];
            int amount1 = Integer.valueOf(part[1]), amount2 = Integer.valueOf(part[3]);
            Amount a1 = new Amount(currency1, amount1);
            Amount a2 = new Amount(currency2, amount2);
            a1.add(a2);
        }
    }
}