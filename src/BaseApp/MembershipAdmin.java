package BaseApp;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
public class MembershipAdmin extends javax.swing.JFrame {
    boolean isEditMode = false;
  
    public MembershipAdmin() {
        setUndecorated(true);
        initComponents();
        jeniskelamin.setOpaque(false);
        jeniskelamin.setBackground(new Color(0, 0, 0, 0));
        jeniskelamin.setForeground(Color.WHITE);
        jeniskelamin.setBorder(null);
        //buat dropdown transparan
        jeniskelamin.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
            return c;
}
});
        setLocationRelativeTo(null);
        tampilData(); 
        tb_member.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = tb_member.getSelectedRow();
        if (selectedRow != -1) {
            txtidmember.setText(tb_member.getValueAt(selectedRow, 0).toString());
            txtnamamember.setText(tb_member.getValueAt(selectedRow, 1).toString());
            jeniskelamin.setSelectedItem(tb_member.getValueAt(selectedRow, 2).toString());
            txttelp.setText(tb_member.getValueAt(selectedRow, 3).toString());
            txtalamat.setText(tb_member.getValueAt(selectedRow, 4).toString());
            txtpoin.setText(tb_member.getValueAt(selectedRow, 5).toString());
            
            isEditMode = true;
        }
    }
});
       }
    private void tampilData() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Member");
    model.addColumn("Nama");
    model.addColumn("Jenis Kelamin");
    model.addColumn("No Telepon");
    model.addColumn("Alamat");
    model.addColumn("Poin");

    try {
        Connection conn = Data.configDB();
        String sql = "SELECT * FROM member";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_member"),
                rs.getString("nama_member"),
                rs.getString("jenis_kelamin"),
                rs.getString("notelp_member"),
                rs.getString("alamat_member"),
                rs.getInt("poin_member")
            });
        }
        tb_member.setModel(model);
        tb_member.setRowHeight(27);
        tb_member.getColumnModel().getColumn(0).setPreferredWidth(100); 
        tb_member.getColumnModel().getColumn(1).setPreferredWidth(170); 
        tb_member.getColumnModel().getColumn(2).setPreferredWidth(135); 
        tb_member.getColumnModel().getColumn(3).setPreferredWidth(200);  
        tb_member.getColumnModel().getColumn(4).setPreferredWidth(180);
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
    }
}
    private void clearForm() {
    txtidmember.setText("");
    txtnamamember.setText("");
    jeniskelamin.setSelectedIndex(0);
    txttelp.setText("");
    txtalamat.setText("");
    txtpoin.setText("");
    isEditMode = false;
    tb_member.clearSelection();
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btntreatment = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnsupplier = new javax.swing.JButton();
        btnpembelian = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnpegawai = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        txtidmember = new javax.swing.JTextField();
        jeniskelamin = new javax.swing.JComboBox<>();
        txtnamamember = new javax.swing.JTextField();
        txttelp = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtpoin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_member = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntreatment.setContentAreaFilled(false);
        btntreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntreatment.png"))); // NOI18N
        btntreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtreatment.png"))); // NOI18N
        btntreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntreatmentActionPerformed(evt);
            }
        });
        jPanel1.add(btntreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));
        btntreatment.setBorderPainted(false);

        btnproduk.setContentAreaFilled(false);
        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnproduk.png"))); // NOI18N
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));
        btnproduk.setBorderPainted(false);

        btnsupplier.setContentAreaFilled(false);
        btnsupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsupplier.png"))); // NOI18N
        btnsupplier.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsupplier.png"))); // NOI18N
        btnsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplierActionPerformed(evt);
            }
        });
        jPanel1.add(btnsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));
        btnsupplier.setBorderPainted(false);

        btnpembelian.setContentAreaFilled(false);
        btnpembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpembelian.png"))); // NOI18N
        btnpembelian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpembelian.png"))); // NOI18N
        btnpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpembelianActionPerformed(evt);
            }
        });
        jPanel1.add(btnpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 90));
        btnpembelian.setBorderPainted(false);

        btnlaporan.setContentAreaFilled(false);
        btnlaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, 90));
        btnlaporan.setBorderPainted(false);

        btnpegawai.setContentAreaFilled(false);
        btnpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawai.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 90));
        btnpegawai.setBorderPainted(false);

        btnback.setContentAreaFilled(false);
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 90, -1));
        btnback.setBorderPainted(false);

        btnedit.setContentAreaFilled(false);
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnedit.png"))); // NOI18N
        btnedit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgedit.png"))); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 900, 190, -1));
        btnedit.setBorderPainted(false);

        btndelete.setContentAreaFilled(false);
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btndelete.png"))); // NOI18N
        btndelete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgdelete.png"))); // NOI18N
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 900, 190, -1));
        btndelete.setBorderPainted(false);

        btnsave.setContentAreaFilled(false);
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsave.png"))); // NOI18N
        btnsave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsave.png"))); // NOI18N
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 900, 370, 70));
        btnsave.setBorderPainted(false);

        txtidmember.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtidmember.setBorder(null);
        jPanel1.add(txtidmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 291, 390, 30));

        jeniskelamin.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih salah satu", "laki-laki ", "perempuan" }));
        jeniskelamin.setBorder(null);
        jPanel1.add(jeniskelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, 130, 50));

        txtnamamember.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtnamamember.setBorder(null);
        jPanel1.add(txtnamamember, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 381, 390, 30));

        txttelp.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txttelp.setBorder(null);
        jPanel1.add(txttelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 580, 390, 20));

        txtalamat.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtalamat.setBorder(null);
        jPanel1.add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 670, 390, 20));

        txtpoin.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtpoin.setBorder(null);
        jPanel1.add(txtpoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 760, 390, 20));

        tb_member.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_member.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Member", "Nama Member", "Jenis Kelamin", "No Telp", "Alamat", "Poin"
            }
        ));
        jScrollPane1.setViewportView(tb_member);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 670, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Membership.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        String id = txtidmember.getText();
        String nama = txtnamamember.getText();
        String jk = jeniskelamin.getSelectedItem().toString();
        String telp = txttelp.getText();
        String alamat = txtalamat.getText();
        String poin = txtpoin.getText();
        
        String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        
        if (id.isEmpty() || nama.isEmpty() || telp.isEmpty() || alamat.isEmpty() || poin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua kolom!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection conn = Data.configDB();
            String sql = "UPDATE member SET nama_member=?, jenis_kelamin=?, notelp_member=?, alamat_member=?, poin_member=? WHERE id_member=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, jk);
            pst.setString(3, telp);
            pst.setString(4, alamat);
            pst.setInt(5, Integer.parseInt(poin));
            pst.setString(6, id);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Data tidak ditemukan untuk diperbarui.");
            }
            tampilData(); 
            clearForm();
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal mengedit data: " + e.getMessage());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Harap isi semua kolom!");
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        // TODO add your handling code here:
        new TreatmentAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
        // TODO add your handling code here:
        new ProdukAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnprodukActionPerformed

    private void btnsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupplierActionPerformed
        // TODO add your handling code here:
        new SupplierAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsupplierActionPerformed

    private void btnpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpembelianActionPerformed
        // TODO add your handling code here:
        new PembelianAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnpembelianActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void btnpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpegawaiActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        String id = txtidmember.getText();
        
        String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }

        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this, "Apakah yakin ingin menghapus data ini?", "Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            try {
                Connection conn = Data.configDB();
                String sql = "DELETE FROM member WHERE id_member=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);

                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data tidak ditemukan.");
                }
                tampilData();
                clearForm();
            } catch (SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
    }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String id = txtidmember.getText();
        String nama = txtnamamember.getText();
        String jk = jeniskelamin.getSelectedItem().toString();
        String telp = txttelp.getText();
        String alamat = txtalamat.getText();
        String poin = txtpoin.getText();
        
        String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        
        if (id.isEmpty() || nama.isEmpty() || jk.isEmpty() || telp.isEmpty() || alamat.isEmpty() || poin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua kolom!");
        return;
    }
        if (isEditMode) {
        JOptionPane.showMessageDialog(this, "Tidak bisa menyimpan. Silakan klik tombol 'Update' untuk mengedit data.");
        return; 
    }

        try {
            Connection conn =  Data.configDB();
            String sql = "INSERT INTO member (id_member, nama_member, jenis_kelamin, notelp_member, alamat_member, poin_member) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nama);
            pst.setString(3, jk);
            pst.setString(4, telp);
            pst.setString(5, alamat);
            pst.setInt(6, Integer.parseInt(poin));
            pst.executeUpdate();
            tampilData();
            javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Poin harus berupa angka!");
        }
        
    }//GEN-LAST:event_btnsaveActionPerformed

    public static void main(String args[]) {
        System.setProperty("sun.java2d.uiScale", "1");
      
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
            java.util.logging.Logger.getLogger(MembershipAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MembershipAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MembershipAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MembershipAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MembershipAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnpegawai;
    private javax.swing.JButton btnpembelian;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsupplier;
    private javax.swing.JButton btntreatment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jeniskelamin;
    private javax.swing.JTable tb_member;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtidmember;
    private javax.swing.JTextField txtnamamember;
    private javax.swing.JTextField txtpoin;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables
}
