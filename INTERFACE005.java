/*
INTERFACE005 - Tổ chức sinh nhật
*/
import java.util.*;
interface Identifiable{
    String getId();
}
interface Birthable{
    String getBirthDate();
}
class Citizen implements Identifiable, Birthable{
    private String name;
    private int age;
    private String id;
    private String birthDate;
    public Citizen(String name, int age, String id, String birthDate){
        this.name = name;this.age = age;
        this.id = id; this.birthDate = birthDate;
    }
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    @Override
    public String getId(){return this.id;} 
    @Override
    public String getBirthDate(){return this.birthDate;}
}
class Pet implements Birthable{
    private String name;
    private String birthDate;
    public Pet(String name, String birthDate){
        this.name = name; this.birthDate = birthDate;
    }
    @Override
    public String getBirthDate(){return this.birthDate;}
    public String getName(){return this.name;}
}
public class INTERFACE005{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            List<String> list = new ArrayList<>();
            while(true){
                String line = sc.nextLine();
                if(line.equals("End")) break;
                String [] part = line.split("\\s+");
                String status = part[0], name = part[1];
                if(status.equals("Citizen")){
                    int age = Integer.parseInt(part[2]);
                    String id = part[3], birthDate = part[4];
                    Citizen c = new Citizen(name, age, id, birthDate);
                    list.add(c.getBirthDate());
                }
                else if(status.equals("Pet")){
                    String birthDate = part[2];
                    Pet p = new Pet(name, birthDate);
                    list.add(p.getBirthDate());
                }
            }
            String year = sc.nextLine();
            for(String s : list){
                if(s.endsWith(year)){
                    System.out.println(s);
                }
            }
        }
    }
}