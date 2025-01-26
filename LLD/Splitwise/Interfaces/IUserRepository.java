package Splitwise.Interfaces;

import java.util.List;

import Splitwise.Entities.User;

public interface IUserRepository {
    public void saveUser(User user);
    public User getUser(String userid);
    public List<User> getAllUsers();
}
