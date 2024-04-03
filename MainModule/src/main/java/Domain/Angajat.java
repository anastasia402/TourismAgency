package Domain;

public class Angajat implements Identifiable<Integer>{
    private String nume;
    private int id;
    String username;
    String password;

    public Angajat() {
        this.nume = "";
        this.id = -1;
        this.username="";
        this.password = "";
    }

    public Angajat(int id, String nume, String user, String parola) {
        this.id = id;
        this.nume = nume;
        this.username = user;
        this.password = parola;
    }

    public Angajat(String nume, String user, String parola) {
        this.nume = nume;
        this.username = user;
        this.password = parola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    private void login(){

    }

    private void logout(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", id=" + id +
                '}';
    }
}
