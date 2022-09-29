package cinema.tickets.booking.api.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    T getById(int id);

    void save(T t);

    void deleteById(int id);

}
