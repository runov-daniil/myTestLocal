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
import java.util.logging.Level;
import java.util.logging.Logger;
import testserver.dataBase;

public class systemServer {
    private static Thread listeningThread;
    private static Thread answerThread;
    
    public static void answer() {
        answerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Отвечающий поток запущен");
            }
        });
    }
    private static void checkListeningThread(){
        if(!(listeningThread.isAlive())){
            listeningThread.start();
            logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Рестарт слушающего потока");
        }
    }
    
    private static void checkAnswerThread(){
        if(answerThread.isAlive() != true){
            logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Рестарт отвечающего потока");
            answerThread.start();
        }
    }
}