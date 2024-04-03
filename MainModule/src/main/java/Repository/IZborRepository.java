package Repository;

import Domain.Zbor;

import java.util.Collection;

public interface IZborRepository extends IRepository<Zbor, Integer>{
    public Collection<Zbor> findZbor(String dest, String data, String ora);
}
