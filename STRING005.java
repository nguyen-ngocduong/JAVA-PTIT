import java.util.*;
public class Main{
    public static String findLongestWord(String sentence){
        String [] part = sentence.split("\\s+");
        int maxLength = 0;
        String res = "";
        for(int i = 0; i<part.length; i++){
            if(maxLength <= part[i].length()){
                maxLength = part[i].length();
                res = part[i];
            }
        }
        return res;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String line = sc.nextLine();
            System.out.println(findLongestWord(line));
        }
    }
}