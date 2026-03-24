/*
Số lượng các chữ số tăng dần lớn nhất trong dãy
viết hàm longestSortedSequence
 */
import java.util.*;
public class BASIC012 {
    public static int longestSortedSequence (ArrayList<Integer> a){
        if (a.size() == 0) return 0;
        int cnt = 1, ans = 1;
        for(int i = 1; i<a.size(); i++){
            if (a.get(i) >= a.get(i - 1)) {
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else cnt = 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t --> 0){
            String s = sc.nextLine();
            String [] list = s.split(" ");
            ArrayList<Integer> a = new ArrayList<>();
            for(String x : list){
                a.add(Integer.valueOf(x));
            }
            int ans = longestSortedSequence(a);
            System.out.println(ans);
        }
    }
}
/*
Cachs 2:
import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            String [] a = s.split("\\s+");
            int maxLen = 1;
            int curLen = 1;
            for (int i = 1; i < a.length; i++) {
                if (Integer.parseInt(a[i]) >= Integer.parseInt(a[i - 1])) {
                    curLen++;
                } else {
                    maxLen = Math.max(maxLen, curLen);
                    curLen = 1;
                }
            }
            maxLen = Math.max(maxLen, curLen);
            System.out.println(maxLen);
        }
    }
}
*/