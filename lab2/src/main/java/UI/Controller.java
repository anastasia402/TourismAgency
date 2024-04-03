package UI;

import Domain.Bilet;
import Domain.Client;
import Domain.Zbor;
import Service.IServiceAngajat;
import Service.IServiceBilet;
import Service.IServiceClient;
import Service.IServiceZbor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collection;

public class Controller {
    private IServiceAngajat serviceAngajat;
    private IServiceClient serviceClient;
    private IServiceZbor serviceZbor;
    private IServiceBilet serviceBilet;

    ObservableList<Bilet> biletObservableList;
    ObservableList<Zbor> zborObservableList;

    public Controller(IServiceAngajat serviceAngajat, IServiceClient serviceClient, IServiceZbor serviceZbor, IServiceBilet serviceBilet) {
        this.serviceAngajat = serviceAngajat;
        this.serviceClient = serviceClient;
        this.serviceZbor = serviceZbor;
        this.serviceBilet = serviceBilet;
        this.biletObservableList = FXCollections.observableArrayList();
        this.biletObservableList.setAll(serviceBilet.getAll());
        this.zborObservableList = FXCollections.observableArrayList();
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
        int nrRamase = nrLocuriDisponibile - nr;
        if (nrLocuriDisponibile == nr)
            this.serviceZbor.delete(idZbor);
        else{
            this.serviceZbor.update(zbor.getDestinatie(), zbor.getData(), zbor.getOra(), zbor.getAeroport(), nrRamase, idZbor);
        }
    }

    public void cumparaBilet(int IDzbor, int IDclient, String turisti, int nr) throws Exception {

        Client client = this.serviceClient.findById(IDclient);

        if (checkZbor_Client(IDzbor, IDclient) & checkNrLocuriZbor(IDzbor, nr)) {
            try {
                this.serviceBilet.add(IDzbor, IDclient, turisti, nr);
                biletObservableList.setAll(serviceBilet.getAll());
                changeNrSeatsZbor(IDzbor, nr);
            } catch (Exception e) {
                throw new RuntimeException("Could not add a new Bilet");
            }
        }

    }

    public void deleteBilet(int id){
        try {
            this.serviceBilet.delete(id);
            biletObservableList.setAll(serviceBilet.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not delete Bilet");
        }
    }

    public void updateBilet(int zbor, int client, String turisti, int nr, int id){
        try{
            this.serviceBilet.update(zbor, client, turisti, nr, id);
            biletObservableList.setAll(serviceBilet.getAll());
        }catch (Exception e){
            throw new RuntimeException("Could not update Zbor");
        }
    }

    public Collection<Bilet> getAllBilet(){
        return this.serviceBilet.getAll();
    }

    public ObservableList<Bilet> getBiletObservableList() {
        return biletObservableList;
    }

    public ObservableList<Zbor> findZboruri(String dest, String date){
        for (Zbor zbor:this.serviceZbor.getAll()){
            if (zbor.getDestinatie().equals(dest) & zbor.getData().equals(date)){
                zborObservableList.add(zbor);
            }
        }
        if (zborObservableList.isEmpty())
            throw new RuntimeException("Could not find flights to this destination or date!");
        else return zborObservableList;
    }
}
