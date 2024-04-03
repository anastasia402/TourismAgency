package UI;

import Domain.Angajat;
import Domain.Bilet;
import Domain.Client;
import Domain.Zbor;
import Service.IServiceAngajat;
import Service.IServiceBilet;
import Service.IServiceClient;
import Service.IServiceZbor;
import com.sun.scenario.effect.impl.prism.PrRenderInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.concurrent.Callable;

public class UI {
    private IServiceAngajat serviceAngajat;
    private IServiceClient serviceClient;
    private IServiceZbor serviceZbor;
    private IServiceBilet serviceBilet;
    private ObservableList<Angajat> angajatObservableList;
    private ObservableList<Client> clientObservableList;
    private ObservableList<Zbor> zborObservableList;
    private ObservableList<Bilet> biletObservableList;

    public UI(IServiceAngajat serviceAngajat, IServiceClient serviceClient, IServiceZbor serviceZbor, IServiceBilet serviceBilet) {
        this.serviceAngajat = serviceAngajat;
        this.serviceClient = serviceClient;
        this.serviceZbor = serviceZbor;
        this.serviceBilet = serviceBilet;
        this.angajatObservableList = FXCollections.observableArrayList(serviceAngajat.getAll());
        this.clientObservableList = FXCollections.observableArrayList(serviceClient.getAll());
        this.zborObservableList = FXCollections.observableArrayList(serviceZbor.getAll());
        this.biletObservableList = FXCollections.observableArrayList(serviceBilet.getAll());
    }

    public void addClient(String nume, String adresa){
        try{
            this.serviceClient.add(nume, adresa);
            clientObservableList.setAll(this.serviceClient.getAll());
        } catch (Exception e){
            throw new RuntimeException("Could not add a new Client");
        }
    }

    public void addAnjajat(String nume, String user, String pass){
        try {
            this.serviceAngajat.add(nume, user, pass);
            angajatObservableList.setAll(this.serviceAngajat.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not add a new Angajat");
        }
    }

    public void addZbor(String dest, String data, String ora, String aerop, int nrLoc){
        try {
            this.serviceZbor.add(dest, data, ora, aerop, nrLoc);
            zborObservableList.setAll(this.serviceZbor.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not add a new Zbor");
        }
    }

    public boolean checkZbor_Client(int idZbor, int idClient) throws Exception {
        try {
            if (serviceClient.findById(idClient) == null) {
                throw new Exception("Cannot find any any Client with id " + idClient);
            } else if (serviceZbor.findById(idZbor) == null) {
                throw new Exception("Cannot find any any Zbor with id " + idZbor);
            }
        } catch (Exception e){
            throw new RuntimeException("Cannot find Client or Zbor in the database");
        }
        return true;
//        return this.serviceClient.getAll().contains(this.serviceClient.findById(idClient))
//                & this.serviceZbor.getAll().contains(this.serviceZbor.findById(idZbor));
    }

    public boolean checkNrLocuriZbor(int idZbor, int nr){
        Zbor zbor = this.serviceZbor.findById(idZbor);
        if (zbor.getNrLocuri() >= nr)
            return true;
        else throw new RuntimeException("No available seats for this flight");
    }

    public void changeNrSeatsZbor(int idZbor, int nr){
        Zbor zbor = this.serviceZbor.findById(idZbor);
        int nrLocuriDisponibile = zbor.getNrLocuri();
        if (nrLocuriDisponibile == nr)
            this.serviceZbor.delete(idZbor);
        else{
            this.serviceZbor.changeNrSeats(nr, idZbor);
            Collection<Zbor> updatedZborList = serviceZbor.getAll(); // Assuming 'serviceZbor' provides access to the data
            zborObservableList.clear(); // Clear the observable list
            zborObservableList.addAll(updatedZborList); // Add all element
        }
    }

    public void cumparaBilet(int IDzbor, int IDclient, String turisti, int nr) throws Exception {

        Client client = this.serviceClient.findById(IDclient);

        if (checkZbor_Client(IDzbor, IDclient) & checkNrLocuriZbor(IDzbor, nr)) {
            try {
                this.serviceBilet.add(IDzbor, IDclient, turisti, nr);
                changeNrSeatsZbor(IDzbor, nr);
                biletObservableList.setAll(this.serviceBilet.getAll());
            } catch (Exception e) {
                throw new RuntimeException("Could not add a new Bilet");
            }
        }

    }

    public void deleleClient(int id){
        try {
            this.serviceClient.delete(id);
            clientObservableList.setAll(this.serviceClient.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not delete a Client");
        }

    }

    public void deleteAngajat(int id){
        try {
            this.serviceAngajat.delete(id);
            angajatObservableList.setAll(this.serviceAngajat.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not delete an Angajat");
        }
    }

    public void deleteZbor(int id){
        try {
            this.serviceZbor.delete(id);
            zborObservableList.setAll(this.serviceZbor.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not delete Zbor");
        }
    }

    public void deleteBilet(int id){
        try {
            this.serviceBilet.delete(id);
            biletObservableList.setAll(this.serviceBilet.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not delete Bilet");
        }
    }

    public void updateClient(String nume, String adresa, int id){
        try {
            this.serviceClient.update(nume, adresa, id);
            clientObservableList.setAll(this.serviceClient.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not update Client");
        }
    }

    public void updateAngajat(String nume, String user, String pass, int id){
        try {
            this.serviceAngajat.update(nume, user, pass, id);
            angajatObservableList.setAll(this.serviceAngajat.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not update Angajat");
        }
    }

    public void updateZbor(String dest, String data, String ora, String aerop, int nr, int id){
        try {
            this.serviceZbor.update(dest, data, ora, aerop, nr, id);
            zborObservableList.setAll(this.serviceZbor.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not update Zbor");
        }
    }

    public void updateBilet(int zbor, int client, String turisti, int nr, int id){
        try{
        this.serviceBilet.update(zbor, client, turisti, nr, id);
        biletObservableList.setAll(this.serviceBilet.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not update Zbor");
        }
    }

    public Client findClient(int id){
        try {
            return this.serviceClient.findById(id);
        }catch (Exception e){
            throw new RuntimeException("Could not find any Client with id "+id);
        }
    }

    public Angajat findAngajat(int id) {
        try {
            return this.serviceAngajat.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Could not find any Angajat with id " + id);
        }
    }

    public Zbor findZbor(int id) {
        try {
            return this.serviceZbor.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Could not find any Zbor` with id " + id);
        }
    }

    public Bilet findBilet(int id) {
        try {
            return this.serviceBilet.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Could not find any Bilet with id " + id);
        }
    }

    public Collection<Client> getAllClient(){
        return this.serviceClient.getAll();
    }

    public Collection<Angajat> getAllAngajat(){
        return this.serviceAngajat.getAll();
    }

    public Collection<Zbor> getAllZbor(){
        return this.serviceZbor.getAll();
    }

    public Collection<Bilet> getAllBilet(){
        return this.serviceBilet.getAll();
    }

    public ObservableList<Client> getClientObservableList() {
        return clientObservableList;
    }

    public ObservableList<Angajat> getAngajatObservableList() {
        return angajatObservableList;
    }

    public ObservableList<Zbor> getZborObservableList() {
        return zborObservableList;
    }

    public ObservableList<Bilet> getBiletObservableList() {
        return biletObservableList;
    }
}
