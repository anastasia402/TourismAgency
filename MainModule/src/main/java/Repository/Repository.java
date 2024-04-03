package Repository;

import Domain.Identifiable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository<T extends Identifiable<ID>, ID> implements IRepository<T, ID>{
    protected Map<ID, T> elements;

    public Repository() {
        this.elements = new HashMap<>();
    }

    @Override
    public void add(T elem) {
        if (elements.containsKey(elem.getId())){
            throw new RuntimeException("Cannot duplicate elements");
        } else
            elements.put(elem.getId(), elem);
    }

    @Override
    public void delete(T elem) {
        if (elements.containsKey(elem.getId()))
            elements.remove(elem.getId());
        else throw new RuntimeException("Could not find elements with id: "+elem.getId());
    }

    @Override
    public void update(T elem, ID id) {
        if (elements.containsKey(id))
            elements.put(id, elem);
        else throw new RuntimeException("Could not find elements with id: "+id);
    }

    @Override
    public T findById(ID id) {
        if (elements.containsKey(id))
            return elements.get(id);
        else throw new RuntimeException("Could not find elements with id: "+id);
    }

    @Override
    public Collection<T> getAll() {
        return elements.values();
    }
}
