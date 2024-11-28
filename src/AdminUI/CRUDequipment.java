package AdminUI;

import Database.DatabaseConn;
import java.sql.*;
import javax.swing.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CRUDequipment extends javax.swing.JFrame {

    String ImagePath = null;
    /**
     * Creates new form AddEquipment
     */
    
    public CRUDequipment() {
        initComponents();
        populateTable(EquipmentTbl);
        setVisible(true);
        setLocationRelativeTo(null);
        this.dispose();
    }

    public ImageIcon ResizeImage(String imgPath, byte[] pic) {
        ImageIcon myImage = null;

        if (imgPath != null) {
            myImage = new ImageIcon(imgPath);
        } else if (pic != null) {
            myImage = new ImageIcon(pic);
        }

        if (myImage != null) {
            Image img = myImage.getImage();
            int width = imagelbl.getWidth(); 
            int height = imagelbl.getHeight();

            if (width > 0 && height > 0) {
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            }
        }
        return myImage;
    }
    public boolean checkInputs(){
        try {
            return !(CategoryLbl.getText().isEmpty() ||
                     BrandLbl.getText().isEmpty() ||
                     ModelNumLbl.getText().isEmpty() ||
                     RentPriceLbl.getText().isEmpty()) &&
                   Float.parseFloat(RentPriceLbl.getText()) > 0;
        } catch (Exception e) {
            return false;
        }
    }
    private double validateRentPrice() {
    try {
        String rentPriceText = RentPriceLbl.getText().trim();
        double rentPrice = Double.parseDouble(rentPriceText);
        if (rentPrice < 0) {
            JOptionPane.showMessageDialog(null, "Rent price must be a non-negative number.");
            return -1;
        } else if (rentPrice <= 999) {
            JOptionPane.showMessageDialog(null, "Rent price must be at least 1000.");
            return -1;
        }
        return rentPrice;
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid rent price. Please enter a valid number.");
        return -1;
    }
}
    private int getNextEquipmentID(Connection con) throws SQLException {
    String query = "SELECT MAX(item_id) FROM equipments";
    try (PreparedStatement pst = con.prepareStatement(query); 
         ResultSet rs = pst.executeQuery()) {
        
        if (rs.next()) {
            int maxID = rs.getInt(1);
            return maxID + 1; 
        } else {
            return 1; 
        }
    }
}
    private int validateEquipmentID() {
    try {
        String input = EquipmentIDLbl.getText().trim();
        if (input.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(input);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Equipment ID. Setting to default (1).");
        return 1;
    }
}
    private int validateQuantity() {
    try {
        String quantityText = quantityLbl.getText().trim();
        int quantity = Integer.parseInt(quantityText);
        if (quantity < 0) {
            JOptionPane.showMessageDialog(null, "Quantity must be a non-negative integer.");
            return -1;
        }
        return quantity;
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a valid number.");
        return -1;
    }
}
    private void populateTable(JTable EquipmentsTbl) {
    String query = "SELECT item_id, category, brand, model_num, status, rent_price, Quantity FROM equipments";

    try (Connection con = DatabaseConn.connect();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        DefaultTableModel model = new DefaultTableModel();

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnLabel(i));
        }
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }

        EquipmentsTbl.setModel(model);
        
        for (int i = 0; i < columnCount; i++) {
            EquipmentsTbl.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        EquipmentsTbl.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        EquipmentsTbl.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void loadImageForEquipment(String itemId) {
    String loadImageQuery = "SELECT image FROM equipments WHERE equipments.item_id = ?"; // Replace 'image_column' with your actual image column name

    try (Connection con = DatabaseConn.connect();
         PreparedStatement pstmt = con.prepareStatement(loadImageQuery)) {
        
        pstmt.setString(1, itemId);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            byte[] imgBytes = rs.getBytes("image");
            if (imgBytes != null) {
                ImageIcon imageIcon = new ImageIcon(imgBytes);
                Image img = imageIcon.getImage().getScaledInstance(imagelbl.getWidth(), imagelbl.getHeight(), Image.SCALE_SMOOTH);
                imagelbl.setIcon(new ImageIcon(img));
            } else {
                imagelbl.setIcon(null);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void clearFields() {
    EquipmentIDLbl.setText("");
    CategoryLbl.setText("");
    BrandLbl.setText("");
    ModelNumLbl.setText("");
    quantityLbl.setText("");
    RentPriceLbl.setText("");
    StatusCmbBx.setSelectedIndex(-1);
    imagelbl.setIcon(null);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CategoryLbl = new javax.swing.JTextField();
        BrandLbl = new javax.swing.JTextField();
        ModelNumLbl = new javax.swing.JTextField();
        CancelBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        RentPriceLbl = new javax.swing.JTextField();
        imagechooserbtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        imagelbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EquipmentIDLbl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantityLbl = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        EquipmentTbl = new javax.swing.JTable();
        StatusCmbBx = new javax.swing.JComboBox<>();
        UpdateLogs = new javax.swing.JButton();
        DeleteHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 450));
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 300));
        jPanel5.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel1.setText("Category");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel3.setText("Brand");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setText("Model Number");

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel7.setText("Rent Price");

        imagechooserbtn.setText("Choose Image");
        imagechooserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagechooserbtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        imagelbl.setBackground(new java.awt.Color(255, 255, 232));
        imagelbl.setForeground(new java.awt.Color(255, 255, 204));
        imagelbl.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel2.setText("Equipment ID");

        EquipmentIDLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipmentIDLblActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel8.setText("Status");

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        quantityLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityLblActionPerformed(evt);
            }
        });

        EquipmentTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Eid", "Category", "Brand", "Model Number", "Rent Price", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EquipmentTbl.getTableHeader().setReorderingAllowed(false);
        EquipmentTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipmentTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(EquipmentTbl);

        StatusCmbBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available", " " }));
        StatusCmbBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusCmbBxActionPerformed(evt);
            }
        });

        UpdateLogs.setText("View Update History");
        UpdateLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateLogsActionPerformed(evt);
            }
        });

        DeleteHistory.setText("View Delete History");
        DeleteHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imagechooserbtn)
                            .addComponent(addBtn))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(UpdateBtn)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(CancelBtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(imagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ModelNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BrandLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CategoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(EquipmentIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RentPriceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StatusCmbBx, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(UpdateLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(DeleteHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(EquipmentIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(quantityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BrandLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModelNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(RentPriceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(StatusCmbBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imagechooserbtn)
                            .addComponent(imagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(CancelBtn)
                    .addComponent(UpdateBtn)
                    .addComponent(DeleteBtn))
                .addGap(65, 65, 65))
        );

        jPanel5.add(jPanel2);
        jPanel2.setBounds(0, 0, 970, 470);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 950, 450);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if (checkInputs() && ImagePath != null) {
            try (Connection con = DatabaseConn.connect();
                 InputStream img = new FileInputStream(new File(ImagePath))) {

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO equipments(item_id, category, brand, model_num, rent_price, Quantity, status, image) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                );

                int equipmentID = -1; 
                String equipmentIDInput = EquipmentIDLbl.getText().trim(); 

                if (!equipmentIDInput.isEmpty()) {
                    equipmentID = Integer.parseInt(equipmentIDInput);
                } else {
                    equipmentID = getNextEquipmentID(con);
                }

                ps.setInt(1, equipmentID);
                ps.setString(2, CategoryLbl.getText().trim());
                ps.setString(3, BrandLbl.getText().trim());
                ps.setString(4, ModelNumLbl.getText().trim());

                double rentPrice = validateRentPrice();
                if (rentPrice < 0) return;
                ps.setDouble(5, rentPrice);

                int quantity = validateQuantity();
                if (quantity < 0) return;
                ps.setInt(6, quantity);
                ps.setString(7, StatusCmbBx.getSelectedItem().toString());
                ps.setBlob(8, img);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Equipment Added Successfully!");
                populateTable(EquipmentTbl);

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Image file not found: " + e.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        AdminMainMenu AmM = new AdminMainMenu();
        AmM.setVisible(true);
        AmM.pack();
        AmM.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void imagechooserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagechooserbtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imagelbl.setIcon(ResizeImage(ImagePath, null));
            ImagePath = path;
        } else {
            JOptionPane.showMessageDialog(null, "No file selected.");
        }

    }//GEN-LAST:event_imagechooserbtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        if (checkInputs()) {
        Connection con = DatabaseConn.connect();
        PreparedStatement ps = null;
        InputStream img = null; // For image file if needed
        try {
            if (con != null) {
                String fetchQuery = "SELECT * FROM equipments WHERE item_id = ?";
                String insertLogQuery = "INSERT INTO update_logs (item_id, category, brand, model_num, rent_price, quantity, status, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                String updateQuery;

                String itemIdText = EquipmentIDLbl.getText().trim();
                int itemId;
                try {
                    itemId = Integer.parseInt(itemIdText);
                    if (itemId <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid Equipment ID.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Equipment ID. Please enter a valid number.");
                    return;
                }

                // Fetch current equipment details
                ps = con.prepareStatement(fetchQuery);
                ps.setInt(1, itemId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    // Log the current details
                    try (PreparedStatement logPs = con.prepareStatement(insertLogQuery)) {
                        logPs.setInt(1, rs.getInt("item_id"));
                        logPs.setString(2, rs.getString("category"));
                        logPs.setString(3, rs.getString("brand"));
                        logPs.setString(4, rs.getString("model_num"));
                        logPs.setDouble(5, rs.getDouble("rent_price"));
                        logPs.setInt(6, rs.getInt("quantity"));
                        logPs.setString(7, rs.getString("status"));
                        logPs.setBlob(8, rs.getBlob("image"));
                        logPs.executeUpdate();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No equipment found with the specified ID.");
                    return;
                }

                // Prepare Update query based on whether the image is being updated or not
                if (ImagePath == null) {  // No image change
                    updateQuery = "UPDATE equipments SET category = ?, brand = ?, model_num = ?, rent_price = ?, Quantity = ?, status = ? WHERE item_id = ?";
                    ps = con.prepareStatement(updateQuery);
                    ps.setString(1, CategoryLbl.getText().trim());
                    ps.setString(2, BrandLbl.getText().trim());
                    ps.setString(3, ModelNumLbl.getText().trim());

                    double rentPrice = validateRentPrice();
                    if (rentPrice < 0) return;
                    ps.setDouble(4, rentPrice);

                    int quantity = validateQuantity();
                    if (quantity < 0) return;
                    ps.setInt(5, quantity);

                    ps.setString(6, StatusCmbBx.getSelectedItem().toString());  // Use ComboBox value
                    ps.setInt(7, itemId);  // Use the item ID

                } else {  // Image change
                    img = new FileInputStream(new File(ImagePath));

                    updateQuery = "UPDATE equipments SET category = ?, brand = ?, model_num = ?, rent_price = ?, Quantity = ?, status = ?, image = ? WHERE item_id = ?";
                    ps = con.prepareStatement(updateQuery);

                    ps.setString(1, CategoryLbl.getText().trim());
                    ps.setString(2, BrandLbl.getText().trim());
                    ps.setString(3, ModelNumLbl.getText().trim());

                    double rentPrice = validateRentPrice();
                    if (rentPrice < 0) return;
                    ps.setDouble(4, rentPrice);

                    int quantity = validateQuantity();
                    if (quantity < 0) return;
                    ps.setInt(5, quantity);

                    ps.setString(6, StatusCmbBx.getSelectedItem().toString());  // Use ComboBox value
                    ps.setBlob(7, img);  // Set the image if it's changed
                    ps.setInt(8, itemId);  // Use the item ID
                }

                // Execute the update
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Equipment updated successfully!");
                    populateTable(EquipmentTbl);  // Refresh the equipment table
                } else {
                    JOptionPane.showMessageDialog(null, "No equipment found with the specified ID.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Database connection failed. Please check your connection settings.");
            }
        } catch (SQLException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
            Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, "SQL Error", e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
                if (img != null) img.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, "Closing Connection Error", ex);
            } catch (IOException e) {
                Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, "Closing InputStream Error", e);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please fill all fields and select an image.");
    }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if (!EquipmentIDLbl.getText().equals("")) {
        String deleteQuery = "DELETE FROM equipments WHERE item_id = ?";
        String insertHistoryQuery = 
            "INSERT INTO removed_equipments (item_id, category, brand, model_num, rent_price, quantity, status, removed_at) " +
            "SELECT item_id, category, brand, model_num, rent_price, quantity, status, NOW() " +
            "FROM equipments WHERE item_id = ?";

        try (Connection con = DatabaseConn.connect()) {
            con.setAutoCommit(false);

            try (PreparedStatement psInsert = con.prepareStatement(insertHistoryQuery)) {
                int id = Integer.parseInt(EquipmentIDLbl.getText());
                psInsert.setInt(1, id);
                int rowsInserted = psInsert.executeUpdate();

                if (rowsInserted <= 0) {
                    throw new SQLException("Failed to insert data into Deleted History.");
                }
            }

            try (PreparedStatement psDelete = con.prepareStatement(deleteQuery)) {
                int id = Integer.parseInt(EquipmentIDLbl.getText());
                psDelete.setInt(1, id);
                int rowsDeleted = psDelete.executeUpdate();

                if (rowsDeleted > 0) {
                    con.commit();
                    JOptionPane.showMessageDialog(null, "Product Deleted and moved to Deleted History.");
                    populateTable(EquipmentTbl);
                    clearFields();
                } else {
                    throw new SQLException("Failed to delete the product from equipments.");
                }
            }
        } catch (SQLException ex) {
            try {
                Connection con = DatabaseConn.connect();
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackEx) {
                Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, null, rollbackEx);
            }
            Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID format: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Select an Equipment to Delete.");
    }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void EquipmentIDLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipmentIDLblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EquipmentIDLblActionPerformed

    private void quantityLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityLblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityLblActionPerformed

    private void EquipmentTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipmentTblMouseClicked
        JTable table = (JTable) evt.getSource();
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {

            String itemId = table.getValueAt(selectedRow, 0).toString();
            String category = table.getValueAt(selectedRow, 1).toString();
            String brand = table.getValueAt(selectedRow, 2).toString();
            String modelNum = table.getValueAt(selectedRow, 3).toString();
            String status = table.getValueAt(selectedRow, 4).toString();
            String rentPrice = table.getValueAt(selectedRow, 5).toString();
            String quantity = table.getValueAt(selectedRow, 6).toString();

            EquipmentIDLbl.setText(itemId);
            CategoryLbl.setText(category);
            BrandLbl.setText(brand);
            ModelNumLbl.setText(modelNum);
            StatusCmbBx.setSelectedItem(status);
            RentPriceLbl.setText(rentPrice);
            quantityLbl.setText(quantity);
            
            loadImageForEquipment(itemId);
        }
    }//GEN-LAST:event_EquipmentTblMouseClicked

    private void StatusCmbBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusCmbBxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusCmbBxActionPerformed

    private void DeleteHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteHistoryActionPerformed
        DeleteHistory delHist = new DeleteHistory();
        delHist.setVisible(true);
        delHist.setLocationRelativeTo(null);
    }//GEN-LAST:event_DeleteHistoryActionPerformed

    private void UpdateLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateLogsActionPerformed
        DeleteHistory updLogs = new DeleteHistory();
        updLogs.setVisible(true);
        updLogs.setLocationRelativeTo(null);
    }//GEN-LAST:event_UpdateLogsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BrandLbl;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTextField CategoryLbl;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteHistory;
    private javax.swing.JTextField EquipmentIDLbl;
    private javax.swing.JTable EquipmentTbl;
    private javax.swing.JTextField ModelNumLbl;
    private javax.swing.JTextField RentPriceLbl;
    private javax.swing.JComboBox<String> StatusCmbBx;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton UpdateLogs;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton imagechooserbtn;
    private javax.swing.JLabel imagelbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField quantityLbl;
    // End of variables declaration//GEN-END:variables
}
