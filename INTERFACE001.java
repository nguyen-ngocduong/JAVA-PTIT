import java.util.*;

interface Packable {
    double weight();
}
class Book implements Packable{
    private String author, name;
    private double weight;
    public Book(String author, String name, double weight){
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
    @Override
    public double weight(){
        return this.weight;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.author + ": " + this.name;
    }
}
class CD implements Packable{
    private String artist, name;
    private int publicationYear;
    public CD(String artist, String name, int publicationYear){
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }
    public double weight(){
        return 0.1;
    }
    public String getArtist(){
        return this.artist;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.artist + ": " + this.name + " (" + this.publicationYear + ")";
    }
}
public class INTERFACE001{
    public static void main(String [] args){
        Book b1 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 2);
        Book b2 = new Book("Robert Martin", "Clean Code", 1);
        Book b3 = new Book("Kent Beck", "Test Driven Development", 0.5);
        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);
        System.out.println(b1); System.out.println(b2); System.out.println(b3);
        System.out.println(cd1); System.out.println(cd2); System.out.println(cd3);
    }
}