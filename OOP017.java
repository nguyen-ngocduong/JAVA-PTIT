import java.util.*;
class Final {
    static void f(boolean[] a, String[] b, Integer c) {
        System.out.println(b[0]);
        a[0] = true;
        c = c + 1;
        System.out.println(a[0]);
        System.out.println(c);
    }
    static void d(int d, char e, StringBuffer f) {
        System.out.println(d);
        d = d + (int)e;
        System.out.println(f);
    }
    static void e(double g, byte i, Float h){
        g = g + h;
        System.out.println(i+g);
    }
}
public class OOP017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []line = sc.nextLine().split("\\s+");
        int a = 10;
        double b = 3.14;
        char c = 'c';
        String[] d = {"OOP", "2023"};
        Integer e = 1;
        boolean[] f = {false, true};
        StringBuffer g = new StringBuffer("Khoa Vien Thong");
        byte h = 20;
        Float i = 0.5f;
        Final fi = new Final();
        try{
         	switch(line[0]){
                case "a": 
                    fi.d(a,c,g);
                    break;
                case "f":
                    fi.f(f, d, e); 
                    break;
                case "b":
                    fi.e(b, h, i);
                    break;
            }   
        }catch(Exception e1){
            System.out.println(e1.getMessage());
        }
    }
}