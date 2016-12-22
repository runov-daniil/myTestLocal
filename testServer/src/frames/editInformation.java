package frames;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testserver.dataBase;

public class editInformation extends javax.swing.JFrame {
    private static editInformation editInformation = new editInformation();
    public editInformation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        fioLabel = new javax.swing.JLabel();
        switchText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        classToClass = new javax.swing.JPanel();
        fioClassLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newClassSelect = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();
        switchLoginText = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fioLabel.setText("jLabel1");

        jButton1.setText("Изменить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fioClassLabel.setText("jLabel3");

        classLabel.setText("jLabel4");

        jLabel5.setText("Перевести в:");

        jButton2.setText("Перевести");

        javax.swing.GroupLayout classToClassLayout = new javax.swing.GroupLayout(classToClass);
        classToClass.setLayout(classToClassLayout);
        classToClassLayout.setHorizontalGroup(
            classToClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classToClassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(classToClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(classToClassLayout.createSequentialGroup()
                        .addGroup(classToClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fioClassLabel)
                            .addComponent(classLabel)
                            .addGroup(classToClassLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        classToClassLayout.setVerticalGroup(
            classToClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classToClassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fioClassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(classToClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(newClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loginLabel.setText("jLabel1");

        jButton3.setText("Изменить");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(switchText)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classToClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(switchLoginText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fioLabel)
                            .addComponent(loginLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(switchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(switchLoginText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classToClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(classToClass.isVisible() != true){
            try {
                dataBase.editFIO("teacher");
            } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
        }else{
            try {
                dataBase.editFIO("student");
            } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void students(boolean visible) {
        if(visible == true){
            editInformation.setResizable(false);
            classToClass.setVisible(true);
            editInformation.setSize(300, 340);
            editInformation.setVisible(true); 
        }else{
            editInformation.setVisible(false);
        }
    }

    public static void teachers(boolean visible) {
        if(visible == true){
            editInformation.setResizable(false);
            classToClass.setVisible(false);
            editInformation.setSize(300, 210);
            editInformation.setVisible(true); 
        }else{
            editInformation.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel classLabel;
    public static javax.swing.JPanel classToClass;
    public static javax.swing.JLabel fioClassLabel;
    public static javax.swing.JLabel fioLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel loginLabel;
    public static javax.swing.JComboBox<String> newClassSelect;
    private javax.swing.JTextField switchLoginText;
    public static javax.swing.JTextField switchText;
    // End of variables declaration//GEN-END:variables
}
