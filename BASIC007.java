import java.util.Scanner;

public class BASIC007 {
    static int namNhuan(int n){
        if (n % 400 == 0){
            return 1;
        }
        if (n%100 == 0){
            return 0;
        }
        if (n % 4 == 0){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t --> 0){
            int n = sc.nextInt();
            if (namNhuan(n) == 1){
                System.out.println(n + " : Leap-year");
            }
            else System.out.println(n + " : Non Leap-year");
        }
        sc.close();
    }
}
