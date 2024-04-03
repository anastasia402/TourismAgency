package Service;

import Domain.Bilet;
import Domain.Zbor;
import Repository.BiletRepository;
import Repository.IBiletRepository;

import java.sql.Array;
import java.util.Collection;

public class BiletService implements IServiceBilet{
    private IBiletRepository repo;

    public BiletService(IBiletRepository repo) {
        this.repo = repo;
    }

    @Override
    public void add(int zbor, int client, String turisti,int nrLoc) {
        Bilet bilet = new Bilet(zbor, client, turisti, nrLoc);
        repo.add(bilet);
    }

    @Override
    public void delete(int id) {
        Bilet bilet = repo.findById(id);
        repo.delete(bilet);
    }

    @Override
    public void update(int zbor, int client, String turisti, int nrLoc, int id) {
        Bilet bile = new Bilet(zbor, client, turisti, nrLoc);
        repo.update(bile, id);
    }

    @Override
    public Bilet findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Bilet> getAll() {
        return repo.getAll();
    }
}
