import java.util.*;
class Item{
    private String name;
    private int weight;
    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    public Item(String name){
        this.name = name;
    }
    public int getWeight(){return this.weight;}
    public String getName(){return this.name;}
}
abstract class Box{
    public abstract void add(Item item);
    public abstract boolean isInBox(Item item);
}
class BoxWithMaxWeight extends Box{
    private List<Item> items;
    private int maxWeight;
    public BoxWithMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }
    public void add(Item i){
        if(i.getWeight() <= this.maxWeight){
            items.add(i);
            this.maxWeight -= i.getWeight();
        }
    }
    public boolean isInBox(Item item){
        for(Item i : items){
            if(i.getName().equals(item.getName())){
                return true;
            }
        }
        return false;
    }
}
public class INHERITANCE002{
    public static void main(String [] args){
        BoxWithMaxWeight bmw = new BoxWithMaxWeight(10);
        Item i1 = new Item("Saludo", 5), i2 = new Item("Pirkka", 5), i3 = new Item("Kopi Luwak", 5);
        bmw.add(i1); bmw.add(i2); bmw.add(i3);
        System.out.println(bmw.isInBox(i1));
        System.out.println(bmw.isInBox(i2));
        System.out.println(bmw.isInBox(i3));
    }
}