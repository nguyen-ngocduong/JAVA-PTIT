/*
STRING006 - Chữ cái đầu tiên
 */

import java.util.*;
public class STRING006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            System.out.print("My initials are: ");
            for(char x : s.toCharArray()){
                if(x >= 65 && x <= 90){
                    System.out.print(x);
                }
            }
            System.out.println();
        }
    }
}
