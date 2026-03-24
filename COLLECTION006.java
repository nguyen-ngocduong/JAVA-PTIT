/*
COLLECTION006 - Tìm giá trị hiếm nhất
 */
import java.util.*;
public class COLLECTION006 {
    private static int MOD = 100007;
    private static int solve(HashMap<String, Integer> map){
        int [] a = new int[MOD];
        for(int value : map.values()){
            a[value]++;
        }
        int min_val = MOD, res = MOD;
        for(int value : map.values()){
            min_val = Math.min(min_val, a[value]);
        }
        for(int value : map.values()){
            if(a[value] == min_val) res = Math.min(res, value);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            String [] a = s.split("\\s+");
            HashMap<String,Integer> map = new HashMap<>();
            for(int i = 0; i<a.length; i+=2){
                map.put(a[i], Integer.valueOf(a[i+1]));
            }
            System.out.println(solve(map));
        }
    }
}
