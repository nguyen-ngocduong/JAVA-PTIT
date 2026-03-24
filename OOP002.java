/*
OOP002 - Bằng sáng chế
 */
import java.util.*;
class Inventor{
    private String name;
    private String field;
    private String nationality;
    //constructor
    public Inventor(String name, String field, String nationality){
        if(!nationality.equals("VN") && !nationality.equals("INT")){
            System.out.println("Invalid nationality. Only 'VN' or 'INT' allowed.");
            System.exit(0);//ket thuc ctrinh
        }
        this.name = name;
        this.field = field;
        this.nationality = nationality;
    }
    public String toString(){
        return "Inventor[name="+this.name + ", field=" + this.field + ", nationality="+this.nationality+"]]";
    }
}
class Patent{
    private String title;
    private int year;
    private Inventor inventor;
    //constructor
    public Patent(String title, int year, Inventor inventor){
        this.title = title;
        this.year=year;
        this.inventor = inventor;
    }
    public String toString(){
        return "Patent[title="+this.title+", year="+this.year+", ";
    }
}
public class OOP002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String field = sc.nextLine();
        String nationality = sc.nextLine();
        String title = sc.nextLine();
        int year = Integer.parseInt(sc.nextLine());
        Inventor i = new Inventor(name, field, nationality);
        Patent p = new Patent(title, year, i);
        System.out.print(p);
        System.out.print(i);
    }
}
