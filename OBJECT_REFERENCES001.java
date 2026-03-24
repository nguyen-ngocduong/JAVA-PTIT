/*
OBJECT_REFERENCES001 - Làm việc với Lớp SimpleDate và Phương thức equals trong Java
*/
import java.util.*;
class SimpleDate{
    private int day;
    private int month;
    private int year;
    public SimpleDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public boolean equals(SimpleDate other){
        return this.day == other.day && 
            this.month == other.month && 
            this.year == other.year;
    }
}
public class OBJECT_REFERENCES001{
    public static void main(String [] args){
        SimpleDate s1 = new SimpleDate(1,2,2000);
        String text = "heh";
        SimpleDate s2 = new SimpleDate(5,2,2002);
        SimpleDate s3 = new SimpleDate(1,2,2000);
        System.out.println(s1.equals(text));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3)); 
    }
}