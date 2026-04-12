/*
STRING009 - String Sposion
 */

import java.util.*;
public class STRING009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            char [] a = s.toCharArray();
            String res = "";
            for(int i = 0; i<a.length; i++){
                for(int j = 0; j<=i; j++){
                    res += a[j];
                }
            }
            System.out.println(res);
        }
    }
}
