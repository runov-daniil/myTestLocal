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
    public static void listen() {
        while(serverConsole.statusServer == true){
            listeningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                    logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Слушающий поток запущен");
                    try {
                        ServerSocket serverSocket = new ServerSocket(4444);
                        Socket listen = serverSocket.accept();
                    
                        InputStream in = listen.getInputStream();
                        DataInputStream data = new DataInputStream(in);
                    
                        String message = data.readUTF();                   
                        logServer.logText.setText(logServer.logText.getText() + "\n" + ">>> " + message);
                    
                        listen.close();
                        serverSocket.close();                  
                    } catch (IOException ex) {}
                    listeningThread.stop();
                }
                
            });
        
            while(serverConsole.serverConsole.status = true){
                System.out.println("\n 123");
               listeningThread.start();
            } 
        }
    }
    
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