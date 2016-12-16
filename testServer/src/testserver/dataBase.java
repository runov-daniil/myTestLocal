package testserver;

import frames.mainFrame;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
        st.close();
        rs.close();
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
    //Обновление данных учителей
    public static void refreshTeachers() throws ClassNotFoundException, SQLException {
        Connection();
        rs = st.executeQuery("SELECT * FROM users;");
        Vector table = new Vector();
        while(rs.next()){
            Vector element = new Vector();
            int id = rs.getInt("id_user");
            String login = rs.getString("login");
            String level = rs.getString("level");
            if(level.equals("teacher")){
                Statement stT = conn.createStatement();
                ResultSet rsT = stT.executeQuery("SELECT fio FROM teachers WHERE id_user = '" + id + "';");
                String fio = rsT.getString("fio");
                element.add(id);element.add(login);
                element.add(fio);
                System.out.println(id + " " + " " + login + " " + fio);
                table.add(element);
                System.out.println("Учитель добавлен на форму");
            }
        }
        System.out.println("Формирую заголовки таблицы");
        Vector header = new Vector();
        header.add("id_user");header.add("Логин");header.add("ФИО");
        DefaultTableModel dtm = (DefaultTableModel)mainFrame.teacherTable.getModel();
        dtm.setDataVector(table, header);
        closeConnection();
        System.out.println("Закончил обновление учителей");
    }
    //Обновление данных учеников
    public static void refreshStudents() throws ClassNotFoundException, SQLException {
        Connection();
        System.out.println("Формирую списки учеников");
        rs = st.executeQuery("SELECT * FROM users;");
        Vector table = new Vector();
        while(rs.next()){
            System.out.println("Перебираю списки");
            Vector element = new Vector();
            int id = rs.getInt("id_user");
            String login = rs.getString("login");
            String level = rs.getString("level");
            if(level.equals("student")){
                System.out.println("Нашел ученика");
                Statement stT = conn.createStatement();
                ResultSet rsT = stT.executeQuery("SELECT fio FROM students WHERE id_user = '" + id + "';");
                System.out.println("Нашел ФИО ученика");
                String fio = rsT.getString("fio");
                System.out.println("Сохранил фио");
                Statement idClassSt = conn.createStatement();
                ResultSet idClassRs = idClassSt.executeQuery("SELECT id_class FROM students WHERE id_user = '" + id + "';");
                int Class = idClassRs.getInt("id_class");
                System.out.println("Нашел ID класса");
                Statement stNum = conn.createStatement();
                ResultSet numClass = stNum.executeQuery("SELECT number FROM classes WHERE id_class = '" + Class + "';");
                System.out.println("Определяю номер класса");
                Statement stLit = conn.createStatement();
                System.out.println("создаю новую стату");
                ResultSet litera = stLit.executeQuery("SELECT litera FROM classes WHERE id_class = '" + Class + "';");
                System.out.println("Определяю литеру");
                String number = numClass.getString("number");
                String thisLitera = litera.getString("litera");
                number = number + thisLitera;
                element.add(id);element.add(login);element.add(number);
                element.add(fio);
                System.out.println(id + " " + " " + login + " " + number + " " + fio);
                table.add(element);
            }
        }
        Vector header = new Vector();
        header.add("id_user");header.add("Логин");header.add("Класс");header.add("ФИО");
        DefaultTableModel dtm = (DefaultTableModel)mainFrame.studentsTable.getModel();
        dtm.setDataVector(table, header);
        closeConnection();
    }
}