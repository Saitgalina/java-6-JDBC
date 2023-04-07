package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/java_6";
    private static String username = "root";
    private static String password = "root";
    public static Connection getConnection(){
        if(connection != null)
            return connection;
        else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");               //Проверяем наличие JDBC драйвера для работы с БД
                connection = DriverManager.getConnection(url,username,password);                                      //соединениесБД

            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // обработка ошибки  Class.forName
                System.out.println("JDBC драйвер для СУБД не найден!");
            } catch (SQLException e) {
                e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
                System.out.println("Ошибка SQL !");
            }
            return connection;
        }
    }
}
