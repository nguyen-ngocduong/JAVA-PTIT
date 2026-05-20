/*
EXCEPTION006 - Nguyên âm
 */
import java.util.*;
class NotContainVowelException extends Exception{
    public NotContainVowelException(String message){
        super(message);
    }
}
public class EXCEPTION006{
    public static void checkString(String s) throws NotContainVowelException{
        if(!s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o") && !s.contains("u")){
            throw new NotContainVowelException("String not contain vowels");
        }
        else System.out.println("String has vowels");
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.nextLine().toLowerCase();
            try{
                checkString(s);
            }catch(NotContainVowelException e){
                System.out.println(e.getMessage());
            }
        }
    }
}