/*
INHERITANCE012 - Quản lí nhân viên
*/
import java.util.*;
class Employee{
    private String name;
    private double salary;
    //constructor
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public String getInfo(){
        return this.name;
    }
    public double getSalary(){
        return salary;
    }
    public double calculateSalary(){
        return this.salary;
    }
}
class FullTimeEmployee extends Employee{
    private double bonus;
    public FullTimeEmployee(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public double calculateSalary(){
        return super.calculateSalary() + this.bonus;
    }
    public String toString(){
        String ans = String.format("Họ tên: %s\n",super.getInfo())
            + String.format("Lương cơ bản: %.1f\n",super.getSalary())
            + String.format("Thưởng: %.1f\n",this.bonus)
            + String.format("=> Lương thực nhận: %.1f",this.calculateSalary());
        return ans;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary(){
        return this.hourlyRate * this.hoursWorked;
    }
    public String toString(){
        String ans = String.format("Họ tên: %s\n",super.getInfo())
            + String.format("Số giờ làm việc: %d giờ\n",this.hoursWorked)
            + String.format("Tiền công mỗi giờ: %.1f\n",this.hourlyRate)
            + String.format("=> Lương thực nhận: %.1f",this.calculateSalary());
        return ans;
    }
}
public class INHERITANCE012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Thông tin nhân viên ---");
        for(int i = 0; i<2; i++){
            String loaiNhanVien = sc.nextLine();
            if(loaiNhanVien.equals("FullTime")){
                String name = sc.nextLine();
                double salary = Double.parseDouble(sc.nextLine());
                double bonus = Double.parseDouble(sc.nextLine());
                FullTimeEmployee nhanVien = new FullTimeEmployee(name, salary, bonus);
                System.out.println("Loại: FullTime");
                System.out.println(nhanVien);
            }
            else if(loaiNhanVien.equals("PartTime")){
                String name = sc.nextLine();
                int hoursWorked = Integer.parseInt(sc.nextLine());
                double hourlyRate = Double.parseDouble(sc.nextLine());
                PartTimeEmployee sinhVien = new PartTimeEmployee(name, hoursWorked, hourlyRate);
                System.out.println("Loại: PartTime");
                System.out.println(sinhVien);
            }
            if(i==0) System.out.println();
        }
    }
}