package Service;

import Domain.Angajat;
import Domain.Client;
import Domain.Zbor;

import java.util.Collection;

public interface IServiceZbor {
    public void add(String dest, String data, String ora, String aerport, int neLoc);
    public void delete(int id);
    public void update(String dest, String data, String ora, String aerport, int neLoc, int id);
    public Zbor findById(int id);
    public Collection<Zbor> getAll();

    public void changeNrSeats(int nr, int id);
}
