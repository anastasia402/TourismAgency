package Service;

import Domain.Client;

import java.util.Collection;

public interface IServiceClient{
    public void add(String nume, String adresa);
    public void delete(int id);
    public void update(String nume, String adresa, int id);
    public Client findById(int id);
    public Collection<Client> getAll();
}
