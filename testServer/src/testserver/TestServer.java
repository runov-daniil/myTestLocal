package testserver;

import frames.mainFrame;
import java.sql.SQLException;

public class TestServer {

    public static void main(String[] args) {
        frames.loginFrame.main(true);
    }
    
    public static void userDetect(String level) throws ClassNotFoundException, SQLException {
        switch(level){
            case "admin":
                dataBase.refreshStudents();
                dataBase.refreshTeachers();
                mainFrame.loginLabel.setText(level);
                mainFrame.main(true);
                break;
            case "teacher":
                
                break;
            case "student":
                
                break;
        }
    }
}