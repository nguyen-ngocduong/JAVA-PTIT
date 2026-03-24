/*
STRING003 - Kiểm tra chuỗi có bằng chuỗi khác hay không
 */
package laptrinhptit;
import java.util.*;
public class STRING003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            s1 = s1.toLowerCase(); s2 = s2.toLowerCase();
            System.out.println(s1.equals(s2));
        }
    }
}
