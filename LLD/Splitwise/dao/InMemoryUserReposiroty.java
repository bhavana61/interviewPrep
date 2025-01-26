package Splitwise.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.User;
import Splitwise.Interfaces.IUserRepository;

public class InMemoryUserReposiroty implements IUserRepository{
    private Map<String, User> users = new HashMap<>();

    @Override
    public void saveUser(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public User getUser(String userId) {
        return users.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

}
