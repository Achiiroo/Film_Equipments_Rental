/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminUI;

import Database.DatabaseConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author dave
 */
public class DeleteHistory extends javax.swing.JFrame {


    public DeleteHistory() {
        initComponents();
        loadUpdateLogs(deleteTbl);
    }
private void loadUpdateLogs(JTable deleteTbl) { 
    String query = "SELECT item_id, category, brand, model_num, rent_price, quantity, removed_at FROM removed_equipments";    
    
    try (Connection con = DatabaseConn.connect(); 
         PreparedStatement pst = con.prepareStatement(query); 
         ResultSet rs = pst.executeQuery()) {
       
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        DefaultTableModel tableModel = new DefaultTableModel();

        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(metaData.getColumnName(i));
        }

        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(rowData);
        }

        deleteTbl.setModel(tableModel);

        deleteTbl.getColumnModel().getColumn(0).setPreferredWidth(40);  
        deleteTbl.getColumnModel().getColumn(1).setPreferredWidth(90); 
        deleteTbl.getColumnModel().getColumn(2).setPreferredWidth(100); 
        deleteTbl.getColumnModel().getColumn(3).setPreferredWidth(90);
        deleteTbl.getColumnModel().getColumn(4).setPreferredWidth(90);
        deleteTbl.getColumnModel().getColumn(5).setPreferredWidth(80);  
        deleteTbl.getColumnModel().getColumn(6).setPreferredWidth(100); 

        for (int i = 0; i < columnCount; i++) {
            deleteTbl.getColumnModel().getColumn(i).setCellEditor(null);
        }

        deleteTbl.getTableHeader().setReorderingAllowed(false);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        updatelogsTbl = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        searchFld = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deleteTbl = new javax.swing.JTable();

        updatelogsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Brand", "Model Number", "Rent Price", "Quantity", "Status", "Updated time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        updatelogsTbl.setEnabled(false);
        jScrollPane2.setViewportView(updatelogsTbl);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 430));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 430));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(21, 25, 28));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BRBLogo.png"))); // NOI18N

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        searchFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFldActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn)
                    .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 90);

        jPanel3.setLayout(new java.awt.BorderLayout());

        deleteTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Brand", "Model Number", "Rent Price", "Quantity", "Removed at"
            }
        ));
        jScrollPane1.setViewportView(deleteTbl);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 90, 800, 340);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        AdminMainMenu AmM = new AdminMainMenu();
        AmM.setVisible(true);
        AmM.pack();
        AmM.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        DefaultTableModel ob = (DefaultTableModel) deleteTbl.getModel();
        TableRowSorter <DefaultTableModel> obj = new TableRowSorter<>(ob);
        deleteTbl.setRowSorter(obj);
        
        String searchKeyword = searchFld.getText().trim();
        if (!searchKeyword.isEmpty()) {
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + searchKeyword)); 
        } else {
        obj.setRowFilter(null);
        }    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFldActionPerformed

    }//GEN-LAST:event_searchFldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTable deleteTbl;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JTable updatelogsTbl;
    // End of variables declaration//GEN-END:variables
}
