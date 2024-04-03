package Service;

import Domain.Angajat;
import Domain.Client;

import java.util.Collection;

public interface IServiceAngajat {
    public void add(String nume, String user, String pass);
    public void delete(int id);
    public void update(String nume, String user, String pass, int id);
    public Angajat findById(int id);
    public Collection<Angajat> getAll();
}
