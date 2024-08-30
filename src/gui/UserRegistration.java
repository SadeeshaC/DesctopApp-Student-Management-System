package gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserRegistration extends javax.swing.JFrame {

    private static HashMap<String, String> genderMap = new HashMap<>();
    private static HashMap<String, String> userTypeMap = new HashMap<>();

    public UserRegistration() {
        initComponents();
        LoadGender();
        LoadUserType();
        LoadTable();
        jTable1.getTableHeader().setBackground(new Color(49, 49, 49));
        jTable1.getTableHeader().setForeground(new Color(250, 250, 250));
    }

    private void LoadGender() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");

            Vector<String> gender = new Vector<>();
            gender.add("Select");

            while (resultSet.next()) {
                gender.add(resultSet.getString("Type"));
                genderMap.put(resultSet.getString("Type"), resultSet.getString("GenderID"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(gender);
            jComboBox2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadUserType() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `usertype`");
            Vector<String> userType = new Vector<>();
            userType.add("Select");
            while (resultSet.next()) {
                userType.add(resultSet.getString("Type"));
                userTypeMap.put(resultSet.getString("Type"), resultSet.getString("UserID"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(userType);
            jComboBox1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadTable() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `userauthentication` \n"
                    + "INNER JOIN `usertype` ON `userauthentication`.`UserType_UserID`=`usertype`.`UserID`\n"
                    + "INNER JOIN `gender` ON `userauthentication`.`Gender_GenderID` = `gender`.`GenderID`;");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> table = new Vector<>();
                table.add(resultSet.getString("Email"));
                table.add(resultSet.getString("Password"));
                table.add(resultSet.getString("usertype.Type"));
                table.add(resultSet.getString("FirstName"));
                table.add(resultSet.getString("LastName"));
                table.add(resultSet.getString("Mobile"));
                table.add(resultSet.getString("Nic"));
                table.add(resultSet.getString("gender.Type"));

                model.addRow(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField1.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jComboBox2.setSelectedIndex(0);
        jTable1.clearSelection();
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
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

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
        jLabel9.setText("User Registration");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(676, Short.MAX_VALUE))
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
                "Email", "Password", "User Type", "First Name", "Last Name", "Mobile", "Nic", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 1020, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Email");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 40, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User Type");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 70, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 160, -1));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("First Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 80, -1));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 160, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Last Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 80, -1));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 160, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mobile");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 50, -1));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 160, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Gender");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 50, -1));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, 160, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nic no");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 170, 50, -1));

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 160, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 153));
        jButton3.setText("New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 0));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("2023 | SIPNARA | Student Management System");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 255));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String email = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String userType = String.valueOf(jComboBox1.getSelectedItem());
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String mobile = jTextField4.getText();
        String nic = jTextField5.getText();
        String gender = String.valueOf(jComboBox2.getSelectedItem());

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter User Email", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalide User Email", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter User Password", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
            JOptionPane.showMessageDialog(this, "Password must contain minimum eight characters, at least one uppercase letter, one lowercase letter and one number", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (userType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Plese Select User Type", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter User First Name", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter User Last Name", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter User Mobile", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalide User Mobile", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Enter User Nic no", "Worning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Plese Select User Gender", "Worning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `userauthentication` WHERE `Email`='" + email + "' OR `Nic`='" + nic + "' OR `Mobile`='" + mobile + "'");
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Email & Nic Or Mobile already used", "Worning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.execute("INSERT INTO `userauthentication`(`Email`,`Password`,`UserType_UserID`,`FirstName`,`LastName`,`Mobile`,`Nic`,`Gender_GenderID`)\n"
                            + "VALUE ('" + email + "','" + password + "',(SELECT `UserID` FROM `usertype` WHERE `Type`='" + userType + "' ),'" + fname + "','" + lname + "','" + mobile + "','" + nic + "',(SELECT `GenderID` FROM `gender` WHERE `Type`='" + gender + "'));");
                    JOptionPane.showMessageDialog(this, "Your Registration Success", "Infromation", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            reset();
            LoadTable();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
        jButton3.setEnabled(true);
        jTextField1.setEditable(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String userType = String.valueOf(jComboBox1.getSelectedItem());
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String mobile = jTextField4.getText();
        String nic = jTextField5.getText();
        String gender = String.valueOf(jComboBox2.getSelectedItem());

        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Plese Select Row", "Worning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter User Email", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Invalide User Email", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter User Password", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
                JOptionPane.showMessageDialog(this, "Password must contain minimum eight characters, at least one uppercase letter, one lowercase letter and one number", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (userType.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Plese Select User Type", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter User First Name", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter User Last Name", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter User Mobile", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalide User Mobile", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese Enter User Nic no", "Worning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Plese Select User Gender", "Worning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int option = JOptionPane.showConfirmDialog(this, "Do you want to Update this Row", "Update", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        MySQL.execute("UPDATE `userauthentication` SET `Password`='" + password + "' , `UserType_UserID`='" + userTypeMap.get(userType) + "' ,\n"
                                + "`FirstName`='" + fname + "' , `LastName`='" + lname + "' , `Mobile`='" + mobile + "' , `Nic`='" + nic + "' , `Gender_GenderID`='" + genderMap.get(gender) + "' WHERE `Email`='" + email + "'; ");

                        jButton3.setEnabled(true);

                    } else {
                        jButton3.setEnabled(true);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                reset();
                LoadTable();
                jTextField1.setEditable(true);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 1) {

            int row = jTable1.getSelectedRow();

            String email = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField1.setText(email);

            String password = String.valueOf(jTable1.getValueAt(row, 1));
            jPasswordField1.setText(password);

            String userType = String.valueOf(jTable1.getValueAt(row, 2));
            jComboBox1.setSelectedItem(userType);

            String fname = String.valueOf(jTable1.getValueAt(row, 3));
            jTextField2.setText(fname);

            String lname = String.valueOf(jTable1.getValueAt(row, 4));
            jTextField3.setText(lname);

            String mobile = String.valueOf(jTable1.getValueAt(row, 5));
            jTextField4.setText(mobile);

            String nic = String.valueOf(jTable1.getValueAt(row, 6));
            jTextField5.setText(nic);

            String gender = String.valueOf(jTable1.getValueAt(row, 7));
            jComboBox2.setSelectedItem(gender);

            jButton3.setEnabled(false);
            jTextField1.setEditable(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (jTable1.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Plese Select Row", "Worning", JOptionPane.WARNING_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Do you want to Delete this Row", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {

                    String email = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0));

                    MySQL.execute("DELETE FROM `userauthentication` WHERE `Email`='" + email + "';");
                    reset();
                    LoadTable();
                    jButton3.setEnabled(true);

                } else {
                    reset();
                    LoadTable();
                    jButton3.setEnabled(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
