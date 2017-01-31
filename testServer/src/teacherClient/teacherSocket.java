package teacherClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import serverConsole.logServer;

public class teacherSocket {
    //Отпрпавка запроса на сервер
    public static void send(String cmd, String data) throws UnknownHostException, IOException{
        int serverPort = 4444;
        String serverIP = "127.0.0.1";
        
        InetAddress IP = InetAddress.getByName(serverIP);
        Socket send = new Socket(IP, serverPort);
        ObjectOutputStream out = new ObjectOutputStream(send.getOutputStream());
        
        Vector dataToSend = new Vector();
        dataToSend.add(cmd);
        dataToSend.add(data);
        dataToSend.add(send.getInetAddress().toString());
        
        out.writeObject(dataToSend);
        out.flush();
        
        out.close();
        send.close();
    }
    //Получение вектора с сервера
    public static Object getVector() throws IOException, ClassNotFoundException {
        ServerSocket client = new ServerSocket(7474);
        Socket getVector = client.accept();
        
        ObjectInputStream in = new ObjectInputStream(getVector.getInputStream());
        Object ob = new Object();
        
        ob = in.readObject();
        
        getVector.close();
        client.close();
        return ob;
    }
}