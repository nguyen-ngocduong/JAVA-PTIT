/*
STRING004 - Sử dụng StringBuffer để lấy chiều dài chuỗi
 */
package laptrinhptit;
import java.util.*;
public class STRING004{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            StringBuffer sb = new StringBuffer(sc.nextLine());
            System.out.println(sb.length());
        }
    }
}
