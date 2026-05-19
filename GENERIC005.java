/*
GENERIC005 - Công việc và lịch sử
 */
import java.util.*;
class EmptyStackException extends Exception{
    public EmptyStackException(String message){
        super(message);
    }
}
class Stack<T extends Comparable<T>> {
    private ArrayList<T> stack;
    public Stack(){
        this.stack = new ArrayList<>();
    }
    public void push(T item){
        this.stack.add(item);
    }
    public T peek() throws EmptyStackException{
        if(this.stack.isEmpty()) throw new EmptyStackException("Empty Stack");
        return this.stack.get(stack.size()-1);
    }
    public T pop() throws EmptyStackException{
        if(this.stack.isEmpty()) throw new EmptyStackException("Empty Stack");
        return this.stack.remove(stack.size()-1);
    }
    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
    public ArrayList<T> getAll(){
        return this.stack;
    }
}
class Task implements Comparable<Task>{
    private String name;
    private int Priority;
    // lay thu tu uu tien
    private static int counter = 0;
    private int order;
    public Task(String name, int Priority){
        this.name = name; this.Priority = Priority;
        this.order = counter ++;
    }
    @Override
    public int compareTo(Task other){
        // sap xep theo thu tu uu tien
        if(this.Priority != other.Priority){
            return this.Priority - other.Priority;
        }
        // sắp xếp theo thứ tự LIFO
        return other.order - this.order;
    }
    @Override
    public String toString(){
        return "Task [" + this.name + "] " + this.Priority;
    }
}
class History implements Comparable<History>{
    private String action;
    private static int counter = 0;
    private int order;
    public History(String action){
        this.action = action;
        this.order = counter++;
    }
    @Override
    public int compareTo(History other){
        //so sanhtheo thu tu Z-A
        return other.action.compareTo(this.action);
    }
    @Override
    public String toString(){
        return "History [" + this.action + ".]";
    }
}
public class GENERIC005{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Stack<Task> taskStack = new Stack<>();
        Stack<History> historyStack = new Stack<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("exit")) break;
            int firstSpace = line.indexOf(" ");
            int leftBracket = line.indexOf("[");
            int rightDot = line.lastIndexOf(".]");
            String status = line.substring(0, firstSpace);
            String name = line.substring(leftBracket+1, rightDot);
            if(status.equals("Task")){
                int Priority = Integer.parseInt(line.substring(rightDot+3));
                Task t = new Task(name, Priority);
                taskStack.push(t);
            }
            else if(status.equals("History")){
                History h = new History(name);
                historyStack.push(h);
            }
        }
        System.out.println("[Task Stack]");
        if(taskStack.isEmpty()){
            System.out.println("Không có công việc trong ngăn xếp.");
        } else{
            ArrayList<Task> tasks = taskStack.getAll();
            Collections.sort(tasks);
            for(Task t : tasks){
                System.out.println(t);
            }
        }
        System.out.println();
        System.out.println("[History Stack]");
        if(historyStack.isEmpty()){
            System.out.println("Không có lịch sử trong ngăn xếp.");
        }else{
            ArrayList<History> tasks = historyStack.getAll();
            Collections.sort(tasks);
            for(History t : tasks){
                System.out.println(t);
            }
        }
    }
}