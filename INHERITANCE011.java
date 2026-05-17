/**
 * Quan ly tai san
 */
import java.util.*;
class Asset{
    private String name, acquisitionDate; // ngay mua
    private double value;
    public Asset(String name, double value){
        this.name = name;
        this.value = value;
    }
    public double getValue(){
        return this.value;
    }
    public double getDepreciation(){
        return 0;
    }
    public String toString(){
        return "Asset Name: " + this.name + 
            "\nAsset Value: " + String.format("%.1f",this.value) + 
            "\nDepreciation: " + String.format("%.1f",getDepreciation()) +
            "\n---------------------------";
    }
}
class FixedAsset extends Asset{ // tai san co dinh
    private double usefulLife;
    public FixedAsset(String name, double value, double usefulLife){
        super(name, value);
        this.usefulLife = usefulLife;
    }
    @Override
    public double getDepreciation(){
        /*
        tính toán sự hao mòn theo công thức:value / usefulLife.
        */
        return super.getValue() / this.usefulLife;
    }
}
class CurrentAsset extends Asset{
    private double liquidationValue;
    public CurrentAsset(String name, double value, double liquidationValue){
        super(name, value);
        this.liquidationValue = liquidationValue;
    }
    @Override
    public double getDepreciation(){
        /*
        tính toán sự hao mòn theo một tỷ lệ cố định (ví dụ 10% mỗi năm), 
        được tính bằng công thứcvalue * 0.1
        */
        return super.getValue() * 0.1;
    }
}
class IntangibleAsset extends Asset{
    private double amortizationPeriod;
    public IntangibleAsset(String name, double value, double amortizationPeriod){
        super(name, value);
        this.amortizationPeriod = amortizationPeriod;
    }
    @Override
    public double getDepreciation(){
        /*
        tính toán sự hao mòn theo cách khấu hao tuyến tính (value / amortizationPeriod).
        */
        return super.getValue() / this.amortizationPeriod;
    }
}
class AssetManager{
    private List<Asset> listAssets;
    public AssetManager(){
        this.listAssets = new ArrayList<>();
    }
    public void addAsset(Asset asset){
        listAssets.add(asset);
    }
    public double getTotalValue(){
        /*
        tính tổng giá trị tài sản
        */
        double sum = 0;
        for(Asset a : listAssets){
            sum += a.getValue();
        }
        return sum;
    }
    public double getTotalDepreciation(){
        /*
        tính tổng sự hao mòn của tất cả tài sản
        */
        double sum = 0;
        for(Asset a : listAssets){
            sum += a.getDepreciation();
        }
        return sum;
    }
    public List<Asset> getList(){
        return this.listAssets;
    }
}
public class INHERITANCE011{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        AssetManager listAssets = new AssetManager();
        while(t-->0){
            String [] line = sc.nextLine().split("\\s+");
            String loaiTaiSan = line[0];
            String tenTaiSan = line[1]; 
            double value = Double.parseDouble(line[2]);
            Asset a = null;
            if(loaiTaiSan.equals("FixedAsset")){
                double usefulLife = Double.parseDouble(line[3]);
                a = new FixedAsset(tenTaiSan, value, usefulLife);
            }
            else if(loaiTaiSan.equals("CurrentAsset")){
                double liquidationValue = Double.parseDouble(line[3]);
                a = new CurrentAsset(tenTaiSan,value, liquidationValue);
            }
            else if(loaiTaiSan.equals("IntangibleAsset")){
                double amortizationPeriod = Double.parseDouble(line[3]);
                a = new IntangibleAsset(tenTaiSan, value, amortizationPeriod);
            }
            listAssets.addAsset(a);
        }
        for(Asset a : listAssets.getList()){
            System.out.println(a);
        }
        System.out.println("Total Value of Assets: " + String.format("%.1f",listAssets.getTotalValue()));
        System.out.println("Total Depreciation of Assets: " + String.format("%.1f",listAssets.getTotalDepreciation()));
    }
}