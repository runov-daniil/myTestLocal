package serverConsole;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import testserver.dataBase;

public class systemServer {
    public static void main() throws IOException, ClassNotFoundException, SQLException {
        ServerSocket server = new ServerSocket(4444);
        Socket get = null;
        get = server.accept();
        
        InputStream getIn = get.getInputStream();
        DataInputStream in = new DataInputStream(getIn);
        String getLine = null;    
        
        getLine = in.readUTF();
        if(logServer.logText.getText().length() > 0){
            logServer.logText.setText(logServer.logText.getText() + "\n" + getLine);
        }else{
            logServer.logText.setText(getLine);
        }
        checkCommand(getLine);
    }
        
    private static void checkCommand(String getLine) throws ClassNotFoundException, SQLException, IOException{
        int length = getLine.length();
        String cmd = "";
        int i = 0;
        while(true){
            char ch = getLine.charAt(i);
            if(ch != '|'){
                cmd = cmd + ch;
                i++;
            }else{
                break;
            }
        }
        getLine = getLine.substring(i+1, length);
        
        switch(cmd){
            case "authorization":
                length = getLine.length();
                i = 0;
                String login = "";
                while(true){
                    char ch = getLine.charAt(i);
                    if(ch != '|'){
                        login = login + ch;
                        i++;
                    }else{
                        break;
                    }
                }
                String password = getLine.substring(i+1, length);
                String level = dataBase.autorization(login, password);
                sendMessage("authorization|" + level + "|" + login);
                break;
        }
    }
    
    private static void sendMessage(String message) throws UnknownHostException, IOException{
        int serverPort = 6464;
        String address = "127.0.0.1";
        
        InetAddress ipAddr = InetAddress.getByName(address);
        Socket send = new Socket(ipAddr, serverPort);
        
        OutputStream out = send.getOutputStream();
        DataOutputStream sOut = new DataOutputStream(out);
        sOut.writeUTF(message);
        out.flush();
    }
}
