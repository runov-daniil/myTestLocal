package serverConsole;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class listenSocket extends javax.swing.JFrame {
    private static Thread listeningThread;
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
                    
                    listeningThread.interrupt();
                    if(serverConsole.ssServer.getText().equals("Стоп сервер")){
                        jButton1.doClick();
                    }
                } catch (IOException ex) {}
            } 
        });
        listeningThread.start();
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
        Vector table = new Vector();
        table.add(element);
        Vector header = new Vector();
        header.add("Команда");header.add("Данные");header.add("ip");
        DefaultTableModel dtm = (DefaultTableModel)logServer.pendingTable.getModel();
        dtm.setDataVector(table, header);
        logServer.serverLog.setText(logServer.serverLog.getText() + "\n" + "    формирование завершено");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
