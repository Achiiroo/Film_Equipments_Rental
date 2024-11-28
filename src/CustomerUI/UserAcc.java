/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CustomerUI;

import Database.DatabaseConn;
import UI.UserSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserAcc extends javax.swing.JFrame {

    /**
     * Creates new form UserAcc
     */
    public UserAcc() {
        initComponents();
        loadUserRents(UserRentals);
    }

private void loadUserRents(JTable userRentsTable) {
    String query = """
        SELECT rentals.item_id, equipments.category, equipments.brand, equipments.model_num, 
               rentals.rent_start, rentals.rent_end, rentals.quantity, rentals.total_amount, rentals.status,
               COALESCE(SUM(payment_logs.amount), 0) AS total_paid
        FROM rentals
        JOIN equipments ON rentals.item_id = equipments.item_id
        LEFT JOIN payment_logs ON rentals.item_id = payment_logs.item_id
        WHERE rentals.user_id = ?
        GROUP BY rentals.item_id, equipments.category, equipments.brand, equipments.model_num,
                 rentals.rent_start, rentals.rent_end, rentals.quantity, rentals.total_amount, rentals.status
        """;

    try (Connection con = DatabaseConn.connect();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, UserSession.getCurrentUserID());

        try (ResultSet rs = pst.executeQuery()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            tableModel.addColumn("Item ID");
            tableModel.addColumn("Category");
            tableModel.addColumn("Brand");
            tableModel.addColumn("Model");
            tableModel.addColumn("Rent Start");
            tableModel.addColumn("Rent End");
            tableModel.addColumn("Quantity");
            tableModel.addColumn("Total Amount");
            tableModel.addColumn("Total Paid");
            tableModel.addColumn("Payment Status");

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];

                int itemId = rs.getInt("item_id");
                String category = rs.getString("category");
                String brand = rs.getString("brand");
                String model = rs.getString("model_num");
                Date rentStart = rs.getDate("rent_start");
                Date rentEnd = rs.getDate("rent_end");
                int quantity = rs.getInt("quantity");
                double totalAmount = rs.getDouble("total_amount");
                double totalPaid = rs.getDouble("total_paid");
                String status = totalPaid >= totalAmount ? "Paid" : "Pending";

                rowData[0] = itemId;
                rowData[1] = category;
                rowData[2] = brand;
                rowData[3] = model;
                rowData[4] = rentStart;
                rowData[5] = rentEnd;
                rowData[6] = quantity;
                rowData[7] = totalAmount;
                rowData[8] = totalPaid;
                rowData[9] = status;

                tableModel.addRow(rowData);
                
                if (status.equals("Paid")) {
                    updateRentalStatus(itemId, "Paid");
                } else {
                    updateRentalStatus(itemId, "Pending");
                }
            }

            userRentsTable.setModel(tableModel);
            userRentsTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            userRentsTable.getColumnModel().getColumn(1).setPreferredWidth(90);
            userRentsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            userRentsTable.getColumnModel().getColumn(3).setPreferredWidth(90);
            userRentsTable.getColumnModel().getColumn(4).setPreferredWidth(90);
            userRentsTable.getColumnModel().getColumn(5).setPreferredWidth(90);
            userRentsTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            userRentsTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            userRentsTable.getColumnModel().getColumn(8).setPreferredWidth(100);
            userRentsTable.getColumnModel().getColumn(9).setPreferredWidth(120);

            for (int i = 0; i < columnCount; i++) {
                userRentsTable.getColumnModel().getColumn(i).setCellEditor(null);
            }

            userRentsTable.getTableHeader().setReorderingAllowed(false);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading rental data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
private void updateRentalStatus(int itemId, String status) {
    try (Connection con = DatabaseConn.connect()) {
        String updateQuery = "UPDATE rentals SET status = ? WHERE item_id = ?";
        try (PreparedStatement pstUpdate = con.prepareStatement(updateQuery)) {
            pstUpdate.setString(1, status);
            pstUpdate.setInt(2, itemId);
            pstUpdate.executeUpdate();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error updating rental status: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
private int getSelectedItemId() {
    int selectedRow = UserRentals.getSelectedRow();
    if (selectedRow >= 0) {
        return (int) UserRentals.getValueAt(selectedRow, 0);
    }
    return -1;
}
private double getTotalAmountForItem() {
    double totalAmount = 0.0;
    String query = "SELECT total_amount FROM rentals WHERE item_id = ?";

    try (Connection con = DatabaseConn.connect();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setInt(1, getSelectedItemId());

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                totalAmount = rs.getDouble("total_amount");
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error retrieving total amount: " + e.getMessage(),
                                      "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    return totalAmount;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserRentals = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        FullnameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PaymentAmountFld = new javax.swing.JTextField();
        CashRdBtn = new javax.swing.JRadioButton();
        CardRdBtn = new javax.swing.JRadioButton();
        CardNumFld = new javax.swing.JLabel();
        CardnumFld = new javax.swing.JTextField();
        CardNumFld1 = new javax.swing.JLabel();
        CardExpiryFld = new javax.swing.JTextField();
        CardNumFld2 = new javax.swing.JLabel();
        CVVFld = new javax.swing.JTextField();
        Paybtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jPanel2.setBackground(new java.awt.Color(21, 25, 28));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BRBLogo.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        BackBtn.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackBtn)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
                .addComponent(BackBtn))
        );

        jPanel3.setLayout(new java.awt.BorderLayout());

        UserRentals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(UserRentals);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Full Name");

        jLabel1.setText("Payment Amount");

        CashRdBtn.setText("Cash");
        CashRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashRdBtnActionPerformed(evt);
            }
        });

        CardRdBtn.setText("Credit Card");
        CardRdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardRdBtnActionPerformed(evt);
            }
        });

        CardNumFld.setText("Card Number");

        CardnumFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardnumFldActionPerformed(evt);
            }
        });

        CardNumFld1.setText("Expiry Date");

        CardExpiryFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardExpiryFldActionPerformed(evt);
            }
        });

        CardNumFld2.setText("CVV");

        CVVFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVVFldActionPerformed(evt);
            }
        });

        Paybtn.setText("Pay Now");
        Paybtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaybtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PaymentAmountFld)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CashRdBtn)
                        .addGap(35, 35, 35)
                        .addComponent(CardRdBtn))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(CardNumFld)
                    .addComponent(FullnameFld)
                    .addComponent(CardnumFld)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CardExpiryFld, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CardNumFld1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CardNumFld2)
                            .addComponent(CVVFld, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Paybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FullnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaymentAmountFld, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CashRdBtn)
                            .addComponent(CardRdBtn))
                        .addGap(18, 18, 18)
                        .addComponent(CardNumFld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardnumFld, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CardNumFld1)
                            .addComponent(CardNumFld2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CardExpiryFld, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CVVFld, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Paybtn)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CardRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardRdBtnActionPerformed
        CardnumFld.setEnabled(true);
        CardExpiryFld.setEnabled(true);
        CVVFld.setEnabled(true);
    }//GEN-LAST:event_CardRdBtnActionPerformed

    private void PaybtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaybtnMouseClicked
            String fullName = FullnameFld.getText(); 
            String paymentAmount = PaymentAmountFld.getText(); 

            if (fullName.isEmpty() || paymentAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in your full name and payment amount.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(paymentAmount);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double totalAmount = getTotalAmountForItem();
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "The payment amount must be greater than zero.", "Invalid Amount", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (amount > totalAmount) {
                JOptionPane.showMessageDialog(this, "The payment amount cannot exceed the total amount.", "Amount Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int selectedItemId = getSelectedItemId(); 

            if (selectedItemId == -1) {
                JOptionPane.showMessageDialog(this, "Please select a valid item.", "Item Selection Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!CashRdBtn.isSelected() && !CardRdBtn.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select a payment method (Cash or Card).", "Payment Method Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (CashRdBtn.isSelected()) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to pay " + amount + " in cash?", "Confirm Payment", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try (Connection con = DatabaseConn.connect()) {
                        String insertQuery = "INSERT INTO payment_logs (item_id, fullname, amount, payment_date, payment_method) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                            pst.setInt(1, selectedItemId);
                            pst.setString(2, fullName);
                            pst.setDouble(3, amount);
                            pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                            pst.setString(5, "Cash");

                            int rowsInserted = pst.executeUpdate();
                            if (rowsInserted > 0) {
                                JOptionPane.showMessageDialog(this, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                loadUserRents(UserRentals);
                            } else {
                                JOptionPane.showMessageDialog(this, "Payment failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error updating payment logs: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            else if (CardRdBtn.isSelected()) {
                String cardNumber = CardnumFld.getText();
                String expiryDate = CardExpiryFld.getText();
                String cvv = CVVFld.getText();

                if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter all the card details.", "Card Information Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (cardNumber.length() != 16 || expiryDate.length() != 5 || cvv.length() != 3) {
                    JOptionPane.showMessageDialog(this, "Please enter valid card details.", "Card Information Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to pay " + amount + " using the provided card?", "Confirm Payment", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try (Connection con = DatabaseConn.connect()) {
                        String insertQuery = "INSERT INTO payment_logs (item_id, fullname, amount, payment_date, payment_method, card_number, expiry_date, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                            pst.setInt(1, selectedItemId); 
                            pst.setString(2, fullName);
                            pst.setDouble(3, amount);
                            pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                            pst.setString(5, "Card");
                            pst.setString(6, cardNumber);
                            pst.setString(7, expiryDate);
                            pst.setString(8, cvv);

                            int rowsInserted = pst.executeUpdate();
                            if (rowsInserted > 0) {
                                JOptionPane.showMessageDialog(this, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Payment failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error updating payment logs: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
    }//GEN-LAST:event_PaybtnMouseClicked

    private void CashRdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashRdBtnActionPerformed
        CardnumFld.setEnabled(false);
        CardExpiryFld.setEnabled(false);
        CVVFld.setEnabled(false);
    }//GEN-LAST:event_CashRdBtnActionPerformed

    private void CardnumFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardnumFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CardnumFldActionPerformed

    private void CardExpiryFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardExpiryFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CardExpiryFldActionPerformed

    private void CVVFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVVFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CVVFldActionPerformed

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
            java.util.logging.Logger.getLogger(UserAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTextField CVVFld;
    private javax.swing.JTextField CardExpiryFld;
    private javax.swing.JLabel CardNumFld;
    private javax.swing.JLabel CardNumFld1;
    private javax.swing.JLabel CardNumFld2;
    private javax.swing.JRadioButton CardRdBtn;
    private javax.swing.JTextField CardnumFld;
    private javax.swing.JRadioButton CashRdBtn;
    private javax.swing.JTextField FullnameFld;
    private javax.swing.JButton Paybtn;
    private javax.swing.JTextField PaymentAmountFld;
    private javax.swing.JTable UserRentals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
