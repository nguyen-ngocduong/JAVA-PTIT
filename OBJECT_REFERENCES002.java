//OBJECT_REFERENCES002 - Song comparison
import java.util.*;
class Song{
    private String name;
    private String author;
    private int duration;
    public Song(String name, String author, int duration){
        this.name = name;
        this.author = author;
        this.duration = duration; 
    }
    public boolean equals(Song other){
        return this.name.equals(other.name) && 
            this.author.equals(other.author) && 
            this.duration == other.duration;
    }
}
public class OBJECT_REFERENCES002{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String s1 = sc.nextLine();
            String [] parts1 = s1.split("\\s+");
            String s2 = sc.nextLine();
            String [] parts2 = s2.split("\\s+");
            Song song1 = new Song(parts1[0], parts1[1], Integer.parseInt(parts1[2]));
            Song song2 = new Song(parts2[0], parts2[1], Integer.parseInt(parts2[2]));
            System.out.println(s1.equals(s2));
        }
    }
}