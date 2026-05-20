import java.util.*;
class CurrentException extends Exception{
    public CurrentException(String message){
        super(message);
    }
}
class Amount{
    private String current;
    private int amount;
    public Amount(String current, int amount){
        this.current = current;
        this.amount = amount;
    }
    public void add(Amount other) throws CurrentException{
        if(!this.current.equals(other.current)){
            throw new CurrentException("Currency doesn't match");
        }
        else {
            this.amount += other.amount;
            System.out.println(this.amount);
        }
    }
    public int getAmount(){
        return this.amount;
    }
}
public class EXCEPTION001{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            String current1 = line[0], current2 = line[2];
            int amount1 = Integer.parseInt(line[1]), amount2 = Integer.parseInt(line[3]);
            Amount a1 = new Amount(current1, amount1), a2 = new Amount(current2, amount2);
            try{
                a1.add(a2);
            }catch(CurrentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}