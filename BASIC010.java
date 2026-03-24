/*
Đảo số: 482596 -> 845269
 */
import java.util.*;
public class BASIC010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0) {
            long n = sc.nextLong();
            int tmp = 1, res = 0;
            while(n >= 10){ // thực hiện đảo ngược 1 cặp số
                res += 10 * tmp * (n%10);
                n /= 10;
                res += tmp * (n % 10);
                n /= 10;
                tmp *= 100;
            }
            System.out.println(res + tmp * n);
        }
    }
}
