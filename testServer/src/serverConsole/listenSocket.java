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

        jButton1 = new javax.swing.JButton();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
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
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
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
    private static void answer() throws UnknownHostException, IOException, ClassNotFoundException {
        String cmd = logServer.pendingTable.getValueAt(lastRow, 0).toString();
        switch (cmd) {
            //<editor-fold defaultstate="collapsed" desc="Авторизация пользователя">
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
                    try {dataBase.newOnline(login);} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                    try {serverConsole.refreshOnline();} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                    sendText(authStatus, logServer.pendingTable.getValueAt(lastRow, 2).toString());
                    lastRow++;
                }
                break;
                //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="logout пользователя">    
            case "logout":
                logger(">>> Получено оповещение о выходе из системы с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                try {dataBase.dropOnline(logServer.pendingTable.getValueAt(lastRow, 1).toString());} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                try {serverConsole.refreshOnline();} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                int countIP = IP.size();
                String detectIP = logServer.pendingTable.getValueAt(lastRow, 2).toString();
                int j = 0;
                while(j < countIP){
                    String ipOnline = IP.elementAt(j).toString();
                    ipOnline = ipOnline.substring(1, ipOnline.length() - 1);
                    if(detectIP.equals(ipOnline)){
                        IP.remove(j);
                        DefaultTableModel dtm = (DefaultTableModel)logServer.ipTable.getModel();
                        dtm.setDataVector(IP, headerIP);
                        break;
                    }else{
                        j++;
                    }
                }
                logger("        Пользователь "+ logServer.pendingTable.getValueAt(lastRow, 1) +" вышел из системы с IP " + logServer.pendingTable.getValueAt(lastRow, 2));                
                lastRow++;
                break;
                //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Запрос вопросов">
            case "getQuestions":
                logger(">>> Получен запрос вопросов учителя с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                Vector toSend = new Vector();
                try {toSend = dataBase.userQuestion(logServer.pendingTable.getValueAt(lastRow, 1).toString());} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                sendVector(toSend, logServer.pendingTable.getValueAt(lastRow, 2).toString());
                lastRow++;
                logger("        <<< Отправлены вопросы пользователя на IP " + IP);
                break;
                //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Запрос параллелей">  
            case "parallels":
                logger(">>> Получен запрос параллелей с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                Vector parallels = new Vector();
                try {parallels = dataBase.takeParallels();} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}   
                sendVector(parallels, logServer.pendingTable.getValueAt(lastRow, 2).toString());
                lastRow++;
                logger("        <<< Отправлены параллели пользователю на IP " + IP);
                break;
                //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Запрос преподаваемых предметов">  
            case "myPredmets":
                logger(">>> Получен запрос преподаваемых предметов с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                Vector predmets = new Vector();
                try {predmets = dataBase.myPredmets(logServer.pendingTable.getValueAt(lastRow, 1).toString());} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
                sendVector(predmets, logServer.pendingTable.getValueAt(lastRow, 2).toString());
                lastRow++;
                logger("        <<< Отправлены преподаваемые предметы пользователю на IP " + IP);
                break;
                //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Добавление нового вопроса">  
            case "saveQuestion":
                logger(">>> Получен запрос добавления нового вопроса с IP " + logServer.pendingTable.getValueAt(lastRow, 2));
                logger("    сервер заблокирован, ожидает вектор вопроса");
                boolean flag = getQuestion(logServer.pendingTable.getValueAt(lastRow, 2).toString());
                if(flag == false){
                    logger("    отказ сохранения вопроса!");
                    sendText("false", logServer.pendingTable.getValueAt(lastRow, 2).toString());
                }else{
                    logger("    вопрос успешно сохранен!");
                    sendText("true", logServer.pendingTable.getValueAt(lastRow, 2).toString());
                }
                lastRow++;
                break;
                //</editor-fold>
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
    private static void sendVector(Vector toSend, String IP) throws UnknownHostException, IOException{
        IP = IP.substring(1);
        int port = 7474;
        
        InetAddress ipAdress = InetAddress.getByName(IP);
        Socket send = new Socket(ipAdress, port);
        ObjectOutputStream out = new ObjectOutputStream(send.getOutputStream());
        
        out.writeObject(toSend);
        out.flush();
        
        out.close();
        send.close();
    }
    //Получение вопроса
    private static boolean getQuestion(String IP) throws UnknownHostException, IOException, ClassNotFoundException {
        boolean flag = false;
        sendText("true", IP);
        
        ServerSocket server = new ServerSocket(1234);
        Socket getVector = server.accept();
        
        ObjectInputStream in = new ObjectInputStream(getVector.getInputStream());
        Object ob = new Object();
        
        ob = in.readObject();
        
        getVector.close();
        server.close();
        logger("    вопрос получен!");
        
        Vector crypt = (Vector) ob;
        
        String question = crypt.elementAt(1).toString();System.out.println(question);
        String question_level = crypt.elementAt(8).toString(); System.out.println(question_level);
        String predmet = crypt.elementAt(9).toString();System.out.println(predmet);
        logger("    вопрос расшифрован! Проверяю на существование!");
        
        boolean exist = false;
        try {exist = dataBase.questionExist(question, predmet, question_level);} catch (SQLException ex) {}
        
        if(exist == false){
            System.out.println("СОХРАНЯЮ");
            try {dataBase.createUserQuestion(crypt);} catch (SQLException ex) {}
            flag = true;
        }else{
            flag = false;
        }
        
        return flag;
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
    // End of variables declaration//GEN-END:variables
}
