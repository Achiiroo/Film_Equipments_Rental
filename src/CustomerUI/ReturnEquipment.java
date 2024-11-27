package CustomerUI;

import UI.UserSession;
import AdminUI.AdminMainMenu;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class ReturnEquipment extends javax.swing.JFrame {
    public ReturnEquipment() {
        initComponents();
        loadEquipments();
    }

    
    private void loadEquipments() {
        String Category, Type, Brand, Model, RentPrice, Availability;
        int Quantity;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT Category, Equipment_Name, Brand, Model_Number, Rent_Price, Quantity, Availability "
                     + "FROM rental_equipments "
                     + "ORDER BY FIELD(Category, 'Camera', 'Lense', 'Lights', 'Sound')";

            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

            int colmn = rsmd.getColumnCount();
            String[] colmnName = new String[colmn];
            for (int i = 0; i < colmn; i++) {
                colmnName[i] = rsmd.getColumnName(i + 1);
            }

            DefaultTableModel model = (DefaultTableModel) EquipmentsTbl.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(colmnName);

            while (rs.next()) {
                Category = rs.getString("Category");
                Type = rs.getString("Equipment_Name");
                Brand = rs.getString("Brand");
                Model = rs.getString("Model_Number");
                RentPrice = rs.getString("Rent_Price");
                Quantity = rs.getInt("Quantity");
                Availability = rs.getString("Availability");

                String[] row = {Category, Type, Brand, Model, RentPrice, String.valueOf(Quantity), Availability};
                model.addRow(row);
            }

            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error Message", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SearchBarFld = new javax.swing.JTextField();
        CustomerAccBtn = new javax.swing.JLabel();
        searchbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        EquipmentsTbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Cameraslbl = new javax.swing.JPanel();
        CameraSrchBtn = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lensebtn = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lightsbtn = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        soundbtn = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        RentPricelbl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EquipmentNamelbl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Brandlbl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ModelLbl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        RentBtn1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        imagelbl = new javax.swing.JLabel();
        Returnbtn = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(21, 25, 28));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BRBLogo.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        SearchBarFld.setBackground(new java.awt.Color(102, 102, 102));
        SearchBarFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarFldKeyReleased(evt);
            }
        });

        CustomerAccBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/User Icon.png"))); // NOI18N

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(SearchBarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(CustomerAccBtn)
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
                .addComponent(SearchBarFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchbtn))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CustomerAccBtn)
                .addContainerGap())
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 1060, 80);

        jPanel3.setPreferredSize(new java.awt.Dimension(637, 1000));
        jPanel3.setLayout(new java.awt.BorderLayout());

        EquipmentsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rental_ID", "User_ID", "Item_ID", "Rent_Start", "Rent_End", "Return_Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EquipmentsTbl.setRequestFocusEnabled(false);
        EquipmentsTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipmentsTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(EquipmentsTbl);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel3);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(190, 80, 870, 260);

        jPanel2.setBackground(new java.awt.Color(255, 241, 241));

        Cameraslbl.setPreferredSize(new java.awt.Dimension(138, 92));
        Cameraslbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CameraslblMouseClicked(evt);
            }
        });
        Cameraslbl.setLayout(new java.awt.BorderLayout());

        CameraSrchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CAMERA.png"))); // NOI18N
        Cameraslbl.add(CameraSrchBtn, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(138, 92));
        jPanel6.setLayout(new java.awt.BorderLayout());

        lensebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CAMERA (1).png"))); // NOI18N
        lensebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lensebtnMouseClicked(evt);
            }
        });
        jPanel6.add(lensebtn, java.awt.BorderLayout.CENTER);

        jPanel7.setPreferredSize(new java.awt.Dimension(138, 92));
        jPanel7.setLayout(new java.awt.BorderLayout());

        lightsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CAMERA (2).png"))); // NOI18N
        lightsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lightsbtnMouseClicked(evt);
            }
        });
        jPanel7.add(lightsbtn, java.awt.BorderLayout.CENTER);

        jPanel8.setPreferredSize(new java.awt.Dimension(138, 92));
        jPanel8.setLayout(new java.awt.BorderLayout());

        soundbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CAMERA (3).png"))); // NOI18N
        soundbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soundbtnMouseClicked(evt);
            }
        });
        jPanel8.add(soundbtn, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cameraslbl, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cameraslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 90, 190, 490);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 100, -1));
        jPanel9.add(RentPricelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 240, -1));

        jLabel5.setText("Rent End:");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 100, -1));
        jPanel9.add(EquipmentNamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 240, -1));

        jLabel6.setText("Brand:");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 100, -1));
        jPanel9.add(Brandlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 240, -1));

        jLabel7.setText("Model:");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 100, -1));
        jPanel9.add(ModelLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 240, -1));

        jLabel8.setText("Rent Price:");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 100, -1));

        RentBtn1.setText("Rent");
        RentBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentBtn1ActionPerformed(evt);
            }
        });
        jPanel9.add(RentBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));
        jPanel9.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 150, -1));

        jLabel9.setText("Equipment Name:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, -1));

        jLabel10.setText("Rent Start:");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 100, -1));
        jPanel9.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 150, -1));

        imagelbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.add(imagelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 220));

        Returnbtn.setText("Return");
        Returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnbtnActionPerformed(evt);
            }
        });
        jPanel9.add(Returnbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        jPanel1.add(jPanel9);
        jPanel9.setBounds(190, 340, 870, 240);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CameraslblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CameraslblMouseClicked
        fetchEquipmentByCategory("Camera");
    }//GEN-LAST:event_CameraslblMouseClicked

    private void lensebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lensebtnMouseClicked
        fetchEquipmentByCategory("Lense");
    }//GEN-LAST:event_lensebtnMouseClicked

    private void lightsbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lightsbtnMouseClicked
        fetchEquipmentByCategory("Light");
    }//GEN-LAST:event_lightsbtnMouseClicked

    private void soundbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soundbtnMouseClicked
        fetchEquipmentByCategory("Sound");
    }//GEN-LAST:event_soundbtnMouseClicked

        
    
    private void EquipmentsTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipmentsTblMouseClicked
        int i = EquipmentsTbl.getSelectedRow();
       if (i >= 0) {
            TableModel model = EquipmentsTbl.getModel();
            EquipmentNamelbl.setText(model.getValueAt(i, 1).toString());
            Brandlbl.setText(model.getValueAt(i, 2).toString());       
            ModelLbl.setText(model.getValueAt(i, 3).toString());
            
            
            String rentPrice = model.getValueAt(i, 4).toString();
            RentPricelbl.setText(rentPrice);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row ", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_EquipmentsTblMouseClicked

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        DefaultTableModel ob = (DefaultTableModel) EquipmentsTbl.getModel();
        TableRowSorter <DefaultTableModel> obj = new TableRowSorter<>(ob);
        EquipmentsTbl.setRowSorter(obj);
        
        String searchKeyword = SearchBarFld.getText().trim();
        if (!searchKeyword.isEmpty()) {
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + searchKeyword)); 
        } else {
        obj.setRowFilter(null);
    }
        
    }//GEN-LAST:event_searchbtnActionPerformed

    private void SearchBarFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarFldKeyReleased
        searchbtnActionPerformed(null);
        
    }//GEN-LAST:event_SearchBarFldKeyReleased

    private void ReturnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnbtnActionPerformed
        
    }//GEN-LAST:event_ReturnbtnActionPerformed

    private void RentBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentBtn1ActionPerformed
        int selectedRow = EquipmentsTbl.getSelectedRow();

        if (selectedRow <= 0) {
            JOptionPane.showMessageDialog(this, "Please select an equipment first.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Retrieve selected equipment details
        String equipmentName = EquipmentsTbl.getValueAt(selectedRow, 1).toString(); // Equipment Name
        String availability = EquipmentsTbl.getValueAt(selectedRow, 6).toString(); // Availability
        String rentPrice = EquipmentsTbl.getValueAt(selectedRow, 4).toString(); // Rent Price
        int quantity = Integer.parseInt(EquipmentsTbl.getValueAt(selectedRow, 5).toString()); // Quantity

        if ("Rented".equalsIgnoreCase(availability) || quantity <= 0) {
            JOptionPane.showMessageDialog(this, "This equipment is not available for rent.", "Unavailable", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (jDateChooser2.getDate() == null || jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select both start and end dates.", "Date Missing", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            java.util.Date rentStartDate = jDateChooser2.getDate();
            java.util.Date rentEndDate = jDateChooser1.getDate();

            if (rentStartDate.after(rentEndDate)) {
                JOptionPane.showMessageDialog(this, "Start date cannot be after the end date.", "Invalid Date Range", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String rentStart = new SimpleDateFormat("yyyy-MM-dd").format(rentStartDate);
            String rentEnd = new SimpleDateFormat("yyyy-MM-dd").format(rentEndDate);

            double totalAmount = Double.parseDouble(rentPrice) * (rentEndDate.getTime() - rentStartDate.getTime()) / (1000 * 60 * 60 * 24);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");

            // Get equipment item_id
            String getItemQuery = "SELECT item_id FROM rental_equipments WHERE equipment_name = ?";
            var pstGetId = con.prepareStatement(getItemQuery);
            pstGetId.setString(1, equipmentName);
            ResultSet rs = pstGetId.executeQuery();

            if (rs.next()) {
                int itemId = rs.getInt("item_id");

                // Insert rental details into user_rentals table
                String insertQuery = "INSERT INTO user_rentals (item_id, user_id, rent_start, rent_end, total_amount, status) VALUES (?, ?, ?, ?, ?, ?)";
                var pstInsert = con.prepareStatement(insertQuery);
                pstInsert.setInt(1, itemId);
                pstInsert.setString(2, UserSession.getCurrentUserID()); // Ensure currentUserId is set during login
                pstInsert.setString(3, rentStart);
                pstInsert.setString(4, rentEnd);
                pstInsert.setDouble(5, totalAmount);
                pstInsert.setString(6, "Rented");

                int rowsInserted = pstInsert.executeUpdate();

                if (rowsInserted > 0) {
                    // Update equipment quantity
                    String updateQuery = "UPDATE rental_equipments SET quantity = quantity - 1 WHERE item_id = ?";
                    var pstUpdate = con.prepareStatement(updateQuery);
                    pstUpdate.setInt(1, itemId);
                    pstUpdate.executeUpdate();

                    // Update UI
                    EquipmentsTbl.setValueAt(quantity - 1, selectedRow, 5);
                    if (quantity - 1 == 0) {
                        EquipmentsTbl.setValueAt("Rented", selectedRow, 6);
                    }

                    JOptionPane.showMessageDialog(this, "Equipment rented successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to rent the equipment. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Equipment not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Close connections
            pstGetId.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RentBtn1ActionPerformed
    

    
    private void login(String username, String password) {
        // Fetch the user ID from the database
        int user_id = getUserId(username, password);

        if (user_id > 0) {  // Valid user ID (user found in the database)
            currentUserId = user_id;  // Assign the user ID to currentUserId
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } else {  // Invalid credentials
            currentUserId = user_id;  // Reset currentUserId
            JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int currentUserId;
    
    private int getUserId(String username, String password) {
        
    // Database connection and query execution
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");
         PreparedStatement pst = con.prepareStatement(
            "SELECT user_id FROM fers_users WHERE (full_name = ? OR email = ?) AND password = ?")){

        // Set the parameters for the query
        pst.setString(1, username);
        pst.setString(2, username);
        pst.setString(3, password);

        // Execute the query
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                currentUserId = rs.getInt("user_id");  // Retrieve user ID
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return currentUserId;  // Return the user ID (or -1 if not found)
}


    private boolean rentEquipment(String item_id, String rentPrice, int user_id) {
    
    Connection con = null;
    Statement stmtUpdate = null;
    Statement stmtInsert = null;
    boolean success = false;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");
        con.setAutoCommit(false);
        String updateQuery = "UPDATE rental_equipments SET availability = 'Rented' WHERE item_id = ?";
        stmtUpdate = con.prepareStatement(updateQuery); 
        int rowsUpdated = stmtUpdate.executeUpdate(updateQuery);

        if (rowsUpdated > 0) {
            String rent_id = java.util.UUID.randomUUID().toString();
             String insertQuery = "INSERT INTO user_rentals (rent_id, user_id, item_id, rent_price, rental_date) VALUES (?, ?, ?, ?, NOW())";
            stmtInsert = con.prepareStatement(insertQuery);

            int rowsInserted = stmtInsert.executeUpdate(insertQuery);

            if (rowsInserted > 0) {
                success = true; 
                con.commit();
            } else {
                con.rollback();
            }
        } else {
            con.rollback();
        }
    } catch (Exception e) {
        e.printStackTrace(); 
        try {
            if (con != null) {
                con.rollback();
            }
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
    } finally {
        try {
            if (stmtUpdate != null) stmtUpdate.close();
           
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return success;
}

private boolean updateAvailabilityInfers(int item_id, String newAvailability) {
    String query = "UPDATE rental_equipments SET Availability = ? WHERE item_id = ?";

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");
        Statement stmt = conn.createStatement()){

        int rowsAffected = stmt.executeUpdate(query);

        return rowsAffected > 0; 
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

private String fetchRentPrice(String item_id) {
    String rentPrice = ""; 
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");

        String query = "SELECT Rent_Price FROM rental_equipments WHERE item_id = '" + item_id + "'";
        st = con.createStatement();
        rs = st.executeQuery(query);

        if (rs.next()) {
            rentPrice = rs.getString("Rent_Price"); 
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return rentPrice; 
}

private void fetchEquipmentByCategory(String category) {
    String Category, Type, Brand, Model, RentPrice, Availability;
    int Quantity;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fers", "root", "");
        Statement st = con.createStatement();

        String query = "SELECT Category, Equipment_Name, Brand, Model_Number, Rent_Price, Quantity, Availability " +
                       "FROM rental_equipments WHERE Category = '" + category + "'";

        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

        int colmn = rsmd.getColumnCount();
        String[] colmnName = new String[colmn];
        for (int i = 0; i < colmn; i++) {
            colmnName[i] = rsmd.getColumnName(i + 1);
        }

        DefaultTableModel model = (DefaultTableModel) EquipmentsTbl.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(colmnName); 

        while (rs.next()) {
            Category = rs.getString("Category");
            Type = rs.getString("Equipment_Name");
            Brand = rs.getString("Brand");
            Model = rs.getString("Model_Number");
            RentPrice = rs.getString("Rent_Price");
            Quantity = rs.getInt("Quantity");
            Availability = rs.getString("Availability");

            String[] row = {Category, Type, Brand, Model, RentPrice, String.valueOf(Quantity), Availability};
            model.addRow(row);
        }

        st.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error Message", JOptionPane.WARNING_MESSAGE);
    }
}
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
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnEquipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Brandlbl;
    private javax.swing.JLabel CameraSrchBtn;
    private javax.swing.JPanel Cameraslbl;
    private javax.swing.JLabel CustomerAccBtn;
    private javax.swing.JTextField EquipmentNamelbl;
    private javax.swing.JTable EquipmentsTbl;
    private javax.swing.JTextField ModelLbl;
    private javax.swing.JButton RentBtn1;
    private javax.swing.JTextField RentPricelbl;
    private javax.swing.JButton Returnbtn;
    private javax.swing.JTextField SearchBarFld;
    private javax.swing.JLabel imagelbl;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lensebtn;
    private javax.swing.JLabel lightsbtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JLabel soundbtn;
    // End of variables declaration//GEN-END:variables
}
