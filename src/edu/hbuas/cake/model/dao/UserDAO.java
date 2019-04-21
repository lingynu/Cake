package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.User;

public interface UserDAO {
    public User login(int userId, String password);
    public User login(int userId);
    public String register(User user);
}
