package AdminUI;

import CustomerUI.CustomerMain;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddEquipment extends javax.swing.JFrame {

    /**
     * Creates new form AddEquipment
     */
    public AddEquipment() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        this.dispose();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CategoryLbl = new javax.swing.JTextField();
        EquipmentNameLbl = new javax.swing.JTextField();
        BrandLbl = new javax.swing.JTextField();
        ModelNumLbl = new javax.swing.JTextField();
        CanelBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        imageTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        RentPriceLbl1 = new javax.swing.JTextField();
        imagebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 300));
        jPanel5.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(21, 25, 28));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BRBLogo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADD EQUIPMENT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(35, 35, 35))
        );

        jPanel5.add(jPanel3);
        jPanel3.setBounds(0, 0, 500, 100);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel1.setText("Category");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel2.setText("Equipment Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel3.setText("Brand");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setText("Model Number");

        CanelBtn.setText("Cancel");
        CanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanelBtnActionPerformed(evt);
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

        imagebtn.setText("Add Image");
        imagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ModelNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BrandLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CategoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EquipmentNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(addBtn)
                                        .addGap(134, 134, 134)
                                        .addComponent(CanelBtn))
                                    .addComponent(RentPriceLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(imagebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CategoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EquipmentNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(BrandLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModelNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(RentPriceLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagebtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(CanelBtn))
                .addGap(20, 20, 20))
        );

        jPanel5.add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 400);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 500, 400);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String Category, EquipmentName, Brand, Model, RentPrice, AddImage, Availability;
        String query;

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/fers", "root", "");
            Statement st = con.createStatement();
            
            if("".equals(CategoryLbl.getText())){
                JOptionPane.showMessageDialog(this, "Missing Category.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if("".equals(EquipmentNameLbl.getText())){
                JOptionPane.showMessageDialog(this, "Please Enter Equipment Name.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if("".equals(BrandLbl.getText())){
                JOptionPane.showMessageDialog(this, "Please Enter Brand.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if("".equals(ModelNumLbl.getText())){
                JOptionPane.showMessageDialog(this, "Please Enter Model.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if("".equals(RentPriceLbl1.getText())){
                JOptionPane.showMessageDialog(this, "Please Enter the Rent Price.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else if("".equals(imageTextField.getText())){
                JOptionPane.showMessageDialog(this, "Please Enter correct the image path.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
              
                RentPrice = RentPriceLbl1.getText();
                //Input Values
                Category = CategoryLbl.getText();
                EquipmentName = EquipmentNameLbl.getText();
                Brand = BrandLbl.getText();
                Model = ModelNumLbl.getText();
                AddImage = imageTextField.getText();
                Availability = "Available"; //Default Value for availability
                
                int response = JOptionPane.showConfirmDialog(
                this,
                    "Are you sure you want to add the following equipment?\n" +
                    "Category: " + Category + "\n" +
                    "Equipment Name: " + EquipmentName + "\n" +
                    "Brand: " + Brand + "\n" +
                    "Model: " + Model + "\n" +
                    "Rent Price: " + RentPrice + "\n" +
                    "Add Image: " + AddImage,
                    "Confirm add equipment ",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if(response == JOptionPane.YES_OPTION){
                
                    query = "INSERT INTO rental_equipments(Category, Equipment_Name, Brand, Model_Number, Rent_Price, Availability, ImagePath)" +
                            "VALUES('"+Category+"' , '"+EquipmentName+"' , '"+Brand+"' , '"+Model+"' , '" +RentPrice+"' , '"+AddImage+ "', '" +Availability+"')";

                    st.execute(query);
                    CategoryLbl.setText("");
                    EquipmentNameLbl.setText("");
                    BrandLbl.setText("");
                    ModelNumLbl.setText("");
                    RentPriceLbl1.setText("");

                    showMessageDialog(null, "Equipment added Successfully!");
                }else{
                    JOptionPane.showMessageDialog(this, "Add operation canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage(), "Error Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void CanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanelBtnActionPerformed
        AdminMainMenu AmM = new AdminMainMenu();
        AmM.setVisible(true);
        AmM.pack();
        AmM.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_CanelBtnActionPerformed

    private void imagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagebtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        JLabel jlabel2 = new JLabel();
    
    // Set the file filter to accept only image files
    fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
        @Override
        public boolean accept(File file) {
            // Allow directories and image files with specific extensions
            return file.isDirectory() || file.getName().toLowerCase().endsWith(".jpg") ||
                   file.getName().toLowerCase().endsWith(".jpeg") ||
                   file.getName().toLowerCase().endsWith(".png") ||
                   file.getName().toLowerCase().endsWith(".gif");
        }

        @Override
        public String getDescription() {
            return "Image Files (*.jpg, *.jpeg, *.png, *.gif)";
        }
    });

    // Show the file chooser dialog
    int result = fileChooser.showOpenDialog(this); // 'this' refers to the parent frame
    
    // Check if the user selected a file
    if (result == JFileChooser.APPROVE_OPTION) {
        // Get the selected file
        File selectedFile = fileChooser.getSelectedFile();
        
        // Display the file path in a message dialog
        JOptionPane.showMessageDialog(this, "Selected file: " + selectedFile.getAbsolutePath());
        imageTextField.setText(selectedFile.getAbsolutePath());
        // Optional: Load and display the image in a JLabel
        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
        // Scale the image if needed
        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
         
        if(Imagelbl != null){
            Imagelbl.setIcon(imageIcon);
        }
        
        
    } else {
        // User canceled the file chooser
        JOptionPane.showMessageDialog(this, "No file selected.");
    }
    }//GEN-LAST:event_imagebtnActionPerformed
    

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
            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddEquipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BrandLbl;
    private javax.swing.JButton CanelBtn;
    private javax.swing.JTextField CategoryLbl;
    private javax.swing.JTextField EquipmentNameLbl;
    private javax.swing.JTextField ModelNumLbl;
    private javax.swing.JTextField RentPriceLbl1;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField imageTextField;
    private javax.swing.JButton imagebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
