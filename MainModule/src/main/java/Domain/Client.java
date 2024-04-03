package Domain;

public class Client implements Identifiable<Integer>{
    private String nume;
    private String adresa;
    private int id;
    public Client(int id, String nume, String adresa) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
    }

    public Client(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public Client(){
        this.id = -1;
        this.nume = "";
        this.adresa = "";
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
        return "Client{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", id=" + id +
                '}';
    }
}
