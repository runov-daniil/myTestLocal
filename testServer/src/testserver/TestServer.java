package testserver;

import frames.mainFrame;
import java.sql.SQLException;

public class TestServer {

    public static void main(String[] args) {
        frames.loginFrame.main(true);
    }
    
    public static void userDetect(String level, String userName) throws ClassNotFoundException, SQLException {
        System.out.println("Имя пользователя " + userName);
        switch(level){
            case "admin":
                dataBase.refreshStudents();
                dataBase.refreshTeachers();
                dataBase.refreshQuestion();
                mainFrame.loginLabel.setText(level);
                dataBase.newOnline(level);
                mainFrame.main(true);
                break;
            case "teacher":
                dataBase.newOnline(userName);
                teacherClient.teacherClient.main(true);
                teacherClient.teacherClient.loginLabel.setText(userName);
                break;
            case "student":
                
                break;
        }
    }
}