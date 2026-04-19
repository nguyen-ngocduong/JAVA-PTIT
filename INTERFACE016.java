import java.util.*;
interface Callable{
    String call();
}
interface Browsable{
    String browser();
}
class Smartphone{
    private List<String> numbers;
    private List<String> urls;
    public Smartphone(List<String> numbers, List<String> urls){
        this.numbers = numbers;
        this.urls = urls;
    }
    public String call(){
        String res = "";
        for(String s : this.numbers){
            s = s.toUpperCase();
            boolean hasChar = false;
            for(char x : s.toCharArray()){
                if(x >= 65 && x <= 90) {
                    hasChar = true;
                    break;
                }
            }
            if(hasChar) res += "Invalid number!\n";
            else res += "Calling... " + s + "\n";
        }
        return res;
    }
    public String browser(){
        String res = "";
        for(String s : this.urls){
            boolean hasNum = false;
            for(char x : s.toCharArray()){
                if(x >= 48 && x <= 57) {
                    hasNum = true;
                    break;
                }
            }
            if(hasNum) res += "Invalid URL!\n";
            else res += "Browsing: " + s + "!\n";
        }
        return res;
    }
}
public class INTERFACE016{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t-->0){
            String [] line1 = sc.nextLine().split("\\s+");
            String [] line2 = sc.nextLine().split("\\s+");
            List<String> numbers = new ArrayList<>();
            for(String s : line1){
                numbers.add(s);
            }
            List<String> urls = new ArrayList<>();
            for(String s : line2){
                urls.add(s);
            }
            Smartphone sm = new Smartphone(numbers, urls);
            System.out.print(sm.call());
            System.out.print(sm.browser());
        }
    }
}