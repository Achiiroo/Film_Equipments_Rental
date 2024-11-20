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
public class btnBook_Equipment extends javax.swing.JFrame {

    /**
     * Creates new form btnBook_Equipment
     */
    public btnBook_Equipment() {
        initComponents();
        
        btncinema.setVisible(false);
        btnmirrorless.setVisible(false);
        btnphoto.setVisible(false);
        btnfilm.setVisible(false);
        btnspecialty.setVisible(false);
        btn_cinemalense.setVisible(false);
        btnled.setVisible(false);
        btnpanel.setVisible(false);
        btnshotgun.setVisible(false);
        btnmicro.setVisible(false);
        btnsoundmixers.setVisible(false);
        panelcamera.setVisible(true);
        panellense.setVisible(true);
        panellights.setVisible(true);
        panelsounds.setVisible(true);
        
        btnFilmEquipment.setBackground(Color.RED);
        btn_home.setBackground(Color.white);
        btnreturn.setBackground(Color.white);
        btnview.setBackground(Color.white);
        btncamera.setBackground(Color.white);
        btncamera_lense.setBackground(Color.white);
        btnlights.setBackground(Color.white);
        btn_sounds.setBackground(Color.white);

    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFilmEquipment = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btnreturn = new javax.swing.JButton();
        btnview = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelcamera = new javax.swing.JPanel();
        btncamera = new javax.swing.JButton();
        btncinema = new javax.swing.JButton();
        btnmirrorless = new javax.swing.JButton();
        btnphoto = new javax.swing.JButton();
        btnfilm = new javax.swing.JButton();
        btnspecialty = new javax.swing.JButton();
        panellense = new javax.swing.JPanel();
        btncamera_lense = new javax.swing.JButton();
        btn_cinemalense = new javax.swing.JButton();
        panellights = new javax.swing.JPanel();
        btnlights = new javax.swing.JButton();
        btnled = new javax.swing.JButton();
        btnpanel = new javax.swing.JButton();
        panelsounds = new javax.swing.JPanel();
        btn_sounds = new javax.swing.JButton();
        btnshotgun = new javax.swing.JButton();
        btnmicro = new javax.swing.JButton();
        btnsoundmixers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(2147483647, 2147483647));
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
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 230, 70));

        btnreturn.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btnreturn.setText("RETURN ");
        btnreturn.setPreferredSize(new java.awt.Dimension(172, 33));
        btnreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreturnActionPerformed(evt);
            }
        });
        jPanel1.add(btnreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 230, 70));

        btnview.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btnview.setText("VIEW RENTAL");
        btnview.setPreferredSize(new java.awt.Dimension(172, 33));
        btnview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewActionPerformed(evt);
            }
        });
        jPanel1.add(btnview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 230, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, -1, 900));

        jPanel3.setBackground(new java.awt.Color(42, 40, 44));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.CardLayout());

        panelcamera.setBackground(new java.awt.Color(30, 40, 44));

        btncamera.setText("CAMERA");
        btncamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncameraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncameraMouseExited(evt);
            }
        });
        btncamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncameraActionPerformed(evt);
            }
        });

        btncinema.setText("Cinema Camera");
        btncinema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncinemaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncinemaMouseExited(evt);
            }
        });

        btnmirrorless.setText("Mirrorless Camera");
        btnmirrorless.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmirrorlessMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmirrorlessMouseExited(evt);
            }
        });

        btnphoto.setText("Photography Camera");
        btnphoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnphotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnphotoMouseExited(evt);
            }
        });
        btnphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnphotoActionPerformed(evt);
            }
        });

        btnfilm.setText("Film Camera");
        btnfilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnfilmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnfilmMouseExited(evt);
            }
        });

        btnspecialty.setText("Specialty/Misc Cameras");
        btnspecialty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnspecialtyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnspecialtyMouseExited(evt);
            }
        });

        panellense.setBackground(new java.awt.Color(30, 40, 44));

        btncamera_lense.setText("CAMERA LENSES");
        btncamera_lense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncamera_lenseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncamera_lenseMouseExited(evt);
            }
        });
        btncamera_lense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncamera_lenseActionPerformed(evt);
            }
        });

        btn_cinemalense.setText("Cinema Lenses");
        btn_cinemalense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cinemalenseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cinemalenseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panellenseLayout = new javax.swing.GroupLayout(panellense);
        panellense.setLayout(panellenseLayout);
        panellenseLayout.setHorizontalGroup(
            panellenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellenseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panellenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panellenseLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_cinemalense, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panellenseLayout.createSequentialGroup()
                        .addComponent(btncamera_lense, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panellenseLayout.setVerticalGroup(
            panellenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellenseLayout.createSequentialGroup()
                .addComponent(btncamera_lense, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cinemalense)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panellights.setBackground(new java.awt.Color(42, 40, 44));

        btnlights.setText("LIGHTS");
        btnlights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlightsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlightsMouseExited(evt);
            }
        });
        btnlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlightsActionPerformed(evt);
            }
        });

        btnled.setText("LED Point Source Lightning");
        btnled.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnledMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnledMouseExited(evt);
            }
        });

        btnpanel.setText("Panel Lights");
        btnpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnpanelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panellightsLayout = new javax.swing.GroupLayout(panellights);
        panellights.setLayout(panellightsLayout);
        panellightsLayout.setHorizontalGroup(
            panellightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellightsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panellightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlights, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panellightsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panellightsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnled)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panellightsLayout.setVerticalGroup(
            panellightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellightsLayout.createSequentialGroup()
                .addComponent(btnlights, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpanel)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelsounds.setBackground(new java.awt.Color(42, 40, 44));

        btn_sounds.setText("SOUNDS");
        btn_sounds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_soundsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_soundsMouseExited(evt);
            }
        });
        btn_sounds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soundsActionPerformed(evt);
            }
        });

        btnshotgun.setText("Shotgun and on-camera");
        btnshotgun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnshotgunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnshotgunMouseExited(evt);
            }
        });

        btnmicro.setText("Microphones");
        btnmicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmicroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmicroMouseExited(evt);
            }
        });

        btnsoundmixers.setText("Sound mixers and recorders");
        btnsoundmixers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsoundmixersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsoundmixersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelsoundsLayout = new javax.swing.GroupLayout(panelsounds);
        panelsounds.setLayout(panelsoundsLayout);
        panelsoundsLayout.setHorizontalGroup(
            panelsoundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsoundsLayout.createSequentialGroup()
                .addGroup(panelsoundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsoundsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnmicro, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelsoundsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelsoundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sounds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsoundmixers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelsoundsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnshotgun, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelsoundsLayout.setVerticalGroup(
            panelsoundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsoundsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_sounds, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnshotgun, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmicro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsoundmixers)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelcameraLayout = new javax.swing.GroupLayout(panelcamera);
        panelcamera.setLayout(panelcameraLayout);
        panelcameraLayout.setHorizontalGroup(
            panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcameraLayout.createSequentialGroup()
                .addGroup(panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcameraLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelcameraLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnmirrorless, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncinema, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btncamera, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(panellense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelcameraLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnphoto, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(btnfilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnspecialty))))
                .addGap(18, 18, 18)
                .addComponent(panellights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelsounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelcameraLayout.setVerticalGroup(
            panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcameraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcameraLayout.createSequentialGroup()
                        .addGroup(panelcameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelcameraLayout.createSequentialGroup()
                                .addComponent(btncamera, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncinema)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnmirrorless))
                            .addComponent(panellense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnphoto))
                    .addComponent(panellights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfilm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnspecialty)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(panelcameraLayout.createSequentialGroup()
                .addComponent(panelsounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(panelcamera, "card2");

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 900, 210));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1310, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncamera_lenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncamera_lenseActionPerformed

        boolean isVisible = btncamera_lense.isVisible();
        btn_cinemalense.setVisible(!btn_cinemalense.isVisible());
    }//GEN-LAST:event_btncamera_lenseActionPerformed

    private void btnphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnphotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnphotoActionPerformed

    private void btncameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncameraActionPerformed
        btncinema.setVisible(!btncinema.isVisible());
        btnmirrorless.setVisible(!btnmirrorless.isVisible());
        btnphoto.setVisible(!btnphoto.isVisible());
        btnfilm.setVisible(!btnfilm.isVisible());
        btnspecialty.setVisible(!btnspecialty.isVisible());
    }//GEN-LAST:event_btncameraActionPerformed

    private void btnlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlightsActionPerformed
        btnled.setVisible(!btnled.isVisible());
    }//GEN-LAST:event_btnlightsActionPerformed

    private void btn_soundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soundsActionPerformed
        btnshotgun.setVisible(!btnshotgun.isVisible());
        btnmicro.setVisible(!btnmicro.isVisible());
        btnsoundmixers.setVisible(!btnsoundmixers.isVisible());
    }//GEN-LAST:event_btn_soundsActionPerformed

    private void btncameraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncameraMouseEntered
        btncamera.setBackground(Color.RED);
    }//GEN-LAST:event_btncameraMouseEntered

    private void btncameraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncameraMouseExited
        btncamera.setBackground(Color.white);
    }//GEN-LAST:event_btncameraMouseExited

    private void btnlightsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlightsMouseEntered
        btnlights.setBackground(Color.RED);
    }//GEN-LAST:event_btnlightsMouseEntered

    private void btnlightsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlightsMouseExited
        btnlights.setBackground(Color.white);
    }//GEN-LAST:event_btnlightsMouseExited

    private void btncinemaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncinemaMouseEntered
        btncinema.setBackground(Color.yellow);
    }//GEN-LAST:event_btncinemaMouseEntered

    private void btncinemaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncinemaMouseExited
        btncinema.setBackground(Color.white);
    }//GEN-LAST:event_btncinemaMouseExited

    private void btnmirrorlessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmirrorlessMouseEntered
        btnmirrorless.setBackground(Color.yellow);
    }//GEN-LAST:event_btnmirrorlessMouseEntered

    private void btnmirrorlessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmirrorlessMouseExited
        btnmirrorless.setBackground(Color.white);
    }//GEN-LAST:event_btnmirrorlessMouseExited

    private void btnphotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnphotoMouseEntered
        btnphoto.setBackground(Color.yellow);
    }//GEN-LAST:event_btnphotoMouseEntered

    private void btnphotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnphotoMouseExited
        btnphoto.setBackground(Color.white);
    }//GEN-LAST:event_btnphotoMouseExited

    private void btnfilmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfilmMouseEntered
        btnfilm.setBackground(Color.yellow);
    }//GEN-LAST:event_btnfilmMouseEntered

    private void btnfilmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfilmMouseExited
        btnfilm.setBackground(Color.white);
    }//GEN-LAST:event_btnfilmMouseExited

    private void btnspecialtyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnspecialtyMouseEntered
        btnspecialty.setBackground(Color.yellow);
    }//GEN-LAST:event_btnspecialtyMouseEntered

    private void btnspecialtyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnspecialtyMouseExited
        btnspecialty.setBackground(Color.white);
    }//GEN-LAST:event_btnspecialtyMouseExited

    private void btncamera_lenseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncamera_lenseMouseEntered
        btncamera_lense.setBackground(Color.RED);
    }//GEN-LAST:event_btncamera_lenseMouseEntered

    private void btncamera_lenseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncamera_lenseMouseExited
        btncamera_lense.setBackground(Color.white);
    }//GEN-LAST:event_btncamera_lenseMouseExited

    private void btn_cinemalenseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cinemalenseMouseEntered
        btn_cinemalense.setBackground(Color.yellow);
    }//GEN-LAST:event_btn_cinemalenseMouseEntered

    private void btn_cinemalenseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cinemalenseMouseExited
        btn_cinemalense.setBackground(Color.white);
    }//GEN-LAST:event_btn_cinemalenseMouseExited

    private void btnledMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnledMouseEntered
        btnled.setBackground(Color.yellow);
    }//GEN-LAST:event_btnledMouseEntered

    private void btnledMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnledMouseExited
        btnled.setBackground(Color.white);
    }//GEN-LAST:event_btnledMouseExited

    private void btnpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpanelMouseEntered
        btnpanel.setBackground(Color.yellow);
    }//GEN-LAST:event_btnpanelMouseEntered

    private void btnpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpanelMouseExited
        btnpanel.setBackground(Color.white);
    }//GEN-LAST:event_btnpanelMouseExited

    private void btn_soundsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_soundsMouseEntered
        btn_sounds.setBackground(Color.RED);
    }//GEN-LAST:event_btn_soundsMouseEntered

    private void btn_soundsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_soundsMouseExited
        btn_sounds.setBackground(Color.white);
    }//GEN-LAST:event_btn_soundsMouseExited

    private void btnshotgunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnshotgunMouseEntered
        btnshotgun.setBackground(Color.yellow);
    }//GEN-LAST:event_btnshotgunMouseEntered

    private void btnshotgunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnshotgunMouseExited
        btnshotgun.setBackground(Color.white);
    }//GEN-LAST:event_btnshotgunMouseExited

    private void btnmicroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmicroMouseEntered
        btnmicro.setBackground(Color.yellow);
    }//GEN-LAST:event_btnmicroMouseEntered

    private void btnmicroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmicroMouseExited
        btnmicro.setBackground(Color.white);
    }//GEN-LAST:event_btnmicroMouseExited

    private void btnsoundmixersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsoundmixersMouseEntered
        btnsoundmixers.setBackground(Color.yellow);
    }//GEN-LAST:event_btnsoundmixersMouseEntered

    private void btnsoundmixersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsoundmixersMouseExited
        btnsoundmixers.setBackground(Color.white);
    }//GEN-LAST:event_btnsoundmixersMouseExited

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        btn_home.setBackground(Color.RED);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        btn_home.setBackground(Color.white);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btnFilmEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilmEquipmentActionPerformed
        boolean isVisible = btncamera.isVisible();

        btncinema.setVisible(!isVisible);
        btnmirrorless.setVisible(!isVisible);
        btnphoto.setVisible(!isVisible);
        btnfilm.setVisible(!isVisible);
        btnspecialty.setVisible(!isVisible);
        btn_cinemalense.setVisible(!isVisible);
        btnlights.setVisible(!isVisible);
        btnled.setVisible(!isVisible);
        btnpanel.setVisible(!isVisible);
        btnshotgun.setVisible(!isVisible);
        btnmicro.setVisible(!isVisible);
        btnsoundmixers.setVisible(!isVisible);
        panelcamera.setVisible(isVisible);
        panellense.setVisible(isVisible);
        panellights.setVisible(isVisible);
        panelsounds.setVisible(isVisible);
    }//GEN-LAST:event_btnFilmEquipmentActionPerformed

    private void btnFilmEquipmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilmEquipmentMouseEntered

    }//GEN-LAST:event_btnFilmEquipmentMouseEntered

    private void btnFilmEquipmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilmEquipmentMouseExited

    }//GEN-LAST:event_btnFilmEquipmentMouseExited

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        Customer_DashBoard MainMenu = new Customer_DashBoard();
        MainMenu.setVisible(true);
        MainMenu.pack();
        MainMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

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
            java.util.logging.Logger.getLogger(btnBook_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(btnBook_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(btnBook_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(btnBook_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new btnBook_Equipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilmEquipment;
    private javax.swing.JButton btn_cinemalense;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_sounds;
    private javax.swing.JButton btncamera;
    private javax.swing.JButton btncamera_lense;
    private javax.swing.JButton btncinema;
    private javax.swing.JButton btnfilm;
    private javax.swing.JButton btnled;
    private javax.swing.JButton btnlights;
    private javax.swing.JButton btnmicro;
    private javax.swing.JButton btnmirrorless;
    private javax.swing.JButton btnpanel;
    private javax.swing.JButton btnphoto;
    private javax.swing.JButton btnreturn;
    private javax.swing.JButton btnshotgun;
    private javax.swing.JButton btnsoundmixers;
    private javax.swing.JButton btnspecialty;
    private javax.swing.JButton btnview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelcamera;
    private javax.swing.JPanel panellense;
    private javax.swing.JPanel panellights;
    private javax.swing.JPanel panelsounds;
    // End of variables declaration//GEN-END:variables
}
