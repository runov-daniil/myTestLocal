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
        rs = st.executeQuery("SELECT * FROM users;");
        boolean flag = false;
        while(rs.next()){
            String getLogin = rs.getString("login");
            String getPassword = rs.getString("password");
            System.out.println(login + " " + password);
            if((getLogin.equals(login))&&(getPassword.equals(password))){
                flag = true;
                break;
            }
        }
        if(flag == true){
            rs = st.executeQuery("SELECT level FROM users WHERE login = '" + login + "';");
            authStatus = rs.getString("level");
            System.out.println(rs.getString("level"));
        }
        closeConnection();
        return authStatus;
    }
    //Обновление данных на главной форме
    public static void refreshMainForm() throws ClassNotFoundException, SQLException {
        
    }
}