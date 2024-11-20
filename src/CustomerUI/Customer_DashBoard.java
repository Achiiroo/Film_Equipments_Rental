/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CustomerUI;

import java.awt.Color;

/**
 *
 * @author Aple Shane
 */
public class Customer_DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form Customer_DashBoard
     */
    public Customer_DashBoard() {
        initComponents();
        
        
        btnFilmEquipment.setBackground(Color.white);
        btn_home.setBackground(Color.RED);
        btnreturn.setBackground(Color.white);
        btnview.setBackground(Color.white);
        
        
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelcamera = new javax.swing.JPanel();
        panellense = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFilmEquipment = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btnreturn = new javax.swing.JButton();
        btnview = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        panelcamera.setBackground(new java.awt.Color(21, 25, 28));
        panelcamera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panellense.setBackground(new java.awt.Color(21, 25, 28));
        panellense.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Aple Shane\\OOP_GITv2\\SemestralProject\\src\\CustomerUI\\Black and White Circle Business Logo (2).png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -280, 226, 480));

        btnFilmEquipment.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btnFilmEquipment.setText("BOOK EQUIPMENT");
        btnFilmEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFilmEquipmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFilmEquipmentMouseExited(evt);
            }
        });
        btnFilmEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilmEquipmentActionPerformed(evt);
            }
        });
        jPanel1.add(btnFilmEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 230, 70));

        btn_home.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btn_home.setText("HOME");
        btn_home.setPreferredSize(new java.awt.Dimension(172, 33));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });
        jPanel1.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 230, 70));

        btnreturn.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btnreturn.setText("RETURN ");
        btnreturn.setPreferredSize(new java.awt.Dimension(172, 33));
        btnreturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnreturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnreturnMouseExited(evt);
            }
        });
        btnreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreturnActionPerformed(evt);
            }
        });
        jPanel1.add(btnreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 230, 70));

        btnview.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btnview.setText("VIEW RENTAL");
        btnview.setPreferredSize(new java.awt.Dimension(172, 33));
        btnview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnviewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnviewMouseExited(evt);
            }
        });
        btnview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewActionPerformed(evt);
            }
        });
        jPanel1.add(btnview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 230, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        jPanel3.setBackground(new java.awt.Color(42, 40, 44));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your Film, Our Equipment:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 590, 220));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rent the Best in BSIT_2102");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 560, 140));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1310, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilmEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilmEquipmentActionPerformed
        btnBook_Equipment MainMenu = new btnBook_Equipment();
        MainMenu.setVisible(true);
        MainMenu.pack();
        MainMenu.setLocationRelativeTo(null);
        this.dispose();
       
        
    }//GEN-LAST:event_btnFilmEquipmentActionPerformed

    private void btnFilmEquipmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilmEquipmentMouseExited
        btnFilmEquipment.setBackground(Color.white);
    }//GEN-LAST:event_btnFilmEquipmentMouseExited

    private void btnFilmEquipmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilmEquipmentMouseEntered
        btnFilmEquipment.setBackground(Color.RED);
    }//GEN-LAST:event_btnFilmEquipmentMouseEntered

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        btn_home.setBackground(Color.RED);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        btn_home.setBackground(Color.white);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btnreturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreturnMouseEntered
        btnreturn.setBackground(Color.RED);
    }//GEN-LAST:event_btnreturnMouseEntered

    private void btnreturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreturnMouseExited
       btnreturn.setBackground(Color.white);
    }//GEN-LAST:event_btnreturnMouseExited

    private void btnviewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewMouseEntered
        btnview.setBackground(Color.RED);
    }//GEN-LAST:event_btnviewMouseEntered

    private void btnviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewMouseExited
        btnview.setBackground(Color.white);
    }//GEN-LAST:event_btnviewMouseExited

    private void btnreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreturnActionPerformed
        return_equipment MainMenu = new return_equipment();
        MainMenu.setVisible(true);
        MainMenu.pack();
        MainMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnreturnActionPerformed

    private void btnviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewActionPerformed
        view_rental MainMenu = new view_rental();
        MainMenu.setVisible(true);
        MainMenu.pack();
        MainMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnviewActionPerformed

  
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
            java.util.logging.Logger.getLogger(Customer_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilmEquipment;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btnreturn;
    private javax.swing.JButton btnview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelcamera;
    private javax.swing.JPanel panellense;
    // End of variables declaration//GEN-END:variables
}
