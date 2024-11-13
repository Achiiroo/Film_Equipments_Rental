
package com.mycompany.film_equipments_rental_v2;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelRight = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelLeft = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        PasswordTxt = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        PanelRight.setBackground(new java.awt.Color(153, 153, 153));
        PanelRight.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setBackground(new java.awt.Color(225, 225, 225));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Film Equipments Rental");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout PanelRightLayout = new javax.swing.GroupLayout(PanelRight);
        PanelRight.setLayout(PanelRightLayout);
        PanelRightLayout.setHorizontalGroup(
            PanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRightLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        PanelRightLayout.setVerticalGroup(
            PanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRightLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel2)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        jPanel1.add(PanelRight);
        PanelRight.setBounds(0, 0, 420, 500);

        PanelLeft.setBackground(new java.awt.Color(255, 255, 255));
        PanelLeft.setPreferredSize(new java.awt.Dimension(400, 500));

        Login.setBackground(new java.awt.Color(153, 153, 153));
        Login.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Login.setForeground(new java.awt.Color(102, 102, 102));
        Login.setText("LOGIN");

        UsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        UsernameLabel.setText("Username:");

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(0, 0, 0));
        PasswordLabel.setText("Password: ");

        UsernameTxt.setBackground(new java.awt.Color(255, 255, 255));
        UsernameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UsernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTxtActionPerformed(evt);
            }
        });

        PasswordTxt.setBackground(new java.awt.Color(255, 255, 255));
        PasswordTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PasswordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTxtActionPerformed(evt);
            }
        });

        LoginButton.setBackground(new java.awt.Color(153, 153, 153));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.setPreferredSize(new java.awt.Dimension(69, 25));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("i don't have an account");

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setForeground(new java.awt.Color(255, 102, 102));
        jToggleButton1.setText("Sign Up");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToggleButton1.setOpaque(true);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLeftLayout = new javax.swing.GroupLayout(PanelLeft);
        PanelLeft.setLayout(PanelLeftLayout);
        PanelLeftLayout.setHorizontalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLeftLayout.createSequentialGroup()
                .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLeftLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel)
                            .addComponent(UsernameLabel)
                            .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLeftLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelLeftLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(Login)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLeftLayout.setVerticalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLeftLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Login)
                .addGap(18, 18, 18)
                .addComponent(UsernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jToggleButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(PanelLeft);
        PanelLeft.setBounds(430, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("Film Equipments Rental");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTxtActionPerformed

    private void PasswordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTxtActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        SignUp sign = new SignUp();
        sign.setVisible(true);
        sign.pack();
        sign.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel PanelLeft;
    private javax.swing.JPanel PanelRight;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
