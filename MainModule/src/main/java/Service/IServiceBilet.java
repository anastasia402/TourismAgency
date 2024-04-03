package Service;

import Domain.Bilet;
import Domain.Client;

import java.sql.Array;
import java.util.Collection;

public interface IServiceBilet {
    public void add(int zbor, int client, String turisti, int nrLoc);
    public void delete(int id);
    public void update(int zbor, int client, String turisti, int nrLoc, int id);
    public Bilet findById(int id);
    public Collection<Bilet> getAll();
}
