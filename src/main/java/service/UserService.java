package service;

import dao.UserDao;
import model.User;

public class UserService {
   /* private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserService(){
        this.userRepository = new UserRepository();
    }*/
    private final UserDao userDao;

    public UserService(UserDao dao){
        this.userDao = dao;
    }
    public UserService(){
        this.userDao = new UserDao();
    }
    public void addUser(String login, String email, String password) {
        if (login != null && login != "" && email != null && email != "" && password != null && password != "") {
            User user = new User(login, email, password);
            if (userDao.save(user)) return;
        }
        throw new IllegalArgumentException();
    }

    public boolean validUser(String login, String password) {
        User user = userDao.getUser(login);
        return user != null && user.getPassword().equals(password);
    }
}
