package serverConsole;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class systemServer {
        public static void main() throws IOException {
        ServerSocket server = new ServerSocket(4444);
        Socket get = null;
        get = server.accept();
        
        InputStream getIn = get.getInputStream();
        DataInputStream in = new DataInputStream(getIn);
        String getLine = null;    
        
        getLine = in.readUTF();
        logServer.logText.setText(logServer.logText.getText() + "\n" + getLine);
        
        systemServer.main();
    }
}
