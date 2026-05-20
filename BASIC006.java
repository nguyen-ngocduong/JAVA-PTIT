//BASIC010 - Hoán đổi vị trí
import java.util.*;
public class BASIC010{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            char [] line = sc.nextLine().toCharArray();
            List<Integer> list = new ArrayList<>();
            for(char c : line){
                list.add(c - '0');
            }
            if(list.size()%2 == 1){
                for(int i = 1; i<list.size()-1; i+=2){
                    int tmp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1,tmp);
                }
            }
            else{
                for(int i = 0; i<list.size()-1; i+=2){
                    int tmp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1,tmp);
                }
            }
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}