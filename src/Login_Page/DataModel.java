package Login_Page;

public class DataModel {
    int id_akun;
    private String Username;
    private String Email;
    private String Section;
    private String Date_Creation;

    public DataModel(int id_akun, String username, String email, String section, String date_Creation) {
        this.id_akun = id_akun;
        Username = username;
        Email = email;
        Section = section;
        Date_Creation = date_Creation;
    }

    public DataModel() {
    }

    public void setId_akun(int id_akun) {
        this.id_akun = id_akun;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSection(String section) {
        Section = section;
    }

    public void setDate_Creation(String date_Creation) {
        Date_Creation = date_Creation;
    }

    public int getId_akun() {
        return id_akun;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getSection() {
        return Section;
    }

    public String getDate_Creation() {
        return Date_Creation;
    }

}
