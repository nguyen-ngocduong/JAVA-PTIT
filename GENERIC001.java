/*
GENERIC001 - Hoán đổi cặp
*/
import java.util.*;

class Pair<T>{
    private T first;
    private T second;
    public Pair(T first, T second){
        this.first = first; this.second = second;
    }
    public T getFirst(){return this.first;}
    public T getSecond(){return this.second;}
    public void setFirst(T fisrt){this.first = first;}
    public void setSecond(T second){this.second = second;}
    public void swap(){
        T tmp = first; 
        first = second;
        second = tmp;
    }
}
public class GENERIC001{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            if(line[0].charAt(0) <= 57 && line[0].charAt(0) >= 48 && line[1].charAt(0) <= 57 && line[1].charAt(0) >= 48){
                Pair<String> p = new Pair(line[0], line[1]);
                p.swap();
                System.out.println(p.getFirst() + " " + p.getSecond());
            }
            else{
                Pair<String> p = new Pair(line[0], line[1]);
                p.swap();
                System.out.println("'" + p.getFirst() + "' '" + p.getSecond() + "'");
            }
        }
    }
}