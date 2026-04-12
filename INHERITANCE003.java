class Person{
    private String name;
    private String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String toString(){
        return this.name + " - " + this.address;
    }
}
class Student extends Person{
    private int credits;
    private String studentId;
    public Student(String name, String address, String studentId){
        super(name, address);
        this.credits = 0;
        this.studentId = studentId;
    }
    public void study(){
        this.credits++;
    }
    public int getCredits(){
        return this.credits;
    }
    @Override
    public String toString(){
        return super.getName() + " - " + super.getAddress() + " " + this.studentId;
    }
}
public class INHERITANCE003 {
    public static void main(String [] args){
        Student s = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles", "90028");
        System.out.println(s);
        System.out.println("Study credits " + s.getCredits());
        s.study();
        System.out.println("Study credits " + s.getCredits());
    }
}
