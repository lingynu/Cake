package food.model.dao;

import food.model.javabean.User;

public interface UserDAO {
    public User login(String nickname, String password);
    public User login(String nickname);
    public boolean register(User user);
    public boolean checkUserExists(String nickname);
    public boolean reviseUserMessage(User user);
}
