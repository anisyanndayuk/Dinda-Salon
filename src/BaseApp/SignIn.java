package BaseApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.Timer;
public class SignIn extends javax.swing.JFrame {
    public static String LoggedInUser;
    public static String LoggedNameUser;

    public static String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public SignIn() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
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
        signinbtn = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        showpassword = new javax.swing.JCheckBox();
        btnbacksignup = new javax.swing.JButton();
        forgotpassword = new javax.swing.JButton();
        btnbacksignin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signinbtn.setContentAreaFilled(false);
        signinbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Signin.png"))); // NOI18N
        signinbtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Signinbtn.png"))); // NOI18N
        signinbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signinbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signinbtnMouseExited(evt);
            }
        });
        signinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinbtnActionPerformed(evt);
            }
        });
        jPanel1.add(signinbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 670, -1, -1));
        signinbtn.setBorderPainted(false);

        txtusername.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtusername.setBorder(null);
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 373, 670, 40));

        txtpassword.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtpassword.setBorder(null);
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 494, 670, 40));

        showpassword.setBackground(new java.awt.Color(255, 255, 255));
        showpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showpasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showpasswordMouseExited(evt);
            }
        });
        showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 588, 20, 30));

        btnbacksignup.setContentAreaFilled(false);
        btnbacksignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SignUpbtn.png"))); // NOI18N
        btnbacksignup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SignUpbtn..png"))); // NOI18N
        btnbacksignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbacksignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbacksignupMouseExited(evt);
            }
        });
        btnbacksignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbacksignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnbacksignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 780, -1, -1));
        btnbacksignup.setBorderPainted(false);

        forgotpassword.setContentAreaFilled(false);
        forgotpassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/forgot..png"))); // NOI18N
        forgotpassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/forgot.png"))); // NOI18N
        forgotpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotpasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotpasswordMouseExited(evt);
            }
        });
        forgotpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(forgotpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 590, -1, 30));
        forgotpassword.setBorderPainted(false);

        btnbacksignin.setContentAreaFilled(false);
        btnbacksignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnbacksignin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnbacksignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbacksigninMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbacksigninMouseExited(evt);
            }
        });
        btnbacksignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbacksigninActionPerformed(evt);
            }
        });
        jPanel1.add(btnbacksignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 850, -1, -1));
        btnbacksignin.setBorderPainted(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Sign In..png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signinbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinbtnActionPerformed
        // TODO add your handling code here:
    String username = txtusername.getText();
    String password = new String(txtpassword.getPassword());

    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua kolom!");
        return;
    }
    
    String hashedPassword = hashMD5(password);

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, hashedPassword);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int ID = rs.getInt("id_user");
            String nama = rs.getString("nama_user");
            String level = rs.getString("level");
            
            SessionLogin.setUsername(username);
            SessionLogin.setNamaUser(nama);
            SessionLogin.setLevel(level);
            SessionLogin.setIdUser(ID);
            JOptionPane.showMessageDialog(this, "Login Berhasil!");

           final JFrame currentFrame = this;
            // Timer untuk efek fade-out pada frame login saat ini
            Timer fadeOutTimer = new Timer(30, null);
            fadeOutTimer.addActionListener(new ActionListener() {
            float opacity = 1f;
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.1f; 
                if (opacity <= 0f) {
                    fadeOutTimer.stop();
                    currentFrame.dispose();

                    // Tentukan dashboard sesuai level
                    JFrame dashboardFrame = null;
                    if (level.equals("owner")) {
                        dashboardFrame = new DashboardOwner();
                    } else if (level.equals("admin")) {
                        dashboardFrame = new DashboardAdmin();
                    } else if (level.equals("kasir")) {
                        dashboardFrame = new DashboardKasir();
                    }

                    if (dashboardFrame != null) {
                        final JFrame finalDashboardFrame = dashboardFrame;
                        finalDashboardFrame.setOpacity(0f);
                        finalDashboardFrame.setVisible(true);

                        Timer fadeInTimer = new Timer(30, null);
                        fadeInTimer.addActionListener(new ActionListener() {
                            float opacityIn = 0f;
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                opacityIn += 0.1f;
                                if (opacityIn >= 1f) {
                                    fadeInTimer.stop();
                                    finalDashboardFrame.setOpacity(1f);
                                } else {
                                    finalDashboardFrame.setOpacity(opacityIn);
                                }
                            }
                        });
                        fadeInTimer.start();
                    }
                } else {
                    currentFrame.setOpacity(opacity);
                }
            }
        });
        fadeOutTimer.start();  
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_signinbtnActionPerformed

    private void signinbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_signinbtnMouseEntered

    private void signinbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinbtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_signinbtnMouseExited

    private void btnbacksignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbacksignupActionPerformed
        // TODO add your handling code here:
    final JFrame currentFrame = this;
    Timer fadeOutTimer = new Timer(40, null);
    fadeOutTimer.addActionListener(new ActionListener() {
        float opacity = 1f;
        @Override
        public void actionPerformed(ActionEvent e) {
            opacity -= 0.1f;
            if (opacity <= 0f) {
                fadeOutTimer.stop();
                currentFrame.dispose();
                
                // mengatur undecorated di konstruktornya
                final SignUp signupFrame = new SignUp();
                signupFrame.setOpacity(0f);
                signupFrame.setVisible(true);
                
                Timer fadeInTimer = new Timer(40, null);
                fadeInTimer.addActionListener(new ActionListener() {
                    float opacityIn = 0f;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        opacityIn += 0.1f;
                        if (opacityIn >= 1f) {
                            fadeInTimer.stop();
                            signupFrame.setOpacity(1f);
                        } else {
                            signupFrame.setOpacity(opacityIn);
                        }
                    }
                });
                fadeInTimer.start();
            } else {
                currentFrame.setOpacity(opacity);
            }
        }
    });
    fadeOutTimer.start();
    }//GEN-LAST:event_btnbacksignupActionPerformed

    private void btnbacksignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbacksignupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbacksignupMouseEntered

    private void btnbacksignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbacksignupMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbacksignupMouseExited

    private void forgotpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpasswordActionPerformed
        // TODO add your handling code here:
        String username = JOptionPane.showInputDialog(this, "Masukkan username Anda:");

    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!");
        return;
    }

    String newPassword = JOptionPane.showInputDialog(this, "Masukkan password baru:");

    if (newPassword == null || newPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password baru tidak boleh kosong!");
        return;
    }

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
        String query = "UPDATE user SET password = ? WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, newPassword);
        stmt.setString(2, username);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Password berhasil direset!");
        } else {
            JOptionPane.showMessageDialog(this, "Username tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_forgotpasswordActionPerformed

    private void forgotpasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpasswordMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotpasswordMouseEntered

    private void forgotpasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpasswordMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotpasswordMouseExited

    private void btnbacksigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbacksigninActionPerformed
        // TODO add your handling code here:
    final JFrame currentFrame = this;
    Timer fadeOutTimer = new Timer(40, null);
    fadeOutTimer.addActionListener(new ActionListener() {
        float opacity = 1f;
        @Override
        public void actionPerformed(ActionEvent e) {
            opacity -= 0.1f;
            if (opacity <= 0f) {
                fadeOutTimer.stop();
                currentFrame.dispose();
                
                // mengatur undecorated di konstruktornya
                final SignUp signupFrame = new SignUp();
                signupFrame.setOpacity(0f);
                signupFrame.setVisible(true);
                
                Timer fadeInTimer = new Timer(40, null);
                fadeInTimer.addActionListener(new ActionListener() {
                    float opacityIn = 0f;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        opacityIn += 0.1f;
                        if (opacityIn >= 1f) {
                            fadeInTimer.stop();
                            signupFrame.setOpacity(1f);
                        } else {
                            signupFrame.setOpacity(opacityIn);
                        }
                    }
                });
                fadeInTimer.start();
            } else {
                currentFrame.setOpacity(opacity);
            }
        }
    });
    fadeOutTimer.start();

    }//GEN-LAST:event_btnbacksigninActionPerformed

    private void btnbacksigninMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbacksigninMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbacksigninMouseEntered

    private void btnbacksigninMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbacksigninMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbacksigninMouseExited

    private void showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordActionPerformed
        // TODO add your handling code here:
      if (showpassword.isSelected()) {
        txtpassword.setEchoChar((char) 0); // Menampilkan teks password
    } else {
        txtpassword.setEchoChar('•'); // Menyembunyikan teks password
    }

    }//GEN-LAST:event_showpasswordActionPerformed

    private void showpasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showpasswordMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_showpasswordMouseEntered

    private void showpasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showpasswordMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_showpasswordMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("sun.java2d.uiScale", "1");
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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbacksignin;
    private javax.swing.JButton btnbacksignup;
    private javax.swing.JButton forgotpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox showpassword;
    private javax.swing.JButton signinbtn;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
