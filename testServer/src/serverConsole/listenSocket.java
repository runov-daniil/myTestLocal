package serverConsole;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import static serverConsole.logServer.headerIP;
import static serverConsole.logServer.headerPending;
import testserver.dataBase;

public class listenSocket extends javax.swing.JFrame {
    private static Thread listeningThread;
    private static int lastRow = 0;
    private static int firstStart = 1;
    private static listenSocket listenSocket = new listenSocket();
    private static Vector temp = new Vector();
    private static Vector IP = new Vector();
    public listenSocket() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jButton1.setText("Старт");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        serverConsole.enabled(true);
        serverConsole.ssServer.setText("Стоп сервер");
        serverConsole.ssServer.setEnabled(true);    
        this.hide();
        logServer.main(true);
        if(firstStart == 1){
            headerPending.add("Команда");headerPending.add("Данные");headerPending.add("ip");
            headerIP.add("IP");
            firstStart++;
            serverConsole.ssServer.setVisible(false);
        }
        backgroundThread();
    }//GEN-LAST:event_jButton1ActionPerformed

    private static void backgroundThread(){
        listeningThread = new Thread(new Runnable() {
        @Override
        public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(4444);
                    Socket listen = serverSocket.accept();
        
                    ObjectInputStream in = new ObjectInputStream(listen.getInputStream());
                    Object getMessage = new Object();
                    getMessage = in.readObject();
                    
                    temp.add(getMessage);
                    
                    DefaultTableModel dtm = (DefaultTableModel)logServer.pendingTable.getModel();
                    dtm.setDataVector(temp, headerPending);
                    
                    answer();
                    
                    listen.close();
                    serverSocket.close(); 
                    
                    listeningThread.interrupt();
                    if(serverConsole.ssServer.isVisible() == false){
                        jButton1.doClick();
                    }
                } catch (IOException ex) {System.out.println("error");} catch (ClassNotFoundException ex) {System.out.println("error");}
            } 
        });
        listeningThread.start();
    }
    //Формирование ответа сервера
    private static void answer() throws UnknownHostException, IOException {
        String cmd = logServer.pendingTable.getValueAt(lastRow, 0).toString();
        switch (cmd) {
            case "authorization":
                logger(">>> Получен запрос авторизации с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                String login = "";
                String password = "";
                String data = logServer.pendingTable.getValueAt(lastRow, 1).toString();
                int length = data.length();
                int i = 0;
                while(i < length){
                    char ch = data.charAt(i);
                    if(ch != '|'){
                        login = login + ch;
                        i++;
                    }else{
                        password = data.substring(i+1);
                        break;
                    }
                }
                
                String authStatus = "";
                try {authStatus = dataBase.autorization(login, password);} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                
                if((authStatus.equals("teacher")) || (authStatus.equals("student"))){
                    Vector newIP = new Vector();
                    newIP.add(logServer.pendingTable.getValueAt(lastRow, 2).toString());
                    IP.add(newIP);
                    DefaultTableModel dtm = (DefaultTableModel)logServer.ipTable.getModel();
                    dtm.setDataVector(IP, headerIP);
                    logger("        авторизация успешна, уровень доступа пользователя " + authStatus);
                    sendText(authStatus, logServer.pendingTable.getValueAt(lastRow, 2).toString());
                    lastRow++;
                }
                break;
            case "logout":
                logger(">>> Получено оповещение о выходе из системы с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                break;
        }
    }
    
    //Отправление текстового сообщения
    private static void sendText(String toSend, String IP) throws UnknownHostException, IOException{
        IP = IP.substring(1);
        
        int ClientPort = 6464;
        InetAddress ipAdress = InetAddress.getByName(IP);
        
        Socket send = new Socket(ipAdress, ClientPort);
        OutputStream out = send.getOutputStream();
        DataOutputStream outS = new DataOutputStream(out);
        outS.writeUTF(toSend);
        out.flush();
        out.close();
        send.close();
        
        logger("        <<< Отправлено сообщение '" + toSend +"' пользователю с IP " + IP);
    }
    //Отправление вектора
    private static void sendVector(Vector toSend, String IP){
        
    }
    //Осуществеление записей в лог
    private static void logger(String newLine) {
        logServer.logText.setText(logServer.logText.getText() + "\n" + newLine);
    }
    
    public static void main(boolean visible) {
        listenSocket.setResizable(false);
        listenSocket.setVisible(visible);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
