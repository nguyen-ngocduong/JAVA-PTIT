import java.util.*;
public class GENERIC002{
    public static int findFirstMatch(String [] array, String target, Map<String, Integer> map, int counter){
        for(int i = 0; i<array.length; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], counter);
            }
            counter++;
        }
        int res = -1;
        for(String s : map.keySet()){
            if(target.equals(s)){
                res = map.get(s);
            }
        }
        return res;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String [] line = sc.nextLine().split(" \\| ");
            String [] line1 = line[0].split("\\s+");
            String line2 = line[1];
            int counter = 0;
            Map<String, Integer> map = new LinkedHashMap<>();
            System.out.println(findFirstMatch(line1, line2, map, counter));
        }
    }
}