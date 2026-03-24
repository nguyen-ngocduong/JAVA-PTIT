// Tạo Interface TacoBox
interface TacoBox{
    int tacoRemaining();
    void eat();
}
// Tạo lớp TripleTacoBox
class tripleTacoBox implements TacoBox{
    private int tacos;
    public tripleTacoBox(){
        this.tacos = 3;
    }
    @Override
    //Phương thứctacoRemaining(): Trả về số lượng taco còn lại.
    public int tacoRemaining(){
        return this.tacos;
    }
    @Override
    //Phương thứceat(): Giảm số taco đi 1. Nếu số taco còn lại là 0 thì không thể giảm thêm.
    public void eat(){
        this.tacos--;
    }
}
class customTacoBox implements TacoBox{
    private int tacos;
    public customTacoBox(int tacos){
        this.tacos = tacos;
    }
    @Override
    //Phương thứctacoRemaining(): Trả về số lượng taco còn lại.
    public int tacoRemaining(){
        return this.tacos;
    }
    @Override
    //Phương thứceat(): Giảm số taco đi 1. Nếu số taco còn lại là 0 thì không thể giảm thêm.
    public void eat(){
        this.tacos--;
    }
}
public class INTERFACE003{
    public static void main(String [] args){
        TacoBox box1 = new tripleTacoBox();
        TacoBox box2 = new customTacoBox(8);
        box1.eat(); box1.eat();
        box2.eat();
        System.out.println("Triple taco boxes left: " + box1.tacoRemaining());
        System.out.println("Custom taco boxes left: " + box2.tacoRemaining());
    }
}