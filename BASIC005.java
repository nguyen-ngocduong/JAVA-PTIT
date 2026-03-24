import java.util.Scanner;
import java.util.*;
public class BASIC005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t --> 0){
            int sum = 0, x = 0;
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i<5; i++){
                x = sc.nextInt();
                a.add(x);
            }
            for (int i : a){
                sum += i;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
