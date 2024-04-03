package Service;

import Domain.Client;
import Repository.IAngajatRepsoitory;
import Repository.IClientRepository;
import Repository.IRepository;

import java.util.Collection;

public class ClientService implements IServiceClient{
    private IClientRepository repo;

    public ClientService(IClientRepository repo) {
        this.repo = repo;
    }


    @Override
    public void add(String nume, String adresa) {
        Client client = new Client(nume, adresa);
        this.repo.add(client);
    }

    @Override
    public void delete(int id) {
        Client client = repo.findById(id);
        repo.delete(client);
    }

    @Override
    public void update(String nume, String adresa, int id) {
        Client clientNou = new Client(nume, adresa);
        repo.update(clientNou, id);
    }

    @Override
    public Client findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Client> getAll() {
        return repo.getAll();
    }
}
