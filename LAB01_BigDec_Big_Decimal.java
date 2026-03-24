/*
in ra tổng phần thập phân của tất cả các số thực trong dòng đó.
 */
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
public class LAB01_BigDec_Big_Decimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            String [] a = s.split("\\s+");
            BigDecimal res = new BigDecimal("0");
            for(String x : a){
                BigDecimal tmp = new BigDecimal(x);
                //xet phan nguyen
                BigInteger phanNguyen = tmp.toBigInteger();
                // Phan thap phan
                BigDecimal phanThapPhan = tmp.subtract(new BigDecimal(phanNguyen)); // tru
                res = res.add(phanThapPhan);//cong trong bigdecimal
            }
            System.out.println(res);
        }
    }
}
