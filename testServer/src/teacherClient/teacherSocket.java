package teacherClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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
    
    public static void get() throws IOException{
        ServerSocket serverSocket = new ServerSocket(4444);
        Socket listen = serverSocket.accept();
        
        InputStream in = listen.getInputStream();
        DataInputStream data = new DataInputStream(in);
                    
        String message = data.readUTF();                   
        logServer.logText.setText(logServer.logText.getText() + "\n" + ">>> " + message);
                                        
        listen.close();
        serverSocket.close();
    }
}
