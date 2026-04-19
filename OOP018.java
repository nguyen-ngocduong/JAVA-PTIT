import java.util.*;
class Employee{
    private String name, department, email;
    private double salary;
    private int age;
    public Employee(String name, double salary, String department, String email, int age){
        this.name = name;this.salary = salary; this.department = department;
        this.email = email; this.age = age;
    }
    public Employee(String name, double salary, String department) {
        this(name, salary, department, "n/a", -1); 
    }
    public Employee(String name, double salary, String department, String email) {
        this(name, salary, department, email, -1);  
    }
    public Employee(String name, double salary, String department, int age) {
        this(name, salary, department, "n/a", age); 
    }
    public String getDepartment(){return this.department;}
    public double getSalary(){return this.salary;}
    public String toString(){
        return this.name + " " + String.format("%.2f",this.salary) + " "
            + this.email + " " + this.age;
    }
}
public class OOP018 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        HashMap<String, List<Employee>> map = new LinkedHashMap<>();
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            String name = line[0]; double salary = Double.parseDouble(line[1]);
            String department = line[2]; 
            Employee e;
            if(line.length == 5){
                String email = line[3];
                int age = Integer.parseInt(line[4]);
                e = new Employee(name, salary, department, email, age);
            }
            else if(line.length == 4){
                if(line[3].endsWith(".com")){
                    String email = line[3];
                    e = new Employee(name, salary, department, email);
                }
                else {
                    int age = Integer.parseInt(line[3]);
                    e = new Employee(name, salary, department, age);
                }
            }
            else e = new Employee(name, salary, department);
            map.putIfAbsent(e.getDepartment(), new ArrayList<>());
            map.get(e.getDepartment()).add(e); // add employee theo department
        }
        String topDepartment = "";
        double maxAvgSalary = 0.0;
        for(String department : map.keySet()){
            List<Employee> listEmployee = map.get(department);
            int cnt = 0; double sum = 0.0;
            for(Employee e : listEmployee){
                sum += e.getSalary();
                cnt++;
            }
            double avgSalary = sum / cnt;
            if(maxAvgSalary < avgSalary){
                maxAvgSalary = avgSalary;
                topDepartment = department;
            }
        }
        System.out.println("Highest Average Salary: " + topDepartment);
        for(Employee e : map.get(topDepartment)){
            System.out.println(e);
        }
    }
}
