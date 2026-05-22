/*
INHERITANCE012 - Quản lí nhân viên
*/
import java.util.*;
class Employee{
    private String name;
    private double salary;
    public Employee(String name, double salary){
        this.name = name; this.salary = salary;
    }
    public Employee(String name){
        this.name = name; 
    }
    public String getName() {return this.name;}
    public double getSalary(){return this.salary;}
    public String getInfo(){
        return "";
    }
    public double calculateSalary(){
        return this.salary;
    }
}
class FullTimeEmployee extends Employee{
    private double bonus;
    public FullTimeEmployee(String name, double salary, double bonus){
        super(name, salary);
        this.bonus = bonus;
    }
    @Override
    public double calculateSalary(){
        return this.bonus + super.getSalary();
    }
    @Override
    public String getInfo(){
        String res = "";
        res += "Họ tên: " + super.getName();
        res += "\nLương cơ bản: "  + String.format("%.1f",super.getSalary());
        res += "\nThưởng: " + this.bonus;
        res += "\n=> Lương thực nhận: " + String.format("%.1f",this.calculateSalary());
        return res;
    }
}
class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked){
        super(name);
        this.hourlyRate=hourlyRate; this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalary(){
        return this.hourlyRate * this.hoursWorked;
    }
    @Override
    public String getInfo(){
        String res = "";
        res += "Họ tên: " + super.getName();
        res += "\nSố giờ làm việc: "  + this.hoursWorked + " giờ";
        res += "\nTiền công mỗi giờ: " + this.hourlyRate;
        res += "\n=> Lương thực nhận: " + String.format("%.1f",this.calculateSalary());
        return res;
    }
}
public class INHERITANCE012{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Map<Employee, String> map = new LinkedHashMap<>();
        while(sc.hasNextLine()){
            String status = sc.nextLine(), name = sc.nextLine();
            if(status.equals("FullTime")){
                double salary = Double.parseDouble(sc.nextLine());
                double bonus = Double.parseDouble(sc.nextLine());
                FullTimeEmployee e = new FullTimeEmployee(name, salary, bonus);
                map.put(e,"FullTime");
            }
            else if(status.equals("PartTime")){
                int hoursWorked = Integer.parseInt(sc.nextLine());
                double hourlyRate = Double.parseDouble(sc.nextLine());
                PartTimeEmployee e = new PartTimeEmployee(name, hourlyRate, hoursWorked);
                map.put(e,"PartTime");
            }
        }
        System.out.println("--- Thông tin nhân viên ---");
        for(Employee e : map.keySet()){
            System.out.println("Loại: " + map.get(e));
            System.out.println(e.getInfo());
            System.out.println();
        }
    }
}