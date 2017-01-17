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
    private static Thread listeningThread;
    private static Thread answerThread;
    public static void main(String status) {
        listeningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                logServer.serverLog.setText(logServer.serverLog.getText() + "Слушающий поток запущен");
                listeningThread.stop();
                checkListeningThread();
            }
        });
        answerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                logServer.serverLog.setText(logServer.serverLog.getText() + "Отвечающий поток запущен");
                answerThread.stop();
                checkAnswerThread();
            }
        });
        
        switch (status){
                case "start":
                    listeningThread.start();
                    answerThread.start();
                    break;
                case "stop":
                    listeningThread.stop();
                    answerThread.stop();
                    break;
        }            
    }
    
    private static void checkListeningThread(){
        boolean check = listeningThread.isAlive();
        if(check != true){
            logServer.serverLog.setText(logServer.serverLog.getText() + "Рестарт слушающего потока");
            listeningThread.start();
        }
    }
    
    private static void checkAnswerThread(){
        if(answerThread.isAlive() != true){
            logServer.serverLog.setText(logServer.serverLog.getText() + "Рестарт отвечающего потока");
            answerThread.start();
        }
    }
}