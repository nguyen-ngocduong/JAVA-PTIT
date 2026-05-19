/*
GENERIC004 - Hàng đợi ưu tiên
*/
import java.util.*;
class EmptyQueueException extends Exception{
    public EmptyQueueException(String message){
        super(message);
    }
}
class GenericPriorityQueue <T extends Comparable <T>>{
    private PriorityQueue<T> queue;
    public GenericPriorityQueue(){
        this.queue = new PriorityQueue<>();
    }
    public void add(T item){
        queue.add(item);
    }
    public T poll() throws EmptyQueueException{
        if(queue.isEmpty()) throw new EmptyQueueException("Empty queue");
        return queue.poll();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
class Task implements Comparable<Task> {
    private String name;
    private int Priority;
    // ghi thu tu uu tien
    private static int counter = 0;
    private int order;
    public Task(String name, int Priority){
        this.name = name; this.Priority = Priority;
        this.order = counter++;
    }
    @Override
    public int compareTo(Task other){
        // sap xep theo thu tu uu tien nho trc
        if(this.Priority != other.Priority){
            return this.Priority - other.Priority;
        }
        //sẽ lấy theo trật tự khi thêm mới.
        return this.order - other.order;
    }
    @Override
    public String toString(){
        return "Task [" + this.name + "] " + this.Priority;
    }
}
class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    // ghi thu tu uu tien
    private static int counter = 0;
    private int order;
    public Student(String name, double gpa){
        this.name = name; this.gpa = gpa;
        this.order = counter++;
    }
    @Override
    public int compareTo(Student other){
        // sap xep theo thu tu gpa lon trc
        if(this.gpa != other.gpa){
            return (int)(other.gpa - this.gpa);
        }
        //sẽ lấy theo trật tự khi thêm mới.
        return this.order - other.order;
    }
    @Override
    public String toString(){
        return "Student [" + this.name + "] " + this.gpa;
    }
}
public class GENERIC004{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        GenericPriorityQueue<Task> PriorityTask =  new GenericPriorityQueue<>();
        GenericPriorityQueue<Student> PriorityStudent = new GenericPriorityQueue<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("exit")) break;
            //Task [The thermal revenues were Good.] 3
            int firstSpace = line.indexOf(" ");
            int leftBracket = line.indexOf("[");
            int rightDot = line.indexOf(".");
            String status = line.substring(0, firstSpace);
            String name = line.substring(leftBracket + 1, rightDot);
            String part = line.substring(rightDot + 3);
            if(status.equals("Task")){
                Task t = new Task(name, Integer.parseInt(part));
                PriorityTask.add(t);
            }
            else if(status.equals("Student")){
                Student s = new Student(name, Double.parseDouble(part));
                PriorityStudent.add(s);
            }
        }
        System.out.println("[Task Queue]");
        if(PriorityTask.isEmpty()){
            System.out.println("Không có nhiệm vụ trong hàng đợi.");
        } else{
            try{
                while(!PriorityTask.isEmpty()){
                    System.out.println(PriorityTask.poll());
                }
            }catch(EmptyQueueException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        System.out.println("[Student Queue]");
        if(PriorityStudent.isEmpty()){
            System.out.println("Không có sinh viên trong hàng đợi.");
        }else{
            try{
                while(!PriorityStudent.isEmpty()){
                    System.out.println(PriorityStudent.poll());
                }
            }catch(EmptyQueueException e){
                System.out.println(e.getMessage());
            }
        }
    }
}