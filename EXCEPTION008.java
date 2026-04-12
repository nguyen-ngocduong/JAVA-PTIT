import java.util.Scanner;

class FileNameFormatException extends Exception{
    public FileNameFormatException(String s){
        super(s);
    }
}

class Test{
    public static void open_file(String s){
        try{
            f(s);
        } catch (FileNameFormatException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("Exception");
        }
    }
    public static void f(String s) throws FileNameFormatException{
        if(s.contains(" ")){
            System.out.println("File name format");
        } 
        System.out.println("File opened");
    }
}

public class EXCEPTION008 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Test.open_file(s);
        sc.close();
    }
}
