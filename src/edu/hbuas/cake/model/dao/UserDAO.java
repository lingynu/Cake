package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.User;

public interface UserDAO {
    public User login(long userId, String password);
    public User login(long userId);
    public String register(User user);
}
