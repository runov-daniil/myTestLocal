package tempClasses;

import frames.loginFrame;
import teacherClient.*;
import java.io.*;
import java.net.*;
import java.util.Vector;

public class getAutorization {
    public static void getConnection(String login, String password) throws UnknownHostException, IOException {
        int serverPort = 4444;
        String address = "192.168.0.112";
        
        InetAddress ipAddr = InetAddress.getByName(address);
        Socket send = new Socket(ipAddr, serverPort);
        
        Vector data = new Vector();
        data.add("authorization");
        data.add(loginFrame.loginText.getText() + "|" + loginFrame.passwordText.getText());
        data.add(send.getLocalAddress().toString());
        
        ObjectOutputStream out = new ObjectOutputStream(send.getOutputStream());
        out.writeObject(data);
        out.flush();
        
        out.close();
        send.close();
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
                teacherClient.loginLabel.setText(loginFrame.loginText.getText());
                teacherClient.teacherClient.main(true);
                loginFrame.main(false);
                break;
        }
        get.close();
        server.close();
        in.close();
    }
}
