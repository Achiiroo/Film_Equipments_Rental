/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import AdminUI.AdminMainMenu;
import CustomerUI.CustomerMain;
import UI.UserSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author dave
 */
public class Login extends javax.swing.JFrame {
    private static String loggedInUserID;

    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        EmailFld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordFld = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(null);

        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Sign Up");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(330, 380, 50, 18);

        jLabel5.setBackground(new java.awt.Color(225, 225, 225));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("I don't have an account?");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(210, 380, 120, 14);

        jLabel1.setBackground(new java.awt.Color(225, 225, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 60, 170, 64);

        EmailFld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(EmailFld);
        EmailFld.setBounds(80, 180, 298, 25);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 220, 100, 16);

        PasswordFld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PasswordFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFldActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordFld);
        PasswordFld.setBounds(80, 250, 298, 25);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username/Email:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 150, 120, 16);

        jCheckBox1.setBackground(new java.awt.Color(51, 51, 51));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(80, 280, 120, 20);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.lightGray, null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(80, 320, 60, 20);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Untitled design (48).png"))); // NOI18N
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, -110, 870, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String EmailOrUserName, Password, query;
        String passDb = null, userType = null;
        String SUrl, SUser, SPass;

        int notFound = 0;
        int passMatch = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/fers", "root", "");
            Statement st = con.createStatement();

            if("".equals(PasswordFld.getText()) && "".equals(EmailFld.getText())){
                JOptionPane.showMessageDialog(this, "Please enter your Email and Password", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if ("".equals(EmailFld.getText())){
                JOptionPane.showMessageDialog(this, "Please enter your email", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if ("".equals(PasswordFld.getText())){
                JOptionPane.showMessageDialog(this, "Please enter your Password", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                EmailOrUserName = EmailFld.getText();
                Password = PasswordFld.getText();
                query = "SELECT * FROM fers_users WHERE email= '"+EmailOrUserName+"' OR full_name= '"+EmailOrUserName+"'";
                ResultSet rs = st.executeQuery(query);

                while(rs.next()){
                    passDb = rs.getString("password");
                    userType = rs.getString("user_type");
                    loggedInUserID = rs.getString("user_id");
                    notFound = 1;
                    if(Password.equals(passDb)){
                        passMatch = 1;
                    }
                }
                if(notFound == 1 && passMatch == 1){
                    if("Admin".equalsIgnoreCase(userType)){
                        Users loggedInUser = new Users(loggedInUserID, EmailOrUserName, passDb);
                        UserSession.setCurrentUser(loggedInUser);
                        AdminMainMenu amM = new AdminMainMenu();
                        amM.setVisible(true);
                        amM.pack();
                        amM.setLocationRelativeTo(null);
                        this.dispose();
                    }else if("Customer".equalsIgnoreCase(userType)){
                        Users loggedInUser = new Users(loggedInUserID, EmailOrUserName, passDb);
                        UserSession.setCurrentUser(loggedInUser);
                        CustomerMain cmM = new CustomerMain();
                        cmM.setVisible(true);
                        cmM.pack();
                        cmM.setLocationRelativeTo(null);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "User type not recognized", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    this.dispose();
                }else if(notFound == 1){
                    JOptionPane.showMessageDialog(this, "Incorrect Password", "Error", JOptionPane.WARNING_MESSAGE);
                }else if(passMatch == 1){
                    JOptionPane.showMessageDialog(this, "Incorrect Email/username", "Error", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Incorrect Email/username & Password", "Error", JOptionPane.WARNING_MESSAGE);
                }

                st.execute(query);
                PasswordFld.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage(), "Error Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SignUp sign = new SignUp();
        sign.setVisible(true);
        sign.pack();
        sign.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            PasswordFld.setEchoChar((char)0);
        }else{
            PasswordFld.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailFld;
    private javax.swing.JPasswordField PasswordFld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
