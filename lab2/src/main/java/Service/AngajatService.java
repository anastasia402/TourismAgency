package Service;

import Domain.Angajat;
import Domain.Client;
import Repository.AngajatRepository;
import Repository.IAngajatRepsoitory;
import Repository.IRepository;

import java.util.Collection;

public class AngajatService implements IServiceAngajat{
    private IAngajatRepsoitory repo;

    public AngajatService(IAngajatRepsoitory repo) {
        this.repo = repo;
    }

    @Override
    public void add(String nume, String user, String pass) {
        Angajat angajat = new Angajat(nume, user, pass);
        repo.add(angajat);
    }

    @Override
    public void delete(int id) {
        Angajat angajat = repo.findById(id);
        repo.delete(angajat);
    }

    @Override
    public void update(String nume, String user, String pass, int id) {
        Angajat angajat = new Angajat(nume, user, pass);
        repo.update(angajat, id);
    }

    @Override
    public Angajat findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Angajat> getAll() {
        return repo.getAll();
    }
}
