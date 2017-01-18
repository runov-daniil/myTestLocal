package tempClasses;

import java.io.*;
import java.net.*;

public class getAutorization {
    public static void getConnection(String login, String password) throws UnknownHostException, IOException {
        int serverPort = 4444;
        String address = "192.168.0.103";
        
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
        System.out.println(getLine);
        getCommand(getLine);
    }
    
    public static void getCommand(String message){
        int length = message.length();
        int i = 0;
        String command = "";
        while(true){
            char ch = message.charAt(i);
            if(ch != '|'){
                command = command + ch;
                i++;
            }else{
                break;
            }
        }
        
        message = message.substring(i, length);
        System.out.println(command);
        switch(command) {
            case "authorization":
                length = message.length();
                i = 0;
                String level = "";
                while(true){
                    char ch = message.charAt(i);
                    if(ch != '|'){
                        level = level + ch;
                        i++;
                    }else{
                        break;
                    }
                }
                System.out.println(level);
                message = message.substring(i, length);
                if(level.equals("teacher")){
                    teacherClient.teacherClient.main(true);
                    teacherClient.teacherClient.loginLabel.setText(message);
                }
                break;
        }
    }
}
