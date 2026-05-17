import java.util.*;
class ghiChu{
    private String id, dateTime, description;
    public ghiChu(int id, String dateTime, String description){
        this.id = String.valueOf(id);
        this.dateTime = dateTime;
        this.description = description;
    }
    public String getId(){return this.id;}
    public String getDateTime(){
        String res = "";
        res += this.dateTime.substring(3,5) + " " + this.dateTime.substring(0,3) + " " + this.dateTime.substring(5,7);
        return res;
    }
    public String getRawDate(){return this.dateTime;}
    public String getDescription(){return this.description;}
    public String toString(){return getDateTime() + " | " + this.description;}
}
class taiKhoan{
    private static int counter = 1; // dem so tk
    private int noteCounter = 1; // dem soghi chu trong 1 tk
    private String id, tenTaiKhoan;
    private List<ghiChu> listGhiChu;
    public taiKhoan(String tenTaiKhoan){
        this.tenTaiKhoan = tenTaiKhoan;
        this.listGhiChu = new ArrayList<>();
        this.id = String.format("%03d", counter++);
    }
    public String getId(){return this.id;}
    public List<ghiChu> getNotes(){return this.listGhiChu;}
    public void addGhiChu(String dateTime, String description){
        ghiChu note = new ghiChu(noteCounter++, dateTime, description);
        listGhiChu.add(note);
    }
    public boolean shareGhiChu(String idGhiChu, String idTaiKhoanNhan, List<taiKhoan> listTaiKhoan){
        ghiChu noteCanShare = null;
        for(ghiChu n : listGhiChu){
            if(idGhiChu.equals(n.getId())){
                noteCanShare = n;
                break;
            }
        }
        if(noteCanShare  == null) return false;
        for(taiKhoan tk : listTaiKhoan){
            if(idTaiKhoanNhan.equals(tk.getId())){
                tk.addGhiChu(noteCanShare.getRawDate(), noteCanShare.getDescription());
                return true;
            }
        }
        return false;
    }
    public String getName(){return this.tenTaiKhoan;}
}
public class OOP005{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<taiKhoan> listTaiKhoan = new ArrayList<>();
        while(t-->0){
            String tenTaiKhoan = sc.nextLine();
            listTaiKhoan.add(new taiKhoan(tenTaiKhoan));
        }
        while(sc.hasNextLine()){
            String [] part = sc.nextLine().split("\\s+");
            String action = part[1], idTaiKhoan = part[0];
            taiKhoan source = null;
            for(taiKhoan tk : listTaiKhoan){
                if(tk.getId().equals(idTaiKhoan)){
                    source = tk;
                    break;
                }
            }
            if(action.equals("Add")){
                String dateTime = part[2];
                String description = "";
                for(int i = 3; i<part.length; i++){
                    description += part[i];
                    if(i < part.length - 1) description += " ";
                }
                source.addGhiChu(dateTime, description);
            }
            else if(action.equals("Share")){
                String idTaiKhoanNhan = part[2];
                String idGhiChu = part[3];
                source.shareGhiChu(idGhiChu, idTaiKhoanNhan, listTaiKhoan);
            }
            else{
                System.out.println("invalid input");
                return;
            }
        }
        for (taiKhoan tk : listTaiKhoan) {
            System.out.println("Account: " + tk.getName());
            for (ghiChu note : tk.getNotes()) {
                System.out.println(note);
            }
        }
    }
}