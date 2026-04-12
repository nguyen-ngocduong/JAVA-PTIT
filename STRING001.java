/*
STRING001 - TÌm chữ cái ở vị trí index nhất định
 */
import java.util.*;
public class STRING001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            String [] a = s.split("\\s+");
            System.out.print("The character at position " + a[1] + " is ");
            char [] tmp = a[0].toCharArray();
            System.out.print(tmp[Integer.parseInt(a[1])]);
            System.out.println();
        }
    }
}
