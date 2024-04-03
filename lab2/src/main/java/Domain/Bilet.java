package Domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bilet implements Identifiable<Integer>{
    private int zbor;
    private int client;
    private String listaTuristi;
    private int nrLocuri;
    private int id;
    public Bilet(int id, int zbor, int client, String turisti, int nrLocuri) {
        this.id = id;
        this.zbor = zbor;
        this.client = client;
        this.listaTuristi = turisti;
        this.nrLocuri = nrLocuri;
    }

    public Bilet(int zbor, int client, String turisti, int nrLocuri) {
        this.zbor = zbor;
        this.client = client;
        this.listaTuristi = turisti;
        this.nrLocuri = nrLocuri;
    }

    public Bilet() {
        this.id = -1;
        this.zbor = -1;
        this.client = -1;
        this.listaTuristi = "";
        this.nrLocuri = 0;
    }

    public int getZbor() {
        return zbor;
    }

    public void setZbor(int zbor) {
        this.zbor = zbor;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getListaTuristi() {
        return listaTuristi;
    }

    public void setListaTuristi(String listaTuristi) {
        this.listaTuristi = listaTuristi;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
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
