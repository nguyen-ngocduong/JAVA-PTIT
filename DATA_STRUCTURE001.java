/*
DATA_STRUCTURE001 - Hàng đợi ưu tiên
 */
import java.util.*;
class Student_001{
    private int id;
    private String name;
    private double cgpa;
    public Student_001(int id, String name, double cgpa){
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }
    public int getID(){return this.id;}
    public String getName(){return this.name;}
    public double getCGPA(){return this.cgpa;}
}
class Priorities{
    private PriorityQueue<Student_001> queue;
    public List<Student_001> getStudent(List<String> events){
        queue = new PriorityQueue<>(new Comparator<Student_001>(){
            @Override
            public int compare(Student_001 o1, Student_001 o2){
                if(Double.compare(o1.getCGPA(), o2.getCGPA()) != 0){
                    return Double.compare(o2.getCGPA(), o1.getCGPA());
                }
                if(o1.getName().equals(o2.getName())){
                    return o1.getName().compareTo(o2.getName());
                }
                return Integer.compare(o1.getID(), o2.getID());
            }
        });
        for(String event : events){
            String [] parts = event.split("\\s+");
            if(parts.length == 1){
                if(!queue.isEmpty()) queue.poll();
            }
            else queue.add(new Student_001(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2])));
        }
        List<Student_001> list =new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }
}
public class DATA_STRUCTURE001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();sc.nextLine();
        List<String> events = new ArrayList<>();
        while(t-->0){
            events.add(sc.nextLine());
        }
        Priorities p = new Priorities();
        List<Student_001> student = p.getStudent(events);
        if(student.isEmpty()) System.out.println("EMPTY");
        else {
            for(Student_001 s : student) {
                System.out.println(s.getName());
            }
        }
    }
}