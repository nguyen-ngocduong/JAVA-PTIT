import java.util.*;
class MyStuff {
    private String name;
    public MyStuff(String name) {
        this.name = name;
        //System.out.println("My Stuff is: " + name);
    }
    public boolean equals(MyStuff other){
        return this.name.equals(other.name);
	}
}
public class OOP019 {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");
        // a.
        if (m2.equals(m1)) System.out.println("value compared: same");
        else System.out.println("value compared: different");
        // b. Viết thêm code vào dấu ...
        // so sanh tham chieu o nho
        if(m2 == m1) System.out.println("reference compared: same");
        else System.out.println("reference compared: different");
    }
}