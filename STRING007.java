import java.util.*;
public class STRING007{
    public static boolean isPangram(String sentence){
        Set<Character> list = new HashSet<>();
        for(char c : sentence.toLowerCase().toCharArray()){
            if(c >= 'a' && c <= 'z'){
                list.add(c);
            }
        }
        return list.size() == 26;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String sentence = sc.nextLine();
            System.out.println(isPangram(sentence));
        }
    }
}