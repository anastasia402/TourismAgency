import Domain.Angajat;
import Domain.Bilet;
import Domain.Client;
import Domain.Zbor;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Collection;
import java.util.List;


public class DomainTest {

    @Test
    public void testAngajat(){
        Angajat angajat = new Angajat(1, "Ion", "ion2", "434");
        assert angajat.getId().equals(1);
        assert angajat.getNume().equals("Ion");

        Angajat angajat1 = new Angajat();
        angajat1.setId(2);
        angajat1.setNume("Ana");
        assert angajat1.getNume().equals("Ana");
        assert angajat1.getId().equals(2);
    }

    @Test
    public void testZbor(){
        Zbor zbor = new Zbor(2, "Chisinau", "12-03-2024", "13:00", "OTP", 23);
        assert zbor.getId().equals(2);
        assert zbor.getDestinatie().equals("Chisinau");
        assert zbor.getData().equals("12-03-2024");
        assert zbor.getOra().equals("13:00");
        assert zbor.getAeroport().equals("OTP");
        assert zbor.getNrLocuri() == 23;

        Zbor zbor1 = new Zbor();
        zbor1.setId(1);
        zbor1.setData("12-04-2024");
        zbor1.setOra("12:00");
        zbor1.setAeroport("OTP");
        zbor1.setDestinatie("Milano");
        zbor1.setNrLocuri(40);

        assert zbor1.getId().equals(1);
        assert zbor1.getDestinatie().equals("Milano");
        assert zbor1.getData().equals("12-04-2024");
    }

    @Test
    public void testClient(){
        Client client = new Client(1, "Ion", "str. Dunarii 21");
        assert client.getId().equals(1);
        assert client.getNume().equals("Ion");
        assert client.getAdresa().equals("str. Dunarii 21");
    }

//    @Test
//    public void testBilet(){
//        Zbor zbor = new Zbor(2, "Chisinau", "12-03-2024", "13:00", "OTP", 23);
//        Client client = new Client(1, "Ion", "str. Dunarii 21");
//
//        assert bilet.getClient().equals(client);
//        assert bilet.getId().equals(1);
//        assert bilet.getListaTuristi().equals(lista);
//        assert bilet.getZbor().equals(zbor);
//        assert bilet.getNrLocuri()==4;
//    }
}
