/*
Cho mảng A[] gồm n phần tử và số k. Đếm tất cả các cặp phần tử của mảng có tổng
bằng k. Ví dụ A[] = {1, 5, 3, 4, 2 }, k = 7 ta có kết quả là 2 cặp (3, 4), (5, 2).
 */
import java.util.*;
public class DSA001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(), k = sc.nextInt();
            int [] a = new int[n];
            for(int i = 0; i<n; i++) a[i] = sc.nextInt();
            int cnt = 0;
            for(int i = 0; i<n; i++){
                for(int j = i+1; j < n; j++){
                    if(a[i] + a[j] == k) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
