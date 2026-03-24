/*
COLLECTION004 - Quản lí nhà kho (3)
 */
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
    public String getProduct(){return this.product;}
    public int getQuantity(){return this.quantity;}
    public int getUnitPrice(){
        return this.unitPrice;
    }
    public int getOriginalQuantity(){return this.originalQuantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}
    public int getToTalPrice(){return this.quantity * this.unitPrice;}
}
class Warehouse_4{
    ArrayList<Item> listItem = new ArrayList<>();
    public void importProduct(Item i){
        listItem.add(i);
    }
    public ArrayList<Item> getItem(){return listItem;}
    public Item getItem(String sanPham){
        for(Item i : listItem){
            if(i.getProduct().equals(sanPham)){
                return i;
            }
        }
        return new Item(sanPham,0,0);
    }
    public void removeProduct(String sanPham, int soLuongGiam){
        for(Item i : listItem){
            if(i.getProduct().equals(sanPham) && i.getQuantity() >= soLuongGiam){
                i.setQuantity(i.getQuantity() - soLuongGiam);
            }
        }
    }
    public void decreaseQuantityInWarehouseByOne(){
        for(Item i : listItem){
            if(i.getQuantity() >= 1){
                i.setQuantity(i.getQuantity() - 1);
            }
        }
    }
    public void takeFromItemToWarehouse(List<Item> itemsToCheck, String sanPham, int soLuongThem){
        for(Item i : itemsToCheck){
            int soLuongDuocThem = 0;
            if(i.getProduct().equals(sanPham)){
                if(i.getQuantity() < soLuongThem) soLuongDuocThem = i.getQuantity();
                else soLuongDuocThem = soLuongThem;
                for(Item j : listItem){
                    if(j.getProduct().equals(sanPham)){
                        j.setQuantity(j.getQuantity() + soLuongDuocThem);
                        break;
                    }
                }
                break;
            }
        }
    }
}
public class COLLECTION004 {
    public static void main(String[] args) {
        Item i1 = new Item("milk", 4, 2);
        Item i2 = new Item("buttermilk",10,2);
        Warehouse_4 w = new Warehouse_4();
        w.importProduct(i1); w.importProduct(i2);
        for(Item i : w.getItem()){
            System.out.println("Product: " + i.getProduct() +" has quantity " + i.getQuantity() +" with price: " + i.getToTalPrice());
        }
        w.removeProduct("milk", 1); w.removeProduct("buttermilk", 3);
        for(Item i : w.getItem()){
            System.out.println("Product: " + i.getProduct() +" has quantity " + i.getQuantity() +" with price: " + i.getToTalPrice());
        }
        w.decreaseQuantityInWarehouseByOne();
        for(Item i : w.getItem()){
            System.out.println("Product: " + i.getProduct() +" has quantity " + i.getQuantity() +" with price: " + i.getToTalPrice());
        }
        ArrayList<Item> itemToCheck = new ArrayList<>();
        for(Item i : w.getItem()){
            itemToCheck.add(new Item(i.getProduct(), i.getQuantity()));
        }
        w.takeFromItemToWarehouse(itemToCheck, "milk", 5);
        w.takeFromItemToWarehouse(itemToCheck,"buttermilk", 1);
        for(Item i : w.getItem()){
            System.out.println("Product: " + i.getProduct() +" has quantity " + i.getQuantity() +" with price: " + i.getToTalPrice());
        }
    }
}
