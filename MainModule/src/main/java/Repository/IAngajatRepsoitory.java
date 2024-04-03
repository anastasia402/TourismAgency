package Repository;

import Domain.Angajat;

public interface IAngajatRepsoitory extends IRepository<Angajat, Integer>{
    public boolean checkAngajat(Angajat angajat);
}
