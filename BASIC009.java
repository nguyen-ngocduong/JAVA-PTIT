/*
Với mỗi bộ test, cho hai số thực x và y biểu diễn tọa độ của một điểm trong hệ trục tọa độ Oxy.
 */
import java.util.*;
public class BASIC009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            double x = sc.nextDouble(), y = sc.nextDouble();
            int res = 0;
            sc.nextLine();
            if (x > 0 && y > 0){
                res = 1;
            }
            else if(x <0 && y > 0){
                res = 2;
            }
            else if(x < 0 && y < 0){
                res = 3;
            }
            else if (x > 0 && y < 0){
                res = 4;
            }
            System.out.println(res);
        }
        sc.close();
    }
}
