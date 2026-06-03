import java.util.*;
class Author {
    private String name;
    private String email;
    private char gender;
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName() {return name;}
    public String getEmail() {return email;}
    public char getGender() {return gender;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setGender(char gender) {this.gender = gender;}
    public String toString() {
        return "Author[name=" + name +", email=" + email + ", gender=" + gender + "]";
    }
}
class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public String getName() {return name;}
    public Author getAuthor() {return author;}
    public double getPrice() {return price;}
    public int getQty() {return qty;}
    public void setPrice(double price) {this.price = price;}
    public void setQty(int qty) {this.qty = qty;}
    public String toString() {
        return "Book[name=" + name + ", " + author.toString() + ", price=" + price + ", qty=" + qty + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<String> list = new ArrayList<>();
            while (true) {
                String line = sc.nextLine();
                if (line.equals("End"))break;
                list.add(line);
            }
            String type = list.get(0);
            if (type.equals("Author")) {
                String name = list.get(1);
                String email = list.get(2);
                char gender = list.get(3).charAt(0);
                String bookName = list.get(5);
                double price = Double.parseDouble(list.get(6));
                int qty = Integer.parseInt(list.get(7));
                Author a = new Author(name, email, gender);
                Book book = new Book(bookName, a, price, qty);
                System.out.println(a);
            }
            else if (type.equals("Book")) {
                String bookName = list.get(1);
                double price = Double.parseDouble(list.get(2));
                int qty = Integer.parseInt(list.get(3));
                String authorName = list.get(5);
                String email = list.get(6);
                char gender = list.get(7).charAt(0);
                Author author = new Author(authorName, email, gender);
                Book book = new Book(bookName, author, price, qty);
                System.out.println(book);
            }
        }
    }
}