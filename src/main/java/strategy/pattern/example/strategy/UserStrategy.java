package strategy.pattern.example.strategy;

import org.springframework.stereotype.Component;
import strategy.pattern.example.models.User;
import strategy.pattern.example.repositories.UserRepository;

import java.util.List;

@Component
public class UserStrategy implements CrudStrategy<User> {

    private final UserRepository userRepository;

    public UserStrategy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @Override
    public User getOne(String email) {
        List<User> users = getAll();
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user, int id) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }
}
