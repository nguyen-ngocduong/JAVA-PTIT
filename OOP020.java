interface A{
    public void m();
    public void n(String msg);
}
class C implements A{
    public void m(){
        System.out.println("Method m() of C");
    }
    @Override
    public void n(String msg){
        System.out.println("OOP23 " + msg);
    }
}
class D extends C{
    boolean d=true;
}
public class OOP020{
    public static void main(String[] args) {
        D db = new D();
        db.m();
        db.n("OOP23");
        System.out.println(db.d);
    }
}