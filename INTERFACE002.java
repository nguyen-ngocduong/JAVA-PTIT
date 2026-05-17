//INTERFACE002 - Organism

import java.util.*;
interface Movable{
    void move(int dx, int dy);
}
class Organism implements Movable{
    private int x,y;
    public Organism(int x, int y){
        this.x = x; this.y = y;
    }
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    public String toString(){
        return "x:" + this.x + ";" + "y:" + this.y;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
}
class Herd{
    private List<Organism> list;
    public Herd(){
        this.list = new ArrayList<>();
    }
    public void addToHerd(Organism organism){
        list.add(organism);
    }
    public void move(int dx,int dy){
        for(Organism o : list){
            o.setX(o.getX() + dx);
            o.setY(o.getY() + dy);
        }
    }
    public List<Organism> getList(){
        return this.list;
    }
}
public class INTERFACE002{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        Herd listOrganism = new Herd();
        while(t-->0){
            String[] part = sc.nextLine().split("\\s+");
            Organism organism = new Organism(Integer.parseInt(part[0]), Integer.parseInt(part[1]));
            organism.move(1,1);
            listOrganism.addToHerd(organism);
        }
        for(Organism o : listOrganism.getList()){
            System.out.println(o);
        }
    }
}