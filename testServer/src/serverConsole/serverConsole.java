package serverConsole;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import testserver.dataBase;

public class serverConsole extends javax.swing.JFrame {
    private static serverConsole serverConsole = new serverConsole();
    public serverConsole() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        onlineTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        startsTest = new javax.swing.JTable();
        ssServer = new javax.swing.JButton();
        startTest = new javax.swing.JButton();
        consoleOpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        onlineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(onlineTable);

        startsTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(startsTest);

        ssServer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ssServer.setText("Запустить сервер");
        ssServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssServerActionPerformed(evt);
            }
        });

        startTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startTest.setText("Запустить тест");
        startTest.setEnabled(false);

        consoleOpen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        consoleOpen.setText("Открыть лог команд");
        consoleOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consoleOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssServer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consoleOpen))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssServer)
                    .addComponent(startTest)
                    .addComponent(consoleOpen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ssServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssServerActionPerformed
        String txt = ssServer.getText();
        switch (txt) {
            case "Запустить сервер":
                startTest.setEnabled(true);
                ssServer.setText("Остановить сервер");
                systemServer.main("start");
                break;
            case "Остановить сервер":
                startTest.setEnabled(false);
                ssServer.setText("Запустить сервер");
                systemServer.main("stop");
                break;
        }
    }//GEN-LAST:event_ssServerActionPerformed

    private void consoleOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consoleOpenActionPerformed
        logServer.main(true);
    }//GEN-LAST:event_consoleOpenActionPerformed

    public static void refreshOnline() throws ClassNotFoundException, SQLException {
        Vector online = dataBase.refreshOnline();
        Vector header = new Vector();
        header.add("Пользователи онлайн: ");
        DefaultTableModel dtm = (DefaultTableModel)onlineTable.getModel();
        dtm.setDataVector(online, header);
    }
    public static void main(boolean visible) {
        serverConsole.setResizable(false);
        serverConsole.setVisible(visible);
        logServer.main(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consoleOpen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable onlineTable;
    private javax.swing.JButton ssServer;
    private javax.swing.JButton startTest;
    private javax.swing.JTable startsTest;
    // End of variables declaration//GEN-END:variables
}
