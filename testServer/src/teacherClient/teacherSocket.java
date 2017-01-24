package teacherClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import serverConsole.logServer;

public class teacherSocket {
    public static void send(String message) throws UnknownHostException, IOException{
        int serverPort = 4444;
        String address = "192.168.0.109";
        
        InetAddress ipAddr = InetAddress.getByName(address);
        Socket send = new Socket(ipAddr, serverPort);
        
        OutputStream out = send.getOutputStream();
        DataOutputStream sOut = new DataOutputStream(out);
        message = message + send.getLocalAddress();
        sOut.writeUTF(message);
        out.flush();
    }
    
    //обновление вопрос пользователя
    public static void getQuestions() throws IOException, ClassNotFoundException {
        send("getQuestions*" + teacherClient.loginLabel.getText() + "*");
        System.out.println("ЗАпрсоил вопросы");
        
        ServerSocket serverSocket = new ServerSocket(7474);
        Socket listen = serverSocket.accept();
        System.out.println("Жду ответа");
        
        ObjectInputStream in = new ObjectInputStream(listen.getInputStream());
        System.out.println("Вопрсы получены");
        
        Object getQ = in.readObject();
        
        Vector questions = new Vector();
        questions.add(getQ);
        Vector header = new Vector();
        header.add("Параллель");
        header.add("Вопрос");
        header.add("Ответ 1");
        header.add("Ответ 2");
        header.add("Ответ 3");
        header.add("Ответ 4");
        header.add("Правильный ответ");
        header.add("Сложность");
        
        DefaultTableModel dtm = (DefaultTableModel)teacherClient.myQuestionTable.getModel();
        dtm.setDataVector(questions, header);
        
        listen.close();
        serverSocket.close();
    }
}
