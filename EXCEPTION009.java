//EXCEPTION009 - Method Call Error
import java.io.*;
import java.util.*;
class MyMethods {
    public void m(int x) {
        try {
            m2(x);
            System.out.println(1);
        } catch (ArithmeticException e) {
            System.out.println(2);
        } catch (Exception e) {
            System.out.println(3);
        }
    }

    public void m2(int x) throws IOException {
        System.out.println(4);
        if (x == 1)
            throw new IOException();
        if (x == 0)
            throw new ArithmeticException();
        System.out.println(5);
    }
}
public class EXCEPTION009{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        MyMethods method = new MyMethods();
        method.m(t);
    }
}