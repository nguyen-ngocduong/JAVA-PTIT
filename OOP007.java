import java.util.*;
class HanhTinh{
    private double khoiLuong, banKinh;
    public static double g = 6.67300E-11;
    public HanhTinh(double khoiLuong, double banKinh){
        this.khoiLuong = khoiLuong;
        this.banKinh = banKinh;
    }
    public Double trongLucBeMat(){
        return (this.khoiLuong * this.g) / (this.banKinh * this.banKinh);
    }
}
public class OOP007{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tenHanhTinh = sc.nextLine();
        double khoiLuong = sc.nextDouble();
        double banKinh = sc.nextDouble();
        double khoiLuongTrenTraiDat = sc.nextDouble();
        HanhTinh h = new HanhTinh(khoiLuong, banKinh);
        HanhTinh traiDat = new HanhTinh(5.976e+24,6.37814e6);
        String res = String.format("%.2f", khoiLuongTrenTraiDat * (h.trongLucBeMat() / traiDat.trongLucBeMat()));
        System.out.println("Your weight on " + tenHanhTinh + " is " + res);
    }
}