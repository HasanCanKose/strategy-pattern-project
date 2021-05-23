package strategy.pattern.example.services;

import org.springframework.stereotype.Service;
import strategy.pattern.example.models.User;
import strategy.pattern.example.strategy.CrudStrategy;

import java.util.List;

@Service
public class UserService {


    private final CrudStrategy<User> crudStrategy;

    public UserService(CrudStrategy<User> crudStrategy) {
        this.crudStrategy = crudStrategy;
    }

    public List<?> getAllUsers() {
       return crudStrategy.getAll();
    }

    public User getUser(String email) {
        return crudStrategy.getOne(email);
    }

    public void addUser(User user){
        crudStrategy.add(user);
    }

    public void updateUser(User user, int id){
        crudStrategy.update(user, id);
    }

    public void deleteUser(int id) {
        crudStrategy.delete(id);
    }
}
