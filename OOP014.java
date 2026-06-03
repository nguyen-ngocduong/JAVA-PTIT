/*
OOP014 - Vector 2D
 */
import java.util.*;
class Point{
    private int dx,dy;
    public Point(int dx, int dy){
        this.dx = dx; 
        this.dy = dy;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }
    public void translate(int tx, int ty){
        this.dx += tx;
        this.dy += ty;
    }
    public double magnitude(int tx, int ty){
        translate(tx, ty);
        double res = Math.sqrt(Math.pow(getDx(),2) + Math.pow(getDy(), 2));
        return res;
    }
}
public class OOP014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point p = new Point(sc.nextInt(), sc.nextInt());
            int tx=-2, ty=3;
            System.out.println(String.format("%.3f", p.magnitude(tx, ty)));
        }
    }
}
