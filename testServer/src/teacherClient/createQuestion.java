package teacherClient;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class createQuestion extends javax.swing.JFrame {
    public static createQuestion createQuestion = new createQuestion();
    public createQuestion() {
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
        selectParallel = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        predmetsCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        questionText1 = new javax.swing.JTextArea();
        saveQuestion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        answerText = new javax.swing.JTextField();
        selectParallel1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        predmetsCB1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        selectParallel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        selectParallel.setToolTipText("");

        jLabel6.setText("Предмет:");

        jLabel4.setText("Параллель");

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
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectParallel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(predmetsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(selectParallel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(predmetsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveQuestionCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("С выбором ответа", jPanel1);

        jLabel2.setText("Введите вопрос");

        questionText1.setColumns(20);
        questionText1.setRows(5);
        jScrollPane2.setViewportView(questionText1);

        saveQuestion.setText("Сохранить");
        saveQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuestionActionPerformed(evt);
            }
        });

        jLabel3.setText("Ответ");

        selectParallel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        selectParallel1.setToolTipText("");

        jLabel5.setText("Параллель");

        jLabel7.setText("Предмет:");

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
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(predmetsCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(predmetsCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(selectParallel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void answer1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer1ItemStateChanged
        if(answer1.isSelected()){
            answer0.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
        }
    }//GEN-LAST:event_answer1ItemStateChanged

    private void answer0ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer0ItemStateChanged
        if(answer0.isSelected()){
            answer1.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
        }
    }//GEN-LAST:event_answer0ItemStateChanged

    private void answer3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer3ItemStateChanged
        if(answer3.isSelected()){
            answer1.setSelected(false);
            answer2.setSelected(false);
            answer0.setSelected(false);
        }
    }//GEN-LAST:event_answer3ItemStateChanged

    private void answer2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answer2ItemStateChanged
        if(answer2.isSelected()){
            answer1.setSelected(false);
            answer0.setSelected(false);
            answer3.setSelected(false);
        }
    }//GEN-LAST:event_answer2ItemStateChanged

    private void saveQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuestionActionPerformed
        
    }//GEN-LAST:event_saveQuestionActionPerformed

    private void saveQuestionCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuestionCheckActionPerformed
        try {boolean save = sendQuestion();
            if(save = true){
                JOptionPane.showMessageDialog(rootPane, "Вопрос успешно сохранен!");
                try {teacherSocket.send("getQuestions", teacherClient.loginLabel.getText());} catch (IOException ex) {}
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Вопрос с такой формуллировкой уже существует!");
            }
        } catch (IOException ex) {} catch (ClassNotFoundException ex) {}
    }//GEN-LAST:event_saveQuestionCheckActionPerformed

    public static void main(boolean visible) {
        createQuestion.setResizable(false);
        createQuestion.setVisible(visible);
        try {parallels();} catch (IOException ex) {} catch (ClassNotFoundException ex) {}
        try {myPredmets();} catch (IOException ex) {} catch (ClassNotFoundException ex) {}
    }
    //Запрос параллелей
    private static void parallels() throws IOException, ClassNotFoundException{
        teacherSocket.send("parallels", "null");
        
        Object ob = new Object();
        ob = teacherSocket.getVector();
        Vector get = (Vector) ob;
        
        int count = get.size();
        for(int i = 0; i < count; i++){
            String element = get.elementAt(i).toString();
            element = element.substring(1, element.length()-1);
            if(!(element.equals("0"))){
                selectParallel.addItem(element);
                selectParallel1.addItem(element);
            }
        }
    }
    //Запрос преподаваемых предметов
    private static void myPredmets() throws IOException, ClassNotFoundException {
        teacherSocket.send("myPredmets", teacherClient.loginLabel.getText());
        
        Object ob = new Object();
        ob = teacherSocket.getVector();
        Vector get = (Vector) ob;
        
        int count = get.size();
        for(int i = 0; i < count; i++){
            String element = get.elementAt(i).toString();
            element = element.substring(1, element.length()-1);
            predmetsCB.addItem(element);
            predmetsCB1.addItem(element);
        }
    }
    //Формирование вопроса и отправка на сервер
    private static boolean sendQuestion() throws IOException, ClassNotFoundException {
        boolean pending = teacherSocket.serverPending();
        boolean save = false;
        
        if(pending = true){
            Vector toSend = new Vector();
            toSend.add(teacherClient.loginLabel.getText());
            toSend.add(questionText.getText());
            toSend.add(answerText0.getText());
            toSend.add(answerText1.getText());
            toSend.add(answerText2.getText());
            toSend.add(answerText3.getText());
            
            if(answer0.isSelected()){
                toSend.add(answerText0.getText());
            }else if(answer1.isSelected()){
                    toSend.add(answerText1.getText());
            }else if(answer2.isSelected()){
                    toSend.add(answerText2.getText());
            }else if(answer3.isSelected()){
                    toSend.add(answerText3.getText());
            }
            toSend.add("1");
            toSend.add(selectParallel.getSelectedItem().toString());
            toSend.add(predmetsCB.getSelectedItem().toString());
            
            teacherSocket.sendVector(toSend);
            
            save = teacherSocket.serverPending();
        }
        return save;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton answer0;
    public static javax.swing.JRadioButton answer1;
    public static javax.swing.JRadioButton answer2;
    public static javax.swing.JRadioButton answer3;
    public static javax.swing.JTextField answerText;
    public static javax.swing.JTextField answerText0;
    public static javax.swing.JTextField answerText1;
    public static javax.swing.JTextField answerText2;
    public static javax.swing.JTextField answerText3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JComboBox<String> predmetsCB;
    public static javax.swing.JComboBox<String> predmetsCB1;
    public static javax.swing.JTextArea questionText;
    public static javax.swing.JTextArea questionText1;
    private javax.swing.JButton saveQuestion;
    private javax.swing.JButton saveQuestionCheck;
    public static javax.swing.JComboBox<String> selectParallel;
    public static javax.swing.JComboBox<String> selectParallel1;
    // End of variables declaration//GEN-END:variables
}
