/*
EXCEPTION006 - Nguyên âm
 */
import java.util.*;
public class EXCEPTION006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String s = sc.nextLine().toLowerCase();
            boolean check = false;
            for(char x : s.toCharArray()){
                if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
                    check = true;
                    break;
                }
            }
            if(check) System.out.println("String has vowels");
            else System.out.println("String not contain vowels");
        }
    }
}
