package dao;

import connection.ConnectionDB;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection;
    public UserDao(){
        this.connection = ConnectionDB.getConnection();
    }

    public User getUser(String login) {
        if(connection != null){
            String sql = "select * from users where login = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, login);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){
                        return new User(resultSet.getString("login"),
                                resultSet.getString("email"),
                                resultSet.getString("password"));
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public List<User> getAll(){
        List<User> users = new ArrayList<User>();
        if(connection!=null){
            String sql = "select * from users";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()){
                        users.add(new User(resultSet.getString("login"),
                                resultSet.getString("email"),
                                resultSet.getString("password")));
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return users;
    }
    public boolean save(User user){
        boolean isSaved = false;
        if(connection!=null){
            String sql = "insert into users (login, email, password) values (?,?,?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1,user.getLogin());
                preparedStatement.setString(2,user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.executeUpdate();
                isSaved =true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return isSaved;
    }
    public boolean update(User user){
        boolean isSaved = false;

        if (connection != null) {
            String sql = "update users set login = ? email = ? password = ? where login = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getLogin());
                preparedStatement.executeUpdate();
                isSaved = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSaved;
    }
    public boolean delete(User user) {
        boolean isSaved = false;

        if (connection != null) {
            String sql = "delete from users where login = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.executeUpdate();
                isSaved = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSaved;
    }
}
