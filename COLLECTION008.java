//COLLECTION008 - Quản lí chuyến thám hiểm không gian
import java.util.*;
class Equipment{
    private String name;
    private int durability; // do ben
    public Equipment(String name, int durability){
        this.name = name; this.durability = durability;
    }
    public String getElement(){return this.name;}
    public int getDurability(){return this.durability;}
    public void setDurability(int durability){this.durability = durability;}
}
class Tool extends Equipment{
    public Tool(String name, int durability){
        super(name, durability);
    }
    public String getElement(){
        return "Tool";
    }
    public void setDurability(int durability){super.setDurability(durability);}
}
class Food extends Equipment{
    public Food(String name, int durability){
        super(name, durability);
    }
    public String getElement(){
        return "Food";
    }
    public void setDurability(int durability){super.setDurability(durability);}
}
class Medicine extends Equipment{
    public Medicine(String name, int durability){
        super(name, durability);
    }
    public String getElement(){
        return "Medicine";
    }
    public void setDurability(int durability){super.setDurability(durability);}
}
class Astronaut{
    private String name;
    private int missionPoints;//diem nhiem vu
    private List<Equipment> bag;
    public Astronaut(String name){
        this.name = name;
        this.bag = new ArrayList<>();
        this.missionPoints = 0;
    }
    public void addEquipment(Equipment e){
        bag.add(e);
    }
    public List<Equipment> getBag(){ return this.bag;}
    public int getMissionPoints(){return this.missionPoints;}
    public void setMissionPoints(int missionPoints){this.missionPoints = missionPoints;}
    public static Comparator<Astronaut> getAstronaut(){
        return new Comparator<Astronaut>(){
            @Override
            public int compare(Astronaut o1, Astronaut o2){
                return o2.getMissionPoints() - o1.getMissionPoints();
            }
        };
    }
    public String toString(){
        return this.name + " " + this.missionPoints + " " + this.bag.size();
    }
}
public class COLLECTION008 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Astronaut> astronauts = new LinkedHashMap<>();
        while(true){
            String line = sc.nextLine();
            if(line.equals("Launch")) break;
            String [] part = line.split("\\s+");
            String AstronautName = part[0], EquipmentType = part[1], EquipmentName = part[2];
            int Durability = Integer.parseInt(part[3]);
            Astronaut a = astronauts.get(AstronautName);
            if(a == null){//
                a = new Astronaut(AstronautName);
                astronauts.put(AstronautName, a);
            }
            if(EquipmentType.equals("Tool")){
                Tool t = new Tool (EquipmentName, Durability);
                a.addEquipment(t);
            }
            else if(EquipmentType.equals("Food")){
                Food f = new Food (EquipmentName, Durability);
                a.addEquipment(f);
            }
            else if(EquipmentType.equals("Medicine")){
                Medicine m = new Medicine(EquipmentType, Durability);
                a.addEquipment(m);
            }
        }
        while(true){
            String line = sc.nextLine();
            if(line.equals("Return")) break;
            String needType = "";
            if(line.equals("Repair")) needType = "Tool";
            else if(line.equals("Nutrition")) needType = "Food";
            else if(line.equals("Heal")) needType = "Medicine";
            for(Astronaut a : astronauts.values()){
                boolean hasEquipment = false;
                for(Equipment e : a.getBag()){
                    if(e.getElement().equals(needType)){
                        hasEquipment = true;
                        break;
                    }
                }
                if(hasEquipment){
                    a.setMissionPoints(a.getMissionPoints() + 1);
                }
                else{
                    for(Equipment e : a.getBag()){
                        e.setDurability(e.getDurability() - 15);
                    }
                }
                a.getBag().removeIf(x -> x.getDurability() <= 0);
            }
        }
        List<Astronaut> list = new ArrayList<>();
        for(Astronaut a : astronauts.values()){
            //System.out.println(a);
            list.add(a);
        }
        list.sort(Astronaut.getAstronaut());
        for(Astronaut a : list){
            System.out.println(a);
        }
    }
}