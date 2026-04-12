import java.util.*;
abstract class Spell {
    private String name;
    private int power;
    public Spell(String name, int power){
        this.name = name;
        this.power = power;
    }
    public String getName(){
        return this.name;
    }
    public abstract String getElement();
    public int getPower(){
        return this.power;
    }
    public void setPower(int power){
        this.power = power;
    }
}
class FireSpell extends Spell{
    public FireSpell(String name, int power){
        super(name, power);
    }
    public String getElement(){
        return "FireSpell";
    }
}
class WaterSpell extends Spell{
    public WaterSpell(String name, int power){
        super(name, power);
    }
    public String getElement(){
        return "WaterSpell";
    }
}
class EarthSpell extends Spell{
    public EarthSpell(String name, int power){
        super(name, power);
    }
    public String getElement(){
        return "EarthSpell";
    }
}
class Student{
    private String name;
    private int competitionPoints;
    private List<Spell> spells;
    public Student(String name){
        this.name = name;
        this.spells = new ArrayList<>();
    }
    public String getStudentName(){
        return this.name;
    }
    public void learnSpell(Spell s){
        spells.add(s);
    }
    public List<Spell> getSpell(){
        return this.spells;
    }
    public int getCompetitionPoints(){
        return this.competitionPoints;
    }
    public void setcompetitonPoints(int competitionPoints){
        this.competitionPoints = competitionPoints;
    }
    public static Comparator<Student> getStudent(){
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                return s2.getCompetitionPoints() - s1.getCompetitionPoints();
            }
        };
    }
    public String toString(){
        return this.name + " " + this.competitionPoints + " " + this.spells.size();
    }
}
public class COLLECTION009 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Student> students = new LinkedHashMap<>();
        while(true){
            String line = sc.nextLine();
            if(line.equals("Trial")) break;
            String [] part = line.split("\\s+");
            String StudentName = part[0], SpellType = part[1], SpellName = part[2];
            int Power = Integer.parseInt(part[3]);
            Student s = students.get(StudentName);
            if(s == null){ // neu trong map chua co student nao
                s = new Student(StudentName);
                students.put(StudentName, s);
            }
            if(SpellType.equals("FireSpell")){
                FireSpell f = new FireSpell(SpellName, Power);
                s.learnSpell(f);
            }
            else if(SpellType.equals("WaterSpell")){
                WaterSpell w = new WaterSpell(SpellName, Power);
                s.learnSpell(w);
            }
            else if(SpellType.equals("EarthSpell")){
                EarthSpell e = new EarthSpell(SpellName, Power);
                s.learnSpell(e);
            }
        }
        while(true){
            String line = sc.nextLine();
            if(line.equals("Graduation")) break;
            String needType = "";
            if(line.equals("Fire")) needType = "FireSpell";
            else if(line.equals("Water")) needType = "WaterSpell";
            else if(line.equals("Earth")) needType = "EarthSpell";
            for(Student s : students.values()){
                boolean hasSpell = false;
                for(Spell x : s.getSpell()){
                    if(x.getElement().equals(needType)) {
                        hasSpell = true;
                        break;
                    }
                }
                if(hasSpell) {
                    s.setcompetitonPoints(s.getCompetitionPoints() + 1);
                }
                else{
                    for(Spell x : s.getSpell()){
                        x.setPower(x.getPower() - 20);
                    }
                }
                s.getSpell().removeIf(x -> x.getPower() <= 0);
            }
        }
        List<Student> listStudent = new ArrayList<>();
        for(Student s : students.values()){
            listStudent.add(s);
        }
        listStudent.sort(Student.getStudent());
        for(Student s : listStudent){
            System.out.println(s);
        }
    }
}
