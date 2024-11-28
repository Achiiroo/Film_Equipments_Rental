/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminUI;

import Database.DatabaseConn;
import UI.Equipment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JTable;

public class ViewPaymentHistory extends javax.swing.JFrame {

    /**
     * Creates new form ViewPaymentHistory
     */
    public ViewPaymentHistory() {
        initComponents();
        loadPaymentHistory(PaymentTbl);
    }
private Equipment getSelectedItem() {
    int selectedRow = PaymentTbl.getSelectedRow();

    if (selectedRow >= 0) {
        TableModel model = PaymentTbl.getModel();
        
        int itemId = (Integer) model.getValueAt(selectedRow, 0);  
        String brand = (String) model.getValueAt(selectedRow, 1);  
        String modelValue = (String) model.getValueAt(selectedRow, 2);  

        return new Equipment(itemId, brand, modelValue);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
        return null; 
    }
}

        
            

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        SearchBarFld = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PaymentTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(976, 6, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(21, 25, 28));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 125));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BRBLogo.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 160, 90));

        SearchBarFld.setBackground(new java.awt.Color(102, 102, 102));
        SearchBarFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarFldKeyReleased(evt);
            }
        });
        jPanel3.add(SearchBarFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 450, -1));

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel3.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 100, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel3.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 70, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 90));

        PaymentTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PaymentID", "RentalID", "UserID", "Amount Paid", "Payment Date", "Payment Method", "Payment Status"
            }
        ));
        jScrollPane1.setViewportView(PaymentTbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1110, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private void loadPaymentHistory(JTable paymentHistoryTable) {
    String query = """
    SELECT DISTINCT payment_logs.id, payment_logs.fullname, 
           CONCAT(equipments.brand, ' ', equipments.model_num) AS item_name, 
           payment_logs.amount, payment_logs.payment_date, payment_logs.payment_method, 
           CASE 
               WHEN payment_logs.amount >= rentals.total_amount THEN 'Paid'
               ELSE 'Pending'
           END AS status
    FROM payment_logs
    JOIN rentals ON payment_logs.item_id = rentals.item_id
    JOIN equipments ON rentals.item_id = equipments.item_id
    """;

    try (Connection con = DatabaseConn.connect();
         PreparedStatement pst = con.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Payment Log ID");
        tableModel.addColumn("Full Name");
        tableModel.addColumn("Item (Brand + Model)");
        tableModel.addColumn("Amount Paid");
        tableModel.addColumn("Payment Date");
        tableModel.addColumn("Payment Method");
        tableModel.addColumn("Status");

        while (rs.next()) {
            Object[] rowData = new Object[7];

            rowData[0] = rs.getInt("id"); 
            rowData[1] = rs.getString("fullname"); 
            rowData[2] = rs.getString("item_name"); 
            rowData[3] = rs.getDouble("amount"); 
            rowData[4] = rs.getDate("payment_date"); 
            rowData[5] = rs.getString("payment_method"); 
            rowData[6] = rs.getString("status"); 
            tableModel.addRow(rowData);
        }
        paymentHistoryTable.setModel(tableModel);

        paymentHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        paymentHistoryTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        paymentHistoryTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        paymentHistoryTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        paymentHistoryTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        paymentHistoryTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        paymentHistoryTable.getColumnModel().getColumn(6).setPreferredWidth(100);

        for (int i = 0; i < paymentHistoryTable.getColumnCount(); i++) {
            paymentHistoryTable.getColumnModel().getColumn(i).setCellEditor(null);
        }

        paymentHistoryTable.getTableHeader().setReorderingAllowed(false);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading payment history: " + e.getMessage(),
                                      "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void SearchBarFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarFldKeyReleased
        searchbtnActionPerformed(null);

    }//GEN-LAST:event_SearchBarFldKeyReleased

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        DefaultTableModel ob = (DefaultTableModel) PaymentTbl.getModel();
        TableRowSorter <DefaultTableModel> obj = new TableRowSorter<>(ob);
        PaymentTbl.setRowSorter(obj);

        String searchKeyword = SearchBarFld.getText().trim();
        if (!searchKeyword.isEmpty()) {
            obj.setRowFilter(RowFilter.regexFilter("(?i)" + searchKeyword));
        } else {
            obj.setRowFilter(null);
        }

    }//GEN-LAST:event_searchbtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        AdminMainMenu AmM = new AdminMainMenu();
        AmM.setVisible(true);
        AmM.pack();
        AmM.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PaymentTbl;
    private javax.swing.JTextField SearchBarFld;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchbtn;
    // End of variables declaration//GEN-END:variables
}
