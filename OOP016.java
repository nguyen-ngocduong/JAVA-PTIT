/*
OOP016 - Tiền nong
 */
class Money{
    private int euros;
    private int cent;

    public Money(int euros, int cent) {
        this.euros = euros;
        this.cent = cent;
    }
    public double tongTien(){
        return this.euros + (double)this.cent/100;
    }
    public String toString(){
        String res = this.euros + "." + String.format("%02d", this.cent) + "e";
        return res;
    }
    public Money plus(Money added){
        int total1 = this.euros * 100 + this.cent;
        int total2 = added.euros * 100 + added.cent;
        int res = total1 + total2;
        return new Money(res/100, res%100);
    }
    public boolean lessThan(Money compared){
        return this.tongTien() < compared.tongTien();
    }
    public Money minus(Money minus){
        int total1 = this.euros * 100 + this.cent;
        int total2 = minus.euros * 100 + minus.cent;
        int res = total1 - total2;
        if(res < 0) return new Money(0,0);
        else return new Money(res/100, res%100);
    }
}
public class OOP016 {
    public static void main(String[] args) {
        Money a = new Money(10,8); Money b = new Money(5,5);
        System.out.println(a); System.out.println(b);
        System.out.println(a.plus(b));
        Money u = new Money(10,0); Money y = new Money(3,0); Money w = new Money(5,0);
        System.out.println(u.lessThan(y));
        System.out.println(y.lessThan(w));
        Money m = new Money(10,0); Money n = new Money(3,50);
        System.out.println(m);
        System.out.println(n);
        System.out.println(m.minus(n));
        Money o = m.minus(n);
        System.out.println(o.minus(m));
    }
}
