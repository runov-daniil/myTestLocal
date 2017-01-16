package frames;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import testserver.dataBase;

public class mainFrame extends javax.swing.JFrame {
    private static mainFrame mainFrame = new mainFrame();
    public mainFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTable = new javax.swing.JTable();
        createQuestion = new javax.swing.JButton();
        deleteQuestion = new javax.swing.JButton();
        editQuestion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        servicePanel = new javax.swing.JPanel();
        startServerBtn = new javax.swing.JButton();
        logServerBtn = new javax.swing.JButton();
        classesBtn = new javax.swing.JButton();
        predmetsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        studentsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        createStudent = new javax.swing.JButton();
        deleteStudent = new javax.swing.JButton();
        editStudent = new javax.swing.JButton();
        statisticsStudent = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        editTeacher = new javax.swing.JButton();
        deleteTeacher = new javax.swing.JButton();
        createTeacher = new javax.swing.JButton();
        setPredmetsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        questionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        questionTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(questionTable);

        createQuestion.setText("Добавить");
        createQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createQuestionActionPerformed(evt);
            }
        });

        deleteQuestion.setText("Удалить");
        deleteQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteQuestionActionPerformed(evt);
            }
        });

        editQuestion.setText("Редактировать");
        editQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuestionActionPerformed(evt);
            }
        });

        jLabel1.setText("Вопросы");

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(createQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editQuestion))
                    .addComponent(jScrollPane1)
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createQuestion)
                            .addComponent(deleteQuestion)
                            .addComponent(editQuestion))
                        .addContainerGap())))
        );

        servicePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        startServerBtn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        startServerBtn.setText("Консоль сервера");
        startServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerBtnActionPerformed(evt);
            }
        });

        logServerBtn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        logServerBtn.setText("Открыть лог");

        classesBtn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        classesBtn.setText("Классы");
        classesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classesBtnActionPerformed(evt);
            }
        });

        predmetsButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        predmetsButton.setText("Предметы");
        predmetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predmetsButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Имя учетной записи:");

        loginLabel.setText("loginLabel");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Сменить пароль");

        javax.swing.GroupLayout servicePanelLayout = new javax.swing.GroupLayout(servicePanel);
        servicePanel.setLayout(servicePanelLayout);
        servicePanelLayout.setHorizontalGroup(
            servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startServerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logServerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(predmetsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(servicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)))
                .addContainerGap())
        );
        servicePanelLayout.setVerticalGroup(
            servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startServerBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logServerBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(predmetsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(loginLabel)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        studentsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(studentsTable);

        createStudent.setText("Добавить");
        createStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStudentActionPerformed(evt);
            }
        });

        deleteStudent.setText("Удалить");
        deleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentActionPerformed(evt);
            }
        });

        editStudent.setText("Редактировать");
        editStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentActionPerformed(evt);
            }
        });

        statisticsStudent.setText("Статистика");

        javax.swing.GroupLayout studentsPanelLayout = new javax.swing.GroupLayout(studentsPanel);
        studentsPanel.setLayout(studentsPanelLayout);
        studentsPanelLayout.setHorizontalGroup(
            studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .addGroup(studentsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statisticsStudent)
                .addContainerGap())
        );
        studentsPanelLayout.setVerticalGroup(
            studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createStudent)
                    .addComponent(deleteStudent)
                    .addComponent(editStudent)
                    .addComponent(statisticsStudent))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ученики", studentsPanel);

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(teacherTable);

        editTeacher.setText("Редактировать");
        editTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeacherActionPerformed(evt);
            }
        });

        deleteTeacher.setText("Удалить");
        deleteTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeacherActionPerformed(evt);
            }
        });

        createTeacher.setText("Добавить");
        createTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTeacherActionPerformed(evt);
            }
        });

        setPredmetsButton.setText("Назначение предметов");
        setPredmetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPredmetsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setPredmetsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createTeacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteTeacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTeacher)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTeacher)
                    .addComponent(deleteTeacher)
                    .addComponent(createTeacher)
                    .addComponent(setPredmetsButton))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Учителя", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(servicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerBtnActionPerformed
        serverConsole.serverConsole.main(true);
    }//GEN-LAST:event_startServerBtnActionPerformed

    private void createStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStudentActionPerformed
        try {frames.createNewUser.main(true);frames.createNewUser.revealClassSettings();} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
        enableMainForm(false);
    }//GEN-LAST:event_createStudentActionPerformed

    private void createTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTeacherActionPerformed
        try {frames.createNewUser.main(true);} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
        enableMainForm(false);
        frames.createNewUser.hideClassSettings();
    }//GEN-LAST:event_createTeacherActionPerformed

    private void deleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentActionPerformed
        int count = studentsTable.getRowCount();
        for(int i = 0; i < count; i++){
            if(studentsTable.isCellSelected(i, 0)){
                Object object = studentsTable.getValueAt(i, 0);
                int id = Integer.parseInt(object.toString());
                System.out.println(id);
                try {dataBase.deleteUser(id, "student");} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
            }
        }        
    }//GEN-LAST:event_deleteStudentActionPerformed

    private void deleteTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTeacherActionPerformed
        int count = teacherTable.getRowCount();
        for(int i = 0; i < count; i++){
            if(teacherTable.isCellSelected(i, 0)){
                Object object = teacherTable.getValueAt(i, 0);
                int id = Integer.parseInt(object.toString());
                System.out.println(id);
                try {dataBase.deleteUser(id, "teacher");} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
            }
        } 
    }//GEN-LAST:event_deleteTeacherActionPerformed

    private void classesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classesBtnActionPerformed
        try {classesFrame.main(true);} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
    }//GEN-LAST:event_classesBtnActionPerformed

    private void editStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentActionPerformed
        editInformation.students(true);
        int row = studentsTable.getSelectedRow();
        try {
            frames.editInformation.idLabel.setText(studentsTable.getValueAt(row, 0).toString());
            dataBase.setDataEditInformation(Integer.parseInt(studentsTable.getValueAt(row, 0).toString()));
        } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
    }//GEN-LAST:event_editStudentActionPerformed

    private void editTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeacherActionPerformed
        editInformation.teachers(true);
        int row = teacherTable.getSelectedRow();
        try {
            frames.editInformation.idLabel.setText(teacherTable.getValueAt(row, 0).toString());
            dataBase.setDataEditInformation(Integer.parseInt(teacherTable.getValueAt(row, 0).toString()));
        } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
    }//GEN-LAST:event_editTeacherActionPerformed

    private void createQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createQuestionActionPerformed
        newQuestion.main(true);
    }//GEN-LAST:event_createQuestionActionPerformed

    private void predmetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predmetsButtonActionPerformed
        predmetsFrame.main(true);
        this.setEnabled(false);
    }//GEN-LAST:event_predmetsButtonActionPerformed

    private void setPredmetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPredmetsButtonActionPerformed
        int row = teacherTable.getSelectedRow();
        setTeacherPredmets.main(true, teacherTable.getValueAt(row, 2).toString());
        enableMainForm(false);
    }//GEN-LAST:event_setPredmetsButtonActionPerformed

    private void deleteQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteQuestionActionPerformed
        int row = questionTable.getSelectedRow();
        try {
            dataBase.deleteQuestion(Integer.parseInt(questionTable.getValueAt(row, 1).toString()));
        } catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
    }//GEN-LAST:event_deleteQuestionActionPerformed

    private void editQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuestionActionPerformed
        int selectedRow = questionTable.getSelectedRow();
        String flag = questionTable.getValueAt(selectedRow, 0).toString();
        int idQuestion = Integer.parseInt(questionTable.getValueAt(selectedRow, 1).toString());
        switch (flag) {
            case "С выбором ответа":
                frames.editQuestion.jTabbedPane1.setEnabledAt(1, false);
                frames.editQuestion.jTabbedPane1.setEnabledAt(0, true);
                frames.editQuestion.jTabbedPane1.setSelectedIndex(0);
                frames.editQuestion.main(true, 1, idQuestion);
                break;
            case "Без выбора ответа":
                frames.editQuestion.jTabbedPane1.setEnabledAt(0, false);
                frames.editQuestion.jTabbedPane1.setEnabledAt(1, true);
                frames.editQuestion.jTabbedPane1.setSelectedIndex(1);
                frames.editQuestion.main(true, 2, idQuestion);
                break;
        }
        this.enable(false);
    }//GEN-LAST:event_editQuestionActionPerformed

    public static void main(boolean visible) {
        if(visible == true){
            mainFrame.setResizable(false);
            mainFrame.setVisible(true);
            mainFrame.setEnabled(true);
        }else{
            mainFrame.setVisible(false);
        }
    }
    
    public static void setSettingsPanel(String login) {
        mainFrame.loginLabel.setText(login);
    }
    
    public static void setQuestionPanel() {
        
    }
    
    public static void enableMainForm(boolean enable) {
        mainFrame.setEnabled(enable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton classesBtn;
    private javax.swing.JButton createQuestion;
    private javax.swing.JButton createStudent;
    private javax.swing.JButton createTeacher;
    private javax.swing.JButton deleteQuestion;
    private javax.swing.JButton deleteStudent;
    private javax.swing.JButton deleteTeacher;
    private javax.swing.JButton editQuestion;
    private javax.swing.JButton editStudent;
    private javax.swing.JButton editTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logServerBtn;
    public static javax.swing.JLabel loginLabel;
    private javax.swing.JButton predmetsButton;
    private javax.swing.JPanel questionPanel;
    public static javax.swing.JTable questionTable;
    private javax.swing.JPanel servicePanel;
    private javax.swing.JButton setPredmetsButton;
    private javax.swing.JButton startServerBtn;
    private javax.swing.JButton statisticsStudent;
    private javax.swing.JPanel studentsPanel;
    public static javax.swing.JTable studentsTable;
    public static javax.swing.JTable teacherTable;
    // End of variables declaration//GEN-END:variables
}