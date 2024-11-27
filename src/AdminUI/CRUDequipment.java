package AdminUI;

import java.sql.*;
import javax.swing.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CRUDequipment extends javax.swing.JFrame {

    String ImagePath = null;
    private FileFilter filter;
    private int EquipmentId;
    /**
     * Creates new form AddEquipment
     */
    
    public CRUDequipment() {
        initComponents();
        getConnection();
        populateTable(EquipmentTbl);
        setVisible(true);
        setLocationRelativeTo(null);
        this.dispose();
    }

    public void setEquipmentId(int id) {
        this.EquipmentId = id;
    }
    public int getEid(){
        return EquipmentId;
    }
    private Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/fers", "root", "");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
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
    String query = "SELECT item_id, category, brand, model_num, availability, rent_price, Quantity FROM equipments";

    try (Connection con = getConnection();
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
    String query = "SELECT image FROM equipments WHERE equipments.item_id = ?"; // Replace 'image_column' with your actual image column name

    try (Connection con = getConnection();
         PreparedStatement pstmt = con.prepareStatement(query)) {
        
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
    AvailabilityLbl.setText("");
    imagelbl.setIcon(null);
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
        AvailabilityLbl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quantityLbl = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        EquipmentTbl = new javax.swing.JTable();

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
                "Equipment_id", "Category", "Brand", "Model Number", "Rent Price", "Quantity", "Status"
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
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
                        .addGap(34, 34, 34)
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
                                    .addComponent(AvailabilityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
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
                    .addComponent(AvailabilityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagechooserbtn)
                    .addComponent(imagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(CancelBtn)
                    .addComponent(UpdateBtn)
                    .addComponent(DeleteBtn))
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        try (Connection con = getConnection(); 
             InputStream img = new FileInputStream(new File(ImagePath))) {
             
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO equipments(category, brand, model_num, rent_price, Quantity, availability, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, CategoryLbl.getText().trim());
            ps.setString(2, BrandLbl.getText().trim());
            ps.setString(3, ModelNumLbl.getText().trim());

            double rentPrice = validateRentPrice();
            if (rentPrice < 0) return;
            ps.setDouble(4, rentPrice);

            int quantity = validateQuantity();
            if (quantity < 0) return;
            ps.setInt(5, quantity);
            ps.setString(6, AvailabilityLbl.getText().trim());
            ps.setBlob(7, img);
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
        if (checkInputs() && ImagePath != null) {
    Connection con = null;
    PreparedStatement ps = null;
    InputStream img = null;
    try {
        con = getConnection();
        if (con != null) {
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

            if (ImagePath == null) {
                updateQuery = "UPDATE equipments SET category = ?, brand = ?, model_num = ?, rent_price = ?, Quantity = ?, availability = ? WHERE equipments.item_id = ?";
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
                ps.setString(6, AvailabilityLbl.getText().trim());
                ps.setInt(7, itemId);
            } else {
                img = new FileInputStream(new File(ImagePath));

                updateQuery = "UPDATE equipments SET category = ?, brand = ?, model_num = ?, rent_price = ?, Quantity = ?, availability = ?, image = ? WHERE equipments.item_id = ?";
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
                ps.setString(6, AvailabilityLbl.getText().trim());
                ps.setBlob(7, img);
                ps.setInt(8, itemId);
            }

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Equipment updated successfully!");
                populateTable(EquipmentTbl);
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
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM equipments WHERE item_id = ?");
            int id = Integer.parseInt(EquipmentIDLbl.getText());
            ps.setInt(1, id);
            
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Product Deleted");
                populateTable(EquipmentTbl);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Product Not Found: No rows affected");
            }
            
            ps.close();
            con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUDequipment.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product is Not Deleted: " + ex.getMessage());
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
            String availability = table.getValueAt(selectedRow, 4).toString();
            String rentPrice = table.getValueAt(selectedRow, 5).toString();
            String quantity = table.getValueAt(selectedRow, 6).toString();

            EquipmentIDLbl.setText(itemId);
            CategoryLbl.setText(category);
            BrandLbl.setText(brand);
            ModelNumLbl.setText(modelNum);
            AvailabilityLbl.setText(availability);
            RentPriceLbl.setText(rentPrice);
            quantityLbl.setText(quantity);
            
            loadImageForEquipment(itemId);
        }
    }//GEN-LAST:event_EquipmentTblMouseClicked


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDequipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AvailabilityLbl;
    private javax.swing.JTextField BrandLbl;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTextField CategoryLbl;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField EquipmentIDLbl;
    private javax.swing.JTable EquipmentTbl;
    private javax.swing.JTextField ModelNumLbl;
    private javax.swing.JTextField RentPriceLbl;
    private javax.swing.JButton UpdateBtn;
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
