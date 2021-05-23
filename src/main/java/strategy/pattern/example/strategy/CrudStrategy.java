package strategy.pattern.example.strategy;
import strategy.pattern.example.models.User;

import java.util.List;

public interface CrudStrategy<T> {

    List<?> getAll();
    T getOne(String one);
    void add(T t);
    void update(T t, int id);
    void delete(int id);

}
