import java.util.*;
class Item{
    private String product;
    private int quantity;
    private int unitPrice;
    private int originalQuantity;
    public Item(String product, int quantity, int unitPrice){
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public Item(String product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }
    public String getProduct(){
        return this.product;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getOriginalPrice(){
        return this.unitPrice;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getTotalPrice(){
        return this.quantity * this.unitPrice;
    }
    public String toString(){
        return "Product: " + this.product + " has quantity " + this.quantity + " with price: " + getTotalPrice();
    }
}
class WareHouse{
    HashMap<String, Item> items = new LinkedHashMap<>();
    public void importProduct(Item i){
        items.put(i.getProduct(), i);
    }
    public Item getItem(String tenSanPham){
        return items.getOrDefault(tenSanPham, new Item(tenSanPham, 0, 0));
    }
    public void removeProduct(String tenSanPham, int soLuong){
        Item i = items.get(tenSanPham);
        if(i != null){
            if(i.getQuantity() >= soLuong){
                i.setQuantity(i.getQuantity() - soLuong);
            }
            else{
                i.setQuantity(0);
            }
        }
    }
    public void decreaseQuantityInWarehouseByOne(){
        for(Item i : items.values()){
            i.setQuantity(i.getQuantity() - 1);
        }
    }
    public void takeFromItemToWarehouse(List<Item> itemsToCheck, String tenSanPham, int soLuong)
    {
        for(Item i : itemsToCheck){
            int soLuongDuocThem = 0;
            if(i.getProduct().equals(tenSanPham)){
               if(soLuong > i.getQuantity()){
                   soLuongDuocThem = i.getQuantity();
               }
               else soLuongDuocThem = soLuong;
               Item j = items.get(tenSanPham);
               j.setQuantity(j.getQuantity() + soLuongDuocThem);
               break;
            }
        }
    }
}
public class COLLECTION004_2 {
    public static void main(String[] args) {
        Item i1 = new Item("milk", 4, 2);
        Item i2 = new Item("buttermilk",10,2);
        WareHouse w = new WareHouse();
        w.importProduct(i1); w.importProduct(i2);
        System.out.println(w.getItem("milk"));
        System.out.println(w.getItem("buttermilk"));
        w.removeProduct("milk", 1); w.removeProduct("buttermilk", 3);
        System.out.println(w.getItem("milk"));
        System.out.println(w.getItem("buttermilk"));
        w.decreaseQuantityInWarehouseByOne();
        System.out.println(w.getItem("milk"));
        System.out.println(w.getItem("buttermilk"));
        List<Item> itemsToCheck = new ArrayList<>();
        itemsToCheck.add(new Item("milk", 2)); itemsToCheck.add(new Item("buttermilk", 6));
        w.takeFromItemToWarehouse(itemsToCheck, "milk", 5);
        w.takeFromItemToWarehouse(itemsToCheck, "buttermilk", 1);
        System.out.println(w.getItem("milk"));
        System.out.println(w.getItem("buttermilk"));
    }
}