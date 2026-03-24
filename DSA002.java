/*
Cho mảng A[] gồm N số nguyên không âm và số K. 
Nhiệm vụ của bạn là hãy chia mảng A[] thành haimảng con có kích cỡ K và N-K 
sao cho hiệu giữa tổng hai mảng con là lớn nhất. Ví dụ với mảng A[]= {8, 4, 5, 2, 10}, 
K=2 ta có kết quả là 17 vì mảng A[] được chia thành hai mảng {4, 2} và { 8, 5,10}
có hiệu của hai mảng con là 23-6=17 là lớn nhất.
 */
import java.util.*;
public class DSA002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(), k = sc.nextInt();
            int [] a = new int[n];
            for(int i = 0; i<n; i++) a[i] = sc.nextInt();
            k = Math.min(k, n-k);
            Arrays.sort(a);
            int sum1 = 0, sum2 = 0;
            for(int i = 0; i<k;i++) sum1+= a[i];
            for(int i = k; i<n; i++) sum2 += a[i];
            System.out.println(sum2-sum1);
        }
    }
}
