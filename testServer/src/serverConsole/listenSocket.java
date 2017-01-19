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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import testserver.dataBase;

public class listenSocket extends javax.swing.JFrame {
    private static Thread listeningThread;
    private static int lastRow = 0;
    private static int lastRowCount = 0;
    private static listenSocket listenSocket = new listenSocket();
    public listenSocket() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("Старт");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        serverConsole.enabled(true);
        serverConsole.ssServer.setText("Стоп сервер");
        serverConsole.ssServer.setEnabled(true);    
        this.hide();
        backgroundThread();
    }//GEN-LAST:event_jButton1ActionPerformed

    private static void backgroundThread(){
        listeningThread = new Thread(new Runnable() {
        @Override
        public void run() {
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Сервер слушает");
                try {
                    ServerSocket serverSocket = new ServerSocket(4444);
                    Socket listen = serverSocket.accept();
        
                    InputStream in = listen.getInputStream();
                    DataInputStream data = new DataInputStream(in);
                    
                    String message = data.readUTF();                   
                    logServer.logText.setText(logServer.logText.getText() + "\n" + ">>> " + message);
                                        
                    listen.close();
                    serverSocket.close(); 
                    
                    reCryptLine(message);
                    
                    answer();
                    listeningThread.interrupt();
                    if(serverConsole.ssServer.getText().equals("Стоп сервер")){
                        jButton1.doClick();
                    }
                } catch (IOException ex) {}
            } 
        });
        listeningThread.start();
    }
    
    public static void answer() throws UnknownHostException, IOException {
        logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Сервер готов отвечать");
        int rowCount = logServer.pendingTable.getRowCount();
        if(lastRowCount < rowCount){
            lastRowCount = rowCount;
            String cmd = logServer.pendingTable.getValueAt(lastRow, 0).toString();
            String data = logServer.pendingTable.getValueAt(lastRow, 1).toString();
            String ip = logServer.pendingTable.getValueAt(lastRow, 2).toString();
            String answer = buildAnswer(cmd, data, ip);
            
            int serverPort = 6464;
            String address = ip;
        
            InetAddress ipAddr = InetAddress.getByName(address);
            Socket send = new Socket(ipAddr, serverPort);
        
            OutputStream out = send.getOutputStream();
            DataOutputStream sOut = new DataOutputStream(out);
            sOut.writeUTF(answer);
            out.flush();
            
            logServer.logText.setText(logServer.logText.getText() + "\n" + "<<< " + answer + " на IP " + ip);
            lastRow++;
        }        
    }
    
    public static void main(boolean visible) {
        listenSocket.setResizable(false);
        listenSocket.setVisible(visible);
    }
    
    private static void reCryptLine(String message){
        logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "Получено сообщение");
        int length = message.length();
        String cmd = "";
        String data = "";
        String ip = "";
        int i = 0;
        logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    Первоначальные данные установлены");
        Vector element = new Vector();
        while(i < length){
            char ch = message.charAt(i);
            if(ch != '*'){
                cmd = cmd + ch;
                i++;
            }else{
                message = message.substring(i+1, length);
                element.add(cmd);
                break;
            }
        }
        logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    определена команда");
        length = message.length();
        i = 0;
        while(i < length){
            char ch = message.charAt(i);
            if(ch != '*'){
                data = data + ch;
                i++;
            }else{
                element.add(data);
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    определены входные данные");
                int lengthData = data.length();
                ip = message.substring(lengthData+2, length);
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    определен IP");
                element.add(ip);
                break;
            }
        }
        logServer.pendingRows.add(element);
        DefaultTableModel newModel = (DefaultTableModel)logServer.pendingTable.getModel();
        newModel.setDataVector(logServer.pendingRows, logServer.headerPending);
        logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    формирование завершено");
    }
    
    private static String buildAnswer(String cmd, String data, String ip) {
        String answer = "";
        int length = 0;
        switch(cmd){
            case "authorization":
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    получен запрос авторизации");
                length = data.length();
                int i = 0;
                String login = "";
                String password = "";
                String level = "";
                while(i < length){
                    char ch = data.charAt(i);
                    if(ch != '|'){
                        login = login + ch;
                        i++;
                    }else{
                        password = data.substring(i+1, length);
                        break;
                    }
                }
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    логин/пароль определен");
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    запрос к базе данных отправлен");
                try {level = testserver.dataBase.autorization(login, password);} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "        ответ на запрос получен");
                if(level.equals("0")){
                    logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    авторизация отклонена");
                }else{
                    logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    авторизация успешно принята");
                    Vector element = new Vector();
                    element.add(ip);
                    logServer.ipRows.add(element);
                    DefaultTableModel newDTM = (DefaultTableModel)logServer.ipTable.getModel();            
                    newDTM.setDataVector(logServer.ipRows, logServer.headerIP);  
                    try {dataBase.newOnline(login);} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                }
                answer = level;
            break;
        }
        return answer;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
