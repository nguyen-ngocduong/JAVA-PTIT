import java.util.*;
class Student{
    private String name;
    private int age;
    private static int numberOfStudent = 0;
    public Student(String name, int age){
        this.name = name; this.age = age;
        this.numberOfStudent++;
    }
    public void display(){
        if(this.age >= 18){
            System.out.println(this.name);
        }
    }
}
public class OOP009{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();
        while(sc.hasNextLine()){
            String name = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());
            list.add(new Student(name, age));
        }
        for(Student s : list){
            s.display();
        }
        System.out.println(list.size());
    }
}