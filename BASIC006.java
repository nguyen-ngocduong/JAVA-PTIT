/*
BASIC006 - Number Character
 */
import java.util.*;
public class BASIC006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            char [] a = s.toCharArray();
            int dem = 0;
            for(char x : a){
                if(Character.isDigit(x)){
                    dem++;
                }
            }
            System.out.println(dem);
        }
    }
}
