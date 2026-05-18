/**
 * INHERITANCE013 - Quản lí giảng viên
 */
import java.util.*;

class Teacher{
    private String name;
    private double baseSalary;
    public Teacher(String name){
        this.name = name;
    }
    public Teacher(String name, double baseSalary){
        this.name = name; this.baseSalary = baseSalary;
    }
    public String getInfo(){return this.name;}
    public double calculateSalary(){return this.baseSalary;}
    public double getBaseSalary(){return this.baseSalary;}
    public String toString(){
        return "Họ tên: " + this.name + "\nLương thực nhận: " + String.format("%.1f",calculateSalary());
    }
}
class PermanentLecturer extends Teacher{
    private double researchAllowance;
    public PermanentLecturer(String name, double baseSalary, double researchAllowance){
        super(name, baseSalary);
        this.researchAllowance = researchAllowance;
    }
    @Override
    public double calculateSalary(){
        return super.getBaseSalary() + this.researchAllowance;
    }
}
class VisitingLecturer extends Teacher{
    private int teachingHours;
    private double paymentPerHour;
    public VisitingLecturer(String name, int teachingHours, double paymentPerHour){
        super(name);
        this.teachingHours = teachingHours;
        this.paymentPerHour = paymentPerHour;
    }
    @Override
    public double calculateSalary(){
        return this.teachingHours * this.paymentPerHour;
    }
}
public class INHERITANCE013{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Map<String, List<Teacher>> map = new LinkedHashMap<>();
        while(sc.hasNextLine()){
            String loaiGiangVien = sc.nextLine();
            String tenGiangVien = sc.nextLine();
            String status = "";
            Teacher t = null;
            if(loaiGiangVien.equals("PermanentLecturer")){
                status = "Permanent";
                double luongCoBan = sc.nextDouble(); sc.nextLine();
                double phuCap = sc.nextDouble(); sc.nextLine();
                t = new PermanentLecturer(tenGiangVien, luongCoBan, phuCap);
            }
            else if(loaiGiangVien.equals("VisitingLecturer")){
                status = "Visiting";
                int teachingHours = sc.nextInt(); sc.nextLine();
                double paymentPerHour = sc.nextDouble(); sc.nextLine();
                t = new VisitingLecturer(tenGiangVien, teachingHours, paymentPerHour);
            }
             // nếu key chưa tồn tại -> tạo list mới
            map.putIfAbsent(status, new ArrayList<>());
            // thêm teacher vào đúng list
            map.get(status).add(t);
        }
        System.out.println("--- Thông tin giảng viên ---");
        for(String status : map.keySet()){
            for(Teacher t : map.get(status)){
                System.out.println("Loại giảng viên: " + status);
                System.out.println(t);
            }
        }
    }
}