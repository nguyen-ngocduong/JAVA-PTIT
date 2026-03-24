/*
OOP003 - Nhạc sĩ
 */
import java.util.*;
class Musican{
    private String name;
    private String nationality;
    private String style;
    public Musican(String name, String nationality, String style){
        if(!nationality.equals("VN") && !nationality.equals("INT")){
            System.out.println("Invalid nationality. Only 'VN' or 'INT' allowed.");
            System.exit(0);
        }
        this.name = name;
        this.nationality = nationality;
        this.style = style;
    }
    public String toString(){
        return "Musician[name=" + this.name + 
            ", nationality=" + this.nationality + 
            ", style=" + this.style + "]]";
    }
}
class Song{
    private String title;
    private String genre;
    private int year;
    private Musican musican;
    public Song(String title, String genre, int year, Musican musican){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.musican = musican;
    }
    public String toString(){
        return "Song[title=" + this.title + 
            ", genre=" + this.genre +
            ", year=" + this.year + 
            ", " + this.musican;
    }
}
public class OOP003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String nationality = sc.nextLine();
        String style = sc.nextLine();
        String title = sc.nextLine();
        String genre = sc.nextLine();
        int year = Integer.parseInt(sc.nextLine());
        Musican musican = new Musican(name, nationality, style);
        Song song = new Song(title, genre, year, musican);
        System.out.println(song);
    }
}
