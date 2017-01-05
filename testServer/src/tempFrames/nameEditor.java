package tempFrames;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testserver.dataBase;

public class nameEditor extends javax.swing.JFrame {
    private static nameEditor nameEditor = new nameEditor();
    private static String oldName = "";
    public nameEditor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Изменить");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editorText)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            dataBase.editPredmet(editorText.getText(), oldName);
            frames.predmetsFrame.setEnable(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(boolean visible, String edit) {
        nameEditor.setResizable(false);
        editorText.setText(edit);
        oldName = edit;
        nameEditor.setVisible(visible);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField editorText;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
