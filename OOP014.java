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
}
public class OOP014 {
    public static double magnitude(Point p, int tx, int ty){
        p.translate(tx, ty);
        double res = Math.sqrt(Math.pow(p.getDx(),2) + Math.pow(p.getDy(), 2));
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point p = new Point(sc.nextInt(), sc.nextInt());
            int tx=-2, ty=3;
            System.out.printf("%.3f\n", magnitude(p,tx,ty));
        }
    }
}
