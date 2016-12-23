package testserver;

import frames.editInformation;
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
            classes = classes + number + litera + "|";
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
                closeConnection();
                int newRec = calculationID("user");
                System.out.println(newRec);
                Connection();
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
                Connection();
                st.execute("INSERT INTO students(id_user, fio, id_class)VALUES('"+newRec+"', '"+FIO+"', '"+idClass+"');");
                System.out.println("Личные данные сохранены, обновляю данные на форме!");
                refreshStudents();
                break;
            case "teacher":
                System.out.println("Вижу учителя начинаю сохранение");
                System.out.println("Вычисляю ID");
                newRec = calculationID("user");
                System.out.println(newRec);
                Connection();
                st.execute("INSERT INTO users(id_user, login, password, level)VALUES('" + newRec +"', '"+login+"', '"+password+"', '"+level+"');");
                System.out.println("Аккаунт пользователя создан, обновляю личные данные");
                Connection();
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
    //Обновление классов для формы работы с классами
    public static void refreshClassesForm() throws ClassNotFoundException, SQLException{
        Connection();
        rs = st.executeQuery("SELECT * FROM classes;");
        Vector table = new Vector();
        while(rs.next()){
            Vector element = new Vector();
            int number = rs.getInt("number");
            String litera = rs.getString("litera");
            element.add(number);
            element.add(litera);
            table.add(element);
        }
        Vector header = new Vector();
        header.add("Номер"); header.add("Литера");
        DefaultTableModel dtm = (DefaultTableModel)frames.classesFrame.classesTable.getModel();
        dtm.setDataVector(table, header);
        closeConnection();
    }
    //Добавление нового класса в БД
    public static void createNewClass(int number, String litera) throws ClassNotFoundException, SQLException {
        System.out.println("Вычисляю новый ID");
        int newClass = calculationID("class");
        Connection();
        st.execute("INSERT INTO classes(id_class, number, litera)VALUES('"+newClass+"', '"+number+"', '"+litera+"');");
        closeConnection();
    }
    //Удаление класса из БД
    public static void deleteClass(int number, String litera) throws ClassNotFoundException, SQLException {
        System.out.println("Запущена процедура удаления "+number+" "+litera+" класса!");
        Connection();        
        Statement idClassSt = conn.createStatement();
        ResultSet idClassRs = idClassSt.executeQuery("SELECT id_class FROM classes WHERE number = '"+number+"' AND litera='"+litera+"';");
        int deleteID = 0;
        while(idClassRs.next()){
            System.out.println("Удаляем класс "+idClassRs.getInt("id_class"));
            deleteID = idClassRs.getInt("id_class");
        }
        System.out.println("Перевожу учеников в системый класс!");
        st.execute("UPDATE students SET id_class = '0' WHERE id_class = '"+deleteID+"';");
        st.execute("DELETE FROM classes WHERE id_class = '"+deleteID+"';");
        closeConnection();
        refreshClassesForm();
        refreshStudents();
        frames.classesFrame.numberSelect.setSelectedItem(0);
        sortClass(1);
    }
    //Редактирование данных пользователей
    public static void editFIO(String level) throws ClassNotFoundException, SQLException {
        Connection();
        switch(level){
            case "student":
                String fioStu = editInformation.fioLabel.getText();
                int lengthStu = fioStu.length();
                fioStu = fioStu.substring(4, lengthStu);
                System.out.println(fioStu);
                st.execute("UPDATE students SET fio = '"+frames.editInformation.switchText.getText()+"' WHERE fio = '"+fioStu+"';");
                System.out.println("ФИО пользователя успешно изменено, обновляю данные на форме");
                refreshStudents();
                editInformation.switchText.setText("");
                break;
            case "teacher":
                String fio = editInformation.fioLabel.getText();
                int length = fio.length();
                fio = fio.substring(4, length);
                System.out.println(fio);
                st.execute("UPDATE teachers SET fio = '"+frames.editInformation.switchText.getText()+"' WHERE fio = '"+fio+"';");
                System.out.println("ФИО пользователя успешно изменено, обновляю данные на форме");
                refreshTeachers();
                editInformation.switchText.setText("");
                break;
        }
        closeConnection();
    }
    
    //Вычисление ID
    private static int calculationID(String type) throws ClassNotFoundException, SQLException {
        int newRec = 0;
        Connection();
        
        boolean flag = true;
        while(true){
            if(!(type.equals("class"))){
                rs = st.executeQuery("SELECT * FROM "+type+"s;");
            }else{
                rs = st.executeQuery("SELECT * FROM "+type+"es;");
            }
            while(rs.next()){
                int id = rs.getInt("id_"+type+"");
                System.out.println("ID из базы" + id);
                if(id == newRec){
                    System.out.println("ID существует");
                    flag = true;
                    break;
                }else{
                    System.out.println("ID не существует");
                    flag = false;
                }
            }
            if(flag == true){
                newRec++;
            }else{
                break;
            }
        }
        System.out.println(newRec);
        closeConnection();
        return newRec;
    }
    //Проверка на существование класса при добавлении(отсекаем существующие классы с формы)
    public static void sortClass(int check) throws ClassNotFoundException, SQLException {
        Connection();
        rs = st.executeQuery("SELECT * FROM classes;");
        frames.classesFrame.literaSelect.removeAllItems();
        String symbol = "АБВГД";
        int length = symbol.length();
        while (rs.next()) { 
            int number = rs.getInt("number");
            String litera = rs.getString("litera");
            char literaCh = litera.charAt(0);
            for(int i = 0; i < length; i++){
                char ch = symbol.charAt(i);
                if((ch == literaCh)&(number == check)){
                    symbol = symbol.substring(0, i) + symbol.substring(i + 1);
                    length = length - 1;
                }
            }  
        }
        length = symbol.length();
        for(int i = 0; i < length; i++){
            frames.classesFrame.literaSelect.addItem(String.valueOf(symbol.charAt(i)));
        }
        closeConnection();
    }
    //Установка данных на форму редактирования
    public static void setDataEditInformation(int id) throws ClassNotFoundException, SQLException {
        System.out.println("Устанавливаю первоначальные данные на форму");
        Connection();
        System.out.println("Определяю уровень доступа пользователя");
        String Class = "";
        rs = st.executeQuery("SELECT * FROM users;");
        System.out.println("Определяю данные пользователя");
        while(rs.next()){
            int id_user = rs.getInt("id_user");
            String login = rs.getString("login");
            if(id == id_user){
                System.out.println("Пользователь найден");
                String level = rs.getString("level");
                System.out.println(level);   
                if(rs.getString("level").equals("student")){ //для студента
                    System.out.println("Пользователь студент, определяю ФИО и класс в котором он числится");
                    String FIO = "";
                    int id_class = 0;
                    Statement FIOst = conn.createStatement();
                    ResultSet FIOrs = FIOst.executeQuery("SELECT * FROM students;");
                    while(FIOrs.next()){
                        int FIOid = FIOrs.getInt("id_user");
                        if(id == FIOid){
                            FIO = FIOrs.getString("fio");
                            id_class = FIOrs.getInt("id_class");
                        }
                    }
                    Statement getClassSt = conn.createStatement();
                    ResultSet getClassRs = getClassSt.executeQuery("SELECT * FROM classes;");
                    while(getClassRs.next()){
                        int getId = getClassRs.getInt("id_class");
                        if(getId == id_class){
                            System.out.println("Класс определен");
                            Class = getClassRs.getInt("number") + getClassRs.getString("litera");
                        }
                    }
                    System.out.println("Данные определены, загружаю информацию на форму");
                    frames.editInformation.fioLabel.setText("ФИО " + FIO);
                    if(level.equals("student")){
                        frames.editInformation.fioClassLabel.setText("Ученик " + FIO);
                        frames.editInformation.classLabel.setText("числится в " + Class + " классе.");
                        frames.editInformation.loginLabel.setText("Логин: "+login);
                    }
                }else if(rs.getString("level").equals("teacher")){  //для учителя
                    System.out.println("Пользователь учитель, определяю ФИО");
                    Statement FIOst = conn.createStatement();
                    ResultSet FIOrs = FIOst.executeQuery("SELECT * FROM teachers;");
                    String FIO = "";
                    while(FIOrs.next()){
                        int FIOid = FIOrs.getInt("id_user");
                        if(id == FIOid){
                            FIO = FIOrs.getString("fio");
                        }
                    }
                    System.out.println("Данные определены, загружаю информацию на форму");
                    frames.editInformation.fioLabel.setText("ФИО "+FIO);
                    frames.editInformation.loginLabel.setText("Логин: "+login);
                }
            }else{
                System.out.println("ОШИБКА null, такой пользователь в базе не найден!");                
            }
        }
        closeConnection();
    }
}