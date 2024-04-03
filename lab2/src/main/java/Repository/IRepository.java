package Repository;

import java.util.Collection;

public interface IRepository<T, Tid> {
    void add(T elem);
    void update(T elem, Tid id);
    T findById(Tid id);
    Collection<T> getAll();

    void delete(T elem);
}
