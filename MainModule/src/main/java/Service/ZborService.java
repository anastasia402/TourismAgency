package Service;

import Domain.Zbor;
import Repository.IZborRepository;

import java.util.Collection;

public class ZborService implements IServiceZbor{

    private IZborRepository repo;

    public ZborService(IZborRepository repo) {
        this.repo = repo;
    }

    @Override
    public void add(String dest, String data, String ora, String aerport, int neLoc) {
        Zbor zbor = new Zbor(dest, data, ora, aerport, neLoc);
        repo.add(zbor);
    }

    @Override
    public void delete(int id) {
        Zbor zbor = repo.findById(id);
        repo.delete(zbor);
    }

    @Override
    public void update(String dest, String data, String ora, String aerport, int neLoc, int id) {
        Zbor zbor = new Zbor(dest, data, ora, aerport, neLoc);
        repo.update(zbor, id);
    }

    public void changeNrSeats(int nr, int id){
        for (Zbor zbor: getAll()){
            if (zbor.getId() == id){
                zbor.setNrLocuri(zbor.getNrLocuri() - nr);
            }
        }
    }

    @Override
    public Zbor findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Zbor> getAll() {
        return repo.getAll();
    }
}
