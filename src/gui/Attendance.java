package gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Attendance extends javax.swing.JFrame {

    private static HashMap<String, String> attendanceMap = new HashMap<>();
    private static HashMap<String, String> coursesMap = new HashMap<>();

    public Attendance() {
        initComponents();
        LoadAttendStatus();
        LoadCourses();
        LoadTable();
        jTable1.getTableHeader().setBackground(new Color(49, 49, 49));
        jTable1.getTableHeader().setForeground(new Color(250, 250, 250));
    }

    private void LoadAttendStatus() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `attendancestatus`");

            Vector<String> attendStatus = new Vector<>();
            attendStatus.add("Select");

            while (resultSet.next()) {
                attendStatus.add(resultSet.getString("Status"));
                attendanceMap.put(resultSet.getString("Status"), resultSet.getString("ID"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(attendStatus);
            jComboBox2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadCourses() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `courses`");
            Vector<String> courses = new Vector<>();
            courses.add("Select");
            while (resultSet.next()) {
                courses.add(resultSet.getString("CoursesName"));
                coursesMap.put(resultSet.getString("CoursesName"), resultSet.getString("CoursesID"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(courses);
            jComboBox1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadTable() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `attendance` INNER JOIN `students` ON `attendance`.`Students_StudentID`=`students`.`StudentID`\n"
                    + "INNER JOIN `courses` ON `attendance`.`Courses_CoursesID`=`courses`.`CoursesID` INNER JOIN `attendancestatus`\n"
                    + "ON `attendance`.`AttendanceStatus_ID`=`attendancestatus`.`ID`;");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> table = new Vector<>();
                table.add(resultSet.getString("AttendanceID"));
                table.add(resultSet.getString("Date"));
                table.add(resultSet.getString("students.StudentID"));
                table.add(resultSet.getString("students.FirstName"));
                table.add(resultSet.getString("students.LastName"));
                table.add(resultSet.getString("courses.CoursesName"));
                table.add(resultSet.getString("attendancestatus.Status"));

                model.addRow(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTable1.clearSelection();
        jButton4.setEnabled(true);
        jTextField1.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 610));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Students Attendance");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(623, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1030, 70));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attendance ID", "Date", "Student ID", "First Name", "Last Name", "Courses", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 1020, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Student ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 70, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Courses");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 70, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 160, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Status");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 50, -1));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 130, 160, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("2023 | SIPNARA | Student Management System");

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 255));
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 1020, 60));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 40, 40));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Mark Attendance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 390, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String stID = jTextField1.getText();
        String coursesName = String.valueOf(jComboBox1.getSelectedItem());
        String attendStatus = String.valueOf(jComboBox2.getSelectedItem());

        if (stID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter Student ID", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (coursesName.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Plese Select Courses", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (attendStatus.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Plese Select Attendance Status", "Worning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `students` WHERE `StudentID`='" + stID + "'");
                if (resultSet.next()) {
                    Date date = new Date();
                    SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("INSERT INTO `sipnara_db`.`attendance`(`Date`,`Students_StudentID`,`Courses_CoursesID`,`AttendanceStatus_ID`)\n"
                            + "VALUES ('" + dateFormate.format(date) + "','" + stID + "','" + coursesMap.get(coursesName) + "','" + attendanceMap.get(attendStatus) + "');");
                    reset();
                    LoadTable();
                    JOptionPane.showMessageDialog(this, "Attendance Mark Success", "Infromation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Your Enter ID Number not Student Registerd", "Infromation", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //view attendance
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 1) {

            int row = jTable1.getSelectedRow();

            String stID = String.valueOf(jTable1.getValueAt(row, 2));
            jTextField1.setText(stID);

            String courses = String.valueOf(jTable1.getValueAt(row, 5));
            jComboBox1.setSelectedItem(courses);

            String status = String.valueOf(jTable1.getValueAt(row, 6));
            jComboBox2.setSelectedItem(status);

            jButton4.setEnabled(false);
            jTextField1.setEditable(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        reset();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String stID = jTextField1.getText();
        String courses = String.valueOf(jComboBox1.getSelectedItem());
        String status = String.valueOf(jComboBox2.getSelectedItem());

        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Plese Select Singale Row", "Worning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (stID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter Student ID", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (courses.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Plese Select Courses", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (status.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Plese Select Status", "Worning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int row = jTable1.getSelectedRow();
                    String id = String.valueOf(jTable1.getValueAt(row, 0));
                    MySQL.execute("UPDATE `attendance` SET `Courses_CoursesID`='" + coursesMap.get(courses) + "' ,"
                            + " `AttendanceStatus_ID`='" + attendanceMap.get(status) + "' WHERE `AttendanceID`='" + id + "' ");
                    LoadTable();
                    reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
