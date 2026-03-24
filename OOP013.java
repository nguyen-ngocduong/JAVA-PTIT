/*
OOP013 - Quản lí sách
 */
import java.util.*;
class Book {
    private String bookId;
    private String title;
    private String author;
    //constructor
    public Book(String bookId, String title, String author){
        this.author = author;
        this.bookId = bookId;
        this.title = title;
    }
    public String toString(){
        return "Sách: "+this.title+" (Mã: " + this.bookId+")" +" - " + this.author;
    }
}
class Borrow{
    private String borrowId;
    private Book book;
    private String borrower;
    private int days;
    public Borrow(String borrowId, Book book, String borrower, int days){
        this.borrowId = borrowId;
        this.book = book;
        this.borrower = borrower;
        this.days = days;
    }
    public double calculateFee(){
        return 5000.0*this.days;
    }
    public void display(){
        System.out.println("--- Phiếu mượn sách ---");
        System.out.println("Mã phiếu: " + this.borrowId);
        System.out.println("Người mượn: " + this.borrower);
        System.out.println(this.book);
        System.out.println("Số ngày mượn: " + this.days);
        //System.out.println("Phí mượn: "+ calculateFee());
        System.out.printf("Phí mượn: %.1f\n", calculateFee());
    }
}
public class OOP013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bookId = sc.nextLine();
        String title = sc.nextLine();
        String author = sc.nextLine();
        String borrowId = sc.nextLine();
        String borrower = sc.nextLine();
        int days = sc.nextInt();
        Book book = new Book(bookId, title, author);
        Borrow b = new Borrow(borrowId, book, borrower, days);
        b.display();
    }
}
