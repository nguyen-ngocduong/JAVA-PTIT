import java.util.*;
class Student {
    private int id;
    private String name;
    private double cpga;
    public Student(String name, double cpga, int id){
        this.name = name;this.cpga = cpga; this.id = id;
    }
    public int getId(){return this.id;}
    public double getCPGA(){return this.cpga;}
    public String getName(){return this.name;}
}
class Priorities{
    private PriorityQueue<Student> queue;
    public List<Student> getStudents(List<String> events()){
        queue = new PriorityQueue<>(new Comparator<>(Student){
            @Override
            public int compare(Student o1, Student o2){
                if(Double.compare(o1.getCPGA(), o2.getCPGA()) != 0){
                    return Double.compare(o2.getCPGA(), o1.getCPGA()); // cpga giam dan
                }
                if(o1.getName().equals(o2.getName())){
                    return o1.getName().compareTo(o2.getName()); // A-Z
                }
                return o1.getId() - o2.getId();
            }
        });
        for(String event : events){
            String [] parts = event.split("\\s+");
            if(parts.length == 1){
                if(!queue.isEmpty()) queue.poll();
            }
            else queue.add(new Student(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
        }
        List<Student> list = new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }
}
public class B{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt();
        List<String> events = new ArrayList<>();
        while(t-->0){
            String event = sc.nextLine();
            events.add(event);
        }
        Priorities p = new Priorities();
        List<Student> listStudent = p.getStudents(events);
        if(student.isEmpty()) System.out.println("EMPTY");
        else {
            for(Student s : lsitStudent){
            	System.out.println(s.getName());
        	}
        }
    }
}