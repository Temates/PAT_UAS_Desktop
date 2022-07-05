package Login_Page;

public class datamode_attend {
    private int id_akun;
    private String Date;
    private String Time;


    public datamode_attend(String date, String time) {
        Date = date;
        Time = time;
    }

    public int getId_akun() {
        return id_akun;
    }

    public void setId_akun(int id_akun) {
        this.id_akun = id_akun;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time_attend) {
        Time = time_attend;
    }

    public datamode_attend() {
    }
}
