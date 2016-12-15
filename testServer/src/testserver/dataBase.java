package testserver;

import java.sql.*;

public class dataBase {
    private static Connection conn;
    private static Statement statmt;
    private static ResultSet ResSet;
    
    //Подключение к базе
    public static void Connection() throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:data.db");
        ResSet = statmt.executeQuery("SELECT * FROM users");
        while (ResSet.next()) {
            System.out.println(ResSet.getString("login"));
        }
    }
}
