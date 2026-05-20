/**
 * EXCEPTION004 - Class Utils
 */
import java.util.*;
import java.io.*;
class Utils {
    public static void u(String s) {
        try {
            System.out.println(s);
            z(s);
            try {
                System.out.println(Integer.parseInt(s)+1);
            } catch (Exception e) {
                System.out.println(s.toUpperCase());
            }
        } catch (Exception e) {
            System.out.println(1);
        }
    }

    public static void z(String s) throws IOException{
        System.out.println(2);
        if (s.length() == 1)
            throw new IOException();
        System.out.println(3);
    }
}
public class EXCEPTION004{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Utils ut = new Utils();
        ut.u(s);
    }
}