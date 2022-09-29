package cinema.tickets.booking.api.service;

import java.util.List;

public interface ServiceInterface<T> {

    List<T> getAll();

    T getById(int id);

    void save(T t);

    void deleteById(int id);

}
