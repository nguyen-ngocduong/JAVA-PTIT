/*
Số nhỏ nhất trong khoảng cách của mảng
Viết một phương thức có tên minGap chấp nhận một mảng số nguyên làm lam số và 
trả về khoảng cách tối thiểu giữa các giá trị liền kề trong mảng.
 */
import java.util.*;
public class BASIC011 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t --> 0){
            String s = sc.nextLine();
            List<Integer> a = new ArrayList<>();
            String [] list = s.split(" ");
            for(String str : list){
                a.add(Integer.valueOf(str));
            }
            if(a.size() < 2){
                System.out.println(0);
                continue;
            }
            long min_distince_a = 1000000;
            for(int i = 1; i< a.size(); i++){
                min_distince_a = Math.min(min_distince_a, a.get(i) - a.get(i-1));
            }
            System.out.println(min_distince_a);
        }
        sc.close();
    }
}
