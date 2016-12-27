package frames;

import java.sql.SQLException;
import testserver.dataBase;

public class newQuestion extends javax.swing.JFrame {
    private static newQuestion newQuestion = new newQuestion();
    public newQuestion() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionText = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        answer1 = new javax.swing.JRadioButton();
        answerText3 = new javax.swing.JTextField();
        answerText1 = new javax.swing.JTextField();
        answer0 = new javax.swing.JRadioButton();
        answer3 = new javax.swing.JRadioButton();
        answerText2 = new javax.swing.JTextField();
        answerText0 = new javax.swing.JTextField();
        answer2 = new javax.swing.JRadioButton();
        saveQuestionCheck = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        selectParallel = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        questionText1 = new javax.swing.JTextArea();
        saveQuestion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        answerText = new javax.swing.JTextField();
        selectParallel1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Введите вопрос");

        questionText.setColumns(20);
        questionText.setRows(5);
        jScrollPane1.setViewportView(questionText);

        answer1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answer1ItemStateChanged(evt);
            }
        });

        answer0.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answer0ItemStateChanged(evt);
            }
        });

        answer3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answer3ItemStateChanged(evt);
            }
        });

        answer2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answer2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(answer0)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(answerText0, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(answer1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerText1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(answer2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerText2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(answer3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerText3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(answerText0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(answer0))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(answer1)
                                .addComponent(answerText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(answer2))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(answerText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(answer3)
                        .addComponent(answerText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        saveQuestionCheck.setText("Сохранить");
        saveQuestionCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuestionCheckActionPerformed(evt);
            }
        });

        jLabel4.setText("Параллель");

        selectParallel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        selectParallel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveQuestionCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 50, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectParallel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(selectParallel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveQuestionCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("С выбором ответа", jPanel1);

        jLabel2.setText("Введите вопрос");

        questionText1.setColumns(20);
        questionText1.setRows(5);
        jScrollPane2.setViewportView(questionText1);

        saveQuestion.setText("Сохранить");

        jLabel3.setText("Ответ");

        selectParallel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        selectParallel1.setToolTipText("");

        jLabel5.setText("Параллель");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(answerText))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectParallel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(answerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(selectParallel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Без выбора ответа", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void answer0ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer0ItemStateChanged
        if(answer0.isSelected()){
            answer1.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
        }
    }//GEN-LAST:event_answer0ItemStateChanged

    private void answer1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer1ItemStateChanged
        if(answer1.isSelected()){
            answer0.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
        }
    }//GEN-LAST:event_answer1ItemStateChanged

    private void answer2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer2ItemStateChanged
        if(answer2.isSelected()){
            answer1.setSelected(false);
            answer0.setSelected(false);
            answer3.setSelected(false);
        }
    }//GEN-LAST:event_answer2ItemStateChanged

    private void answer3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer3ItemStateChanged
         if(answer3.isSelected()){
            answer1.setSelected(false);
            answer2.setSelected(false);
            answer0.setSelected(false);
        }
    }//GEN-LAST:event_answer3ItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mainFrame.enableMainForm(true);
    }//GEN-LAST:event_formWindowClosing

    private void saveQuestionCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuestionCheckActionPerformed
        try {
            dataBase.createNewQuestion(1);
        } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
    }//GEN-LAST:event_saveQuestionCheckActionPerformed

    public static void main(boolean visible) {
        if(visible == true){
            newQuestion.setResizable(false);
            try {
                newQuestion.selectParallel.removeAllItems();
                newQuestion.selectParallel1.removeAllItems();
                String parallels = dataBase.refreshClasses();
                String buf = "";
                int length_parallels = parallels.length();
                for(int i = 0; i < length_parallels; i++){
                    char ch = parallels.charAt(i);
                    if(ch != '|'){
                        buf = buf + ch;
                    }else{
                        int length_buf = buf.length();
                        newQuestion.selectParallel.addItem(buf.substring(0, length_buf - 1));
                        buf = "";
                    }
                }
                int count_parallels = newQuestion.selectParallel.getItemCount();
                int[] elements;
                elements = new int[count_parallels];
                for(int i = 0; i < count_parallels; i++){
                    elements[i] = Integer.parseInt(newQuestion.selectParallel.getItemAt(i));
                }
                for(int i = 0; i < count_parallels-1; i++)
                    for(int j = 0; j < count_parallels-1; j++){
                        if(elements[j] > elements[j+1]){
                            int sw = elements[j];
                            elements[j] = elements[j+1];
                            elements[j+1] = sw;
                        }
                    }
                for(int i = 0; i < count_parallels-1; i++)
                    for(int j = i + 1; j < count_parallels; j++){
                        if((elements[i] != -1) || (elements[j] != -1)){
                            if(elements[i] == elements[j]){
                                elements[j] = -1;
                            }
                        }
                    }
                newQuestion.selectParallel.removeAllItems();
                for(int i = 0; i < count_parallels-1; i++){
                    if(elements[i] != -1){
                        newQuestion.selectParallel.addItem(String.valueOf(elements[i]));
                        newQuestion.selectParallel1.addItem(String.valueOf(elements[i]));
                    }
                }
            } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
            newQuestion.setVisible(true);
            mainFrame.enableMainForm(false);
        }else{
            newQuestion.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton answer0;
    private javax.swing.JRadioButton answer1;
    private javax.swing.JRadioButton answer2;
    private javax.swing.JRadioButton answer3;
    private javax.swing.JTextField answerText;
    private javax.swing.JTextField answerText0;
    private javax.swing.JTextField answerText1;
    private javax.swing.JTextField answerText2;
    private javax.swing.JTextField answerText3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea questionText;
    private javax.swing.JTextArea questionText1;
    private javax.swing.JButton saveQuestion;
    private javax.swing.JButton saveQuestionCheck;
    private javax.swing.JComboBox<String> selectParallel;
    private javax.swing.JComboBox<String> selectParallel1;
    // End of variables declaration//GEN-END:variables
}
