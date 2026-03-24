/*
BASIC002 - Máy nghe nhạc
 */
import java.util.*;
public class BASIC002 {
    public static int MOD = 1000000007;
    public static int solve(int k, int n, int goal){
        long [][] dp = new long[goal+1][n+1];
        // Base case: Playlist độ dài 0, có 0 bài hát là 1 cách (playlist rỗng)
        dp[0][0] = 1;
        for(int i = 1; i<=goal; i++){
            for(int j = 1; j<=Math.min(i,n);j++){
                //Thêm một bài hát mới chưa được sử dụng trước đó
                dp[i][j] = dp[i-1][j-1] * (n - (j-1)) % MOD;
                if(j>k){
                    // Thêm một bài hát dax được sử dụng trước đó
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD;
                }
            }
        }
        return (int) dp[goal][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int goal = sc.nextInt();
            System.out.println(solve(k,n,goal));
        }
    }
}
