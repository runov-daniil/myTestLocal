package testserver;

import java.sql.*;

public class dataBase {
    private static Connection conn;
    private static Statement st;
    private static ResultSet rs;
    
    //Подключение к базе
    public static void Connection() throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:data.db");
        st = conn.createStatement();
        conn.setAutoCommit(true);
    }
    //Закрытие базы
    public  static void closeConnection() throws ClassNotFoundException, SQLException {
        conn.close();
    }
    //Авторизация
    public static String autorization(String login, String password) throws ClassNotFoundException, SQLException {
        String authStatus = "0";
        Connection();
        
        closeConnection();
        return authStatus;
    }
    //Обновление данных на главной форме
    public static void refreshMainForm() throws ClassNotFoundException, SQLException {
        
    }
}