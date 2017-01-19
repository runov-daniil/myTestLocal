package tempClasses;

import frames.loginFrame;
import java.io.*;
import java.net.*;

public class getAutorization {
    public static void getConnection(String login, String password) throws UnknownHostException, IOException {
        int serverPort = 4444;
        String address = "192.168.0.109";
        
        InetAddress ipAddr = InetAddress.getByName(address);
        Socket send = new Socket(ipAddr, serverPort);
        
        OutputStream out = send.getOutputStream();
        DataOutputStream sOut = new DataOutputStream(out);
        sOut.writeUTF("authorization*"+login+"|"+password+"*"+send.getLocalAddress());
        out.flush();
        pendingMessage();
    }
    
    public static void pendingMessage() throws IOException{
        ServerSocket server = new ServerSocket(6464);
        Socket get = null;
        get = server.accept();
        
        InputStream getIn = get.getInputStream();
        DataInputStream in = new DataInputStream(getIn);
        String getLine = null;    
        
        getLine = in.readUTF();
        
        switch(getLine){
            case "teacher":
                teacherClient.teacherClient.main(true);
                teacherClient.teacherClient.loginLabel.setText(loginFrame.loginText.getText());
                loginFrame.main(false);
                break;
        }
        get.close();
        server.close();
    }
}
