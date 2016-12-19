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
                table.add(element);
            }
        }
        Vector header = new Vector();
        header.add("id_user");header.add("Логин");header.add("ФИО");
        DefaultTableModel dtm = (DefaultTableModel)mainFrame.teacherTable.getModel();
        dtm.setDataVector(table, header);
        closeConnection();
    }
    //Обновление данных учеников
    public static void refreshStudents() throws ClassNotFoundException, SQLException {
        Connection();
        rs = st.executeQuery("SELECT * FROM users;");
        Vector table = new Vector();
        while(rs.next()){
            Vector element = new Vector();
            int id = rs.getInt("id_user");
            String login = rs.getString("login");
            String level = rs.getString("level");
            if(level.equals("student")){
                Statement stT = conn.createStatement();
                ResultSet rsT = stT.executeQuery("SELECT fio FROM students WHERE id_user = '" + id + "';");
                String fio = rsT.getString("fio");
                Statement idClassSt = conn.createStatement();
                ResultSet idClassRs = idClassSt.executeQuery("SELECT id_class FROM students WHERE id_user = '" + id + "';");
                int Class = idClassRs.getInt("id_class");
                Statement stNum = conn.createStatement();
                ResultSet numClass = stNum.executeQuery("SELECT number FROM classes WHERE id_class = '" + Class + "';");
                Statement stLit = conn.createStatement();
                ResultSet litera = stLit.executeQuery("SELECT litera FROM classes WHERE id_class = '" + Class + "';");
                String number = numClass.getString("number");
                String thisLitera = litera.getString("litera");
                number = number + thisLitera;
                element.add(id);element.add(login);element.add(number);
                element.add(fio);
                table.add(element);
            }
        }
        Vector header = new Vector();
        header.add("id_user");header.add("Логин");header.add("Класс");header.add("ФИО");
        DefaultTableModel dtm = (DefaultTableModel)mainFrame.studentsTable.getModel();
        dtm.setDataVector(table, header);
        closeConnection();
    }
    //Обновление классов
    public static String refreshClasses() throws ClassNotFoundException, SQLException {
        String classes = "";
        Connection();
        rs = st.executeQuery("SELECT * FROM classes;");
        while(rs.next()){
            String number = rs.getString("number");
            String litera = rs.getString("litera");
            classes = number + litera + "|";
        }
        closeConnection();
        return classes;
    }
    //Добавление пользователей в базу данных, создание нового пользователя
    public static void createNewUser(String level, String FIO, String login, String password, String Class)throws ClassNotFoundException, SQLException {
        Connection();
        switch (level){
            case "student":
                System.out.println("Вижу студента начинаю сохранение");
                System.out.println("Вычисляю ID");
                rs = st.executeQuery("SELECT * FROM users;");
                int newRec = 0;
                while (rs.next()) {                    
                    if(newRec == rs.getInt("id_user")){
                        newRec++;
                    }else{
                        break;
                    }
                }
                st.execute("INSERT INTO users(id_user, login, password, level)VALUES('" + newRec +"', '"+login+"', '"+password+"', '"+level+"');");
                System.out.println("Аккаунт создан, сохраняю личные данные!");
                System.out.println("Вычисляю ID класса");
                int length = Class.length();
                String litera = String.valueOf(Class.charAt(length - 1));
                String number = Class.substring(0, length - 1);
                Statement idClassSt = conn.createStatement();
                ResultSet idClassRs = idClassSt.executeQuery("SELECT * FROM classes;");
                int idClass = 0;
                while (idClassRs.next()) {                    
                    String currentNumber = idClassRs.getString("number");
                    String currentLitera = idClassRs.getString("litera");
                    if(currentLitera.equals(litera) & (currentNumber.equals(number))){
                        idClass = idClassRs.getInt("id_class");
                    }
                }
                st.execute("INSERT INTO students(id_user, fio, id_class)VALUES('"+newRec+"', '"+FIO+"', '"+idClass+"');");
                System.out.println("Личные данные сохранены, обновляю данные на форме!");
                refreshStudents();
                break;
            case "teacher":
                System.out.println("Вижу учителя начинаю сохранение");
                System.out.println("Вычисляю ID");
                rs = st.executeQuery("SELECT * FROM users;");
                newRec = 0;
                while (rs.next()) {                    
                    if(newRec == rs.getInt("id_user")){
                        newRec++;
                    }else{
                        break;
                    }
                }
                st.execute("INSERT INTO users(id_user, login, password, level)VALUES('" + newRec +"', '"+login+"', '"+password+"', '"+level+"');");
                System.out.println("Аккаунт пользователя создан, обновляю личные данные");
                st.execute("INSERT INTO teachers(id_user, fio)VALUES('"+newRec+"', '"+FIO+"');");
                System.out.println("Личные данные учителя сохранены, обновляю данные на форме");
                refreshTeachers();
                break;
        }
        closeConnection();
    }
    //Удаление пользователей из базы
    public static void deleteUser(int id, String level) throws ClassNotFoundException, SQLException {
        Connection();
        switch(level){
            case "student":
                System.out.println("Вижу студента c id "+id);
                System.out.println("Удаляю личные данные");
                st.execute("DELETE FROM students WHERE id_user = '"+id+"';");
                System.out.println("Данные удалены, удаляю аккаунт");
                st.execute("DELETE FROM users WHERE id_user = "+id+";");
                System.out.println("Пользователь удален из системы! Обновляю данные на форме");
                refreshStudents();
                break;
            case "teacher":
                System.out.println("Вижу учителя, начинаю удаление");
                System.out.println("Удаляю личные данные");
                st.execute("DELETE FROM teachers WHERE id_user = '"+id+"';");
                System.out.println("Данные удалены, удаляю аккаунт");
                st.execute("DELETE FROM users WHERE id_user = '"+id+"';");
                System.out.println("Пользователь удален из системы! Обновляю данные на форме");
                refreshTeachers();
                break;
        }
        closeConnection();
    }
}