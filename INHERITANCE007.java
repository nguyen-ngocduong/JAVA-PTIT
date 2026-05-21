import java.util.*;
abstract class Shape{
    private String name;
    public Shape(String name){
        this.name = name;
    }
    public String getName(){return this.name;}
    public abstract double calculateArea();
    public String toString(){
        return "Shape:" + this.name + "|Area:" + String.format("%.2f",calculateArea());
    }
}
class Rectangle extends Shape{
    private double width;
    private double length;
    public Rectangle(String name, double width, double length){
        super(name);
        this.width = width;
        this.length = length;
    }
    @Override
    public double calculateArea(){
        return this.width * this.length;
    }
}
class Circle extends Shape{
    private double radius;
    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI * this.radius * this.radius;
    }
}
public class INHERITANCE007{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            String name = line[0];
            if(name.equals("Rectangle")){
                Rectangle rec = new Rectangle(name, Double.parseDouble(line[1]), Double.parseDouble(line[2]));
                System.out.println(rec);
            }
            else {
                Circle c = new Circle(name, Double.parseDouble(line[1]));
                System.out.println(c);
            }
        }
    }
}