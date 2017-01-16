package tempClasses;

import java.io.*;
import java.net.*;

public class getAutorization {
    public static void getConnection() throws UnknownHostException, IOException {
        int serverPort = 4444;
        String address = "127.0.0.1";
        
        InetAddress ipAddr = InetAddress.getByName(address);
        Socket send = new Socket(ipAddr, serverPort);
        
        OutputStream out = send.getOutputStream();
        DataOutputStream sOut = new DataOutputStream(out);
        sOut.writeUTF("Тестовое сообщение");
        out.flush();
    }
}
