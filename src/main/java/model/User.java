package model;

public class User {
    private final String login;
    private final String password;
    private final String email;


    public User(String login,  String email,String pass){
        this.login = login;
        this.password = pass;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
