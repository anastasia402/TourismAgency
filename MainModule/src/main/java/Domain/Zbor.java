package Domain;

public class Zbor implements Identifiable<Integer>{
    private String destinatie;
    private String data;
    private String ora;
    private String aeroport;
    private int nrLocuri;
    private int id;
    public Zbor(int id, String dest, String data, String ora, String aeroport, int nrLocuri) {
        this.id = id;
        this.destinatie = dest;
        this.data = data;
        this.ora = ora;
        this.aeroport = aeroport;
        this.nrLocuri = nrLocuri;
    }

    public Zbor(String dest, String data, String ora, String aeroport, int nrLocuri) {
        this.destinatie = dest;
        this.data = data;
        this.ora = ora;
        this.aeroport = aeroport;
        this.nrLocuri = nrLocuri;
    }

    public Zbor(){
        this.id = -1;
        this.destinatie = "";
        this.data = "";
        this.ora = "";
        this.aeroport = "";
        this.nrLocuri = -1;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getAeroport() {
        return aeroport;
    }

    public void setAeroport(String aeroport) {
        this.aeroport = aeroport;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Zbor{" +
                "destinatie='" + destinatie + '\'' +
                ", data='" + data + '\'' +
                ", ora='" + ora + '\'' +
                ", aeroport='" + aeroport + '\'' +
                ", nrLocuri=" + nrLocuri +
                ", id=" + id +
                '}';
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
