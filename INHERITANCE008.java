/*
INHERITANCE008 - Tín chỉ
 */
import java.util.*;
class Person {
    private String name;
    private String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName() {return this.name;}
    public String getAddress() {return this.address;}
}
class Student extends Person {
    private int credits;
    public Student(String name, String address){
        super(name, address);
        //this.credits = credits;
    }
    public void study(){
        this.credits++;
    }
    public int Credit(){
        return this.credits;
    }
    public String toString(){
        return super.getName() + " - " + super.getAddress();
    }
}
public class INHERITANCE008 {
    public static void main(String[] args) {
        Student s = new Student("Ollie" ,  "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(s);
        System.out.println("Study credits " + s.Credit());
        s.study();
        System.out.println("Study credits " + s.Credit());
    }
}
