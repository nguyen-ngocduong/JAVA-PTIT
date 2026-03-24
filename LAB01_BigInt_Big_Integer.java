/*
LAB01_BigInt - Big Integer
 */
import java.util.*;
import java.math.BigInteger;
public class LAB01_BigInt_Big_Integer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            String [] a = s.split("\\s+");
            BigInteger x = new BigInteger(a[0]);
            BigInteger y = new BigInteger(a[2]);
            BigInteger res  = new BigInteger("0");
            switch(a[1]){
                case "+" -> res = x.add(y);
                case "-" -> res = x.subtract(y).abs();
                case "*" -> res = x.multiply(y);
            }
            System.out.println(res);
        }
    }
}
