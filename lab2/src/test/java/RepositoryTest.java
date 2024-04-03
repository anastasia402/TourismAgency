import Domain.Identifiable;
import Domain.Zbor;
import Repository.Repository;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    @Test
    public void testAddDelete(){
        Zbor zbor = new Zbor(2, "Chisinau", "12-03-2024", "13:00", "OTP", 23);
        Zbor zbor1 = new Zbor();
        zbor1.setId(1);
        zbor1.setData("12-04-2024");
        zbor1.setOra("12:00");
        zbor1.setAeroport("OTP");
        zbor1.setDestinatie("Milano");
        zbor1.setNrLocuri(40);

        Repository<Identifiable<Integer>, Integer> repository = new Repository<Identifiable<Integer>, Integer>();
        repository.add(zbor);
        repository.add(zbor1);
        assert repository.getAll().size()==2;
    }

    @Test
    public void testFindUpdate(){
        Zbor zbor = new Zbor(2, "Chisinau", "12-03-2024", "13:00", "OTP", 23);
        Zbor zbor1 = new Zbor();
        zbor1.setId(1);
        zbor1.setData("12-04-2024");
        zbor1.setOra("12:00");
        zbor1.setAeroport("OTP");
        zbor1.setDestinatie("Milano");
        zbor1.setNrLocuri(40);
        Zbor zbor2 = new Zbor(3, "Cluj", "12-03-2024", "13:00", "OTP", 50);

        Repository<Identifiable<Integer>, Integer> repository = new Repository<Identifiable<Integer>, Integer>();
        repository.add(zbor);
        repository.add(zbor1);
        assert repository.findById(2).equals(zbor);

        repository.update(zbor2, 2);
        assert repository.getAll().size()==2;
        assert repository.getAll().contains(zbor2);
    }
}
