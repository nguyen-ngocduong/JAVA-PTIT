/*
OOP012 - Sách và tác giá
 */
import java.util.*;
class Author{
    private String name;
    private String email;
    private char gender;
    //constructor
    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String toString(){
        return "Author[name="+this.name+", email="+this.email+", gender="+this.gender+"],";
    }
}
class Book1{
    private String name;
    private Author author;
    private double price;
    private int qty = 0;
    //constructor
    public Book1(String name, Author author, double price, int qty){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public String toString(){
        return "Book[name="+this.name+", "+this.author+" price="+this.price+", qty="+this.qty+"]";
    }
}
public class OOP012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String o1 = sc.nextLine();String nameBook = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            int qty = Integer.parseInt(sc.nextLine());
            String o2 = sc.nextLine();
            String nameAuthor = sc.nextLine();
            String email = sc.nextLine();
            char gender = sc.nextLine().charAt(0);
            String end = sc.nextLine();
            Author author = new Author(nameAuthor, email, gender);
            Book1 book = new Book1(nameBook, author, price, qty);
            System.out.println(book);
        }
    }
}
