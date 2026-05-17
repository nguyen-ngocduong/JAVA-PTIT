//OOP004 - Point class (3 điểm)

import java.util.*;
class Point {
    private int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    public String distanceTo(Point p){
        String res = String.format("%.2f", Math.sqrt((this.x - p.x)*(this.x - p.x) + (this.y - p.y)*(this.y - p.y)));
        return res;
    }
}
public class OOP004 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String [] part = sc.nextLine().split("\\s+");
            Point a = new Point(Integer.parseInt(part[0]), Integer.parseInt(part[1]));
            Point b = new Point(Integer.parseInt(part[2]), Integer.parseInt(part[3]));
            a.move(1,1);
            System.out.println(a.distanceTo(b));
        }
    }
}