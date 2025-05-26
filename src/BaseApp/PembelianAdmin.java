package BaseApp;

import java.awt.Color;
import java.awt.Component;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PembelianAdmin extends javax.swing.JFrame {
    boolean isEditMode = false;
    
    public PembelianAdmin() {
        setUndecorated(true);
        initComponents();
        idsupplier.setOpaque(false);
        kdproduk.setOpaque(false);
        idsupplier.setBackground(new Color(0, 0, 0, 0));
        kdproduk.setBackground(new Color(0, 0, 0, 0));
        idsupplier.setForeground(Color.WHITE);
        kdproduk.setForeground(Color.WHITE);
        idsupplier.setBorder(null);
        kdproduk.setBorder(null);
        //buat dropdown transparan
        idsupplier.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
            return c;
}
});
         kdproduk.setRenderer(new DefaultListCellRenderer() {
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
        
            javax.swing.event.DocumentListener autoHitungListener = new javax.swing.event.DocumentListener() {
        private void updateTotal() {
            try {
                int jumlah = Integer.parseInt(txtjumlah.getText());
                int subtotal = Integer.parseInt(txtsubtotal.getText());
                int total = jumlah * subtotal;
                txttotalbeli.setText(String.valueOf(total));
            } catch (NumberFormatException e) {
                // Kosongkan jika input belum valid
                txttotalbeli.setText("");
            }
        }

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            updateTotal();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            updateTotal();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            updateTotal();
        }
    };

    // Tambahkan listener ke txtjumlah dan txtsubtotal
    txtjumlah.getDocument().addDocumentListener(autoHitungListener);
    txtsubtotal.getDocument().addDocumentListener(autoHitungListener);
        
    DefaultTableModel model = new DefaultTableModel(
    new Object[][]{},
    new String[]{
        "Nama Supplier",   // Hanya tampilkan nama, bukan ID
        "Kd Produk", 
        "Nama Produk",
        "Tanggal Beli",
        "Total Beli"
    }
) {
    @Override 
    public boolean isCellEditable(int row, int col) {
        return false;
    }
};
    String idUser = SessionLogin.getUsername();
    tb_pembelian.setModel(model);


       tb_pembelian.setModel(model);
       tb_pembelian.getColumnModel().getColumn(0).setPreferredWidth(150); 
        tb_pembelian.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tb_pembelian.getColumnModel().getColumn(2).setPreferredWidth(145); 
        tb_pembelian.getColumnModel().getColumn(3).setPreferredWidth(130); 
        tb_pembelian.getColumnModel().getColumn(4).setPreferredWidth(150); 
       loadComboBoxData();
       tb_pembelian.setRowHeight(27);
       tampilData();
    tb_pembelian.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int row = tb_pembelian.getSelectedRow();
            if (row >= 0) {
                
                int modelRow = tb_pembelian.convertRowIndexToModel(row);
                String idBeli = model.getValueAt(modelRow, 0).toString();        // id_beli
                String idSupplier = model.getValueAt(modelRow, 1).toString();
                String kdProduk   = tb_pembelian.getModel().getValueAt(row, 3).toString();
                String totalBeli  = tb_pembelian.getModel().getValueAt(row, 6).toString();

                // Pilih supplier di combo
                for (int i = 0; i < idsupplier.getItemCount(); i++) {
                    String item = idsupplier.getItemAt(i);
                    if (item.startsWith(idSupplier + " -")) {
                        idsupplier.setSelectedIndex(i);
                        break;
                    }
                }
                // Pilih produk di combo
                for (int i = 0; i < kdproduk.getItemCount(); i++) {
                    String item = kdproduk.getItemAt(i);
                    if (item.startsWith(kdProduk + " -")) {
                        kdproduk.setSelectedIndex(i);
                        break;
                    }
                }
                
                isEditMode = true;
                txttotalbeli.setText(totalBeli);
                // Kalau Anda mau tetap mengisi txtjumlah & txtsubtotal,
                // ambil dari datasource lain, atau tambahkan kolom di model tabel.
            }
        }
    });

 }
    
    
private String getIdFromComboBoxItem(String item) {
    // Misal item: "S001 - Toko A"
    return item.split(" - ")[0]; // Ambil ID: "S001"
}

private String getNamaFromComboBoxItem(String item) {
    return item.split(" - ")[1]; // Ambil nama: "Toko A"
}

private void tampilData() {
    DefaultTableModel model = (DefaultTableModel) tb_pembelian.getModel();
    model.setRowCount(0);

    String sql = """
        SELECT 
               p.id_beli, 
               p.id_supplier, s.nama_supplier,
               p.kd_produk,   pr.nama_produk,
               p.tgl_beli,    p.total_beli
        FROM pembelian p
        JOIN supplier s ON p.id_supplier = s.id_supplier
        JOIN produk pr ON p.kd_produk = pr.kd_produk
        ORDER BY p.tgl_beli DESC
        """;

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
         Statement   st   = conn.createStatement();
         ResultSet   rs   = st.executeQuery(sql)) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("nama_supplier"),    
                rs.getString("kd_produk"),        
                rs.getString("nama_produk"),      
                rs.getTimestamp("tgl_beli"),      
                rs.getInt("total_beli")  
            });
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal tampilkan data: " + ex.getMessage());
    }
}

private void loadComboBoxData() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
         Statement stmt = conn.createStatement()) {
        
        idsupplier.removeAllItems();
        kdproduk.removeAllItems();

        // Tambahkan item default
        idsupplier.addItem("Pilih Supplier");
        kdproduk.addItem("Pilih Produk");
        
        // Supplier
        ResultSet rs1 = stmt.executeQuery("SELECT id_supplier, nama_supplier FROM supplier");
        while (rs1.next()) {
            idsupplier.addItem(
                rs1.getString("id_supplier")
              + " - "
              + rs1.getString("nama_supplier")
            );
        }
        // Produk
        ResultSet rs2 = stmt.executeQuery("SELECT kd_produk, nama_produk FROM produk");
        while (rs2.next()) {
            kdproduk.addItem(
                rs2.getString("kd_produk")
              + " - "
              + rs2.getString("nama_produk")
            );
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal load combo: " + ex.getMessage());
    }
}


  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btntreatment = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnsupplier = new javax.swing.JButton();
        btnmembership = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnpegawai = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        idsupplier = new javax.swing.JComboBox<>();
        kdproduk = new javax.swing.JComboBox<>();
        txtjumlah = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        txttotalbeli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pembelian = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntreatment.setContentAreaFilled(false);
        btntreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntreatment.png"))); // NOI18N
        btntreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtreatment.png"))); // NOI18N
        btntreatment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntreatmentMouseEntered(evt);
            }
        });
        btntreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntreatmentActionPerformed(evt);
            }
        });
        jPanel1.add(btntreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));

        btnproduk.setContentAreaFilled(false);
        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnproduk.png"))); // NOI18N
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));

        btnsupplier.setContentAreaFilled(false);
        btnsupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsupplier.png"))); // NOI18N
        btnsupplier.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsupplier.png"))); // NOI18N
        btnsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplierActionPerformed(evt);
            }
        });
        jPanel1.add(btnsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));

        btnmembership.setContentAreaFilled(false);
        btnmembership.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnmembership.png"))); // NOI18N
        btnmembership.setToolTipText("");
        btnmembership.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgmembership.png"))); // NOI18N
        btnmembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmembershipActionPerformed(evt);
            }
        });
        jPanel1.add(btnmembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 90));

        btnlaporan.setContentAreaFilled(false);
        btnlaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, 90));

        btnpegawai.setContentAreaFilled(false);
        btnpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawai.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 90));

        btnback.setContentAreaFilled(false);
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 90, -1));

        btnedit.setContentAreaFilled(false);
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnedit.png"))); // NOI18N
        btnedit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgedit.png"))); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 890, -1, -1));
        btnedit.setBorderPainted(false);

        btnsave.setContentAreaFilled(false);
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsave.png"))); // NOI18N
        btnsave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsave.png"))); // NOI18N
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, -1, -1));

        idsupplier.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jPanel1.add(idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 390, 30));

        kdproduk.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jPanel1.add(kdproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 367, 390, 30));

        txtjumlah.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtjumlah.setBorder(null);
        jPanel1.add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 390, 30));

        txtsubtotal.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txtsubtotal.setBorder(null);
        jPanel1.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 512, 390, 30));

        txttotalbeli.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        txttotalbeli.setBorder(null);
        jPanel1.add(txttotalbeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 584, 390, 30));

        tb_pembelian.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_pembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Supplier", "Kd Produk", "Nama Produk", "Jumlah", "Subtota;", "Total Beli"
            }
        ));
        jScrollPane1.setViewportView(tb_pembelian);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 670, 550));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/PembelianAdminn.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        // TODO add your handling code here:
        new TreatmentAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btntreatmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntreatmentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btntreatmentMouseEntered

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

    private void btnmembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipActionPerformed
        // TODO add your handling code here:
        new MembershipAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmembershipActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpegawaiActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
        new Laporan1().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
              String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        try {
        int selectedRow = tb_pembelian.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit di tabel.");
            return;
        }
        if (idsupplier.getSelectedIndex() == 0 || kdproduk.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Silakan pilih supplier dan produk yang valid.");
        return;
    }

        String[] supplierSplit = idsupplier.getSelectedItem().toString().split(" - ");
        String[] produkSplit = kdproduk.getSelectedItem().toString().split(" - ");

        if (supplierSplit.length < 2 || produkSplit.length < 2) {
        JOptionPane.showMessageDialog(this, "Format data combo box tidak sesuai.");
        return;
    }

        String idSupplier = supplierSplit[0];
        String namaSupplier = supplierSplit[1];
        String kdProduk = produkSplit[0];
        String namaProduk = produkSplit[1];

        int jumlah = Integer.parseInt(txtjumlah.getText());
        double subtotal = Double.parseDouble(txtsubtotal.getText());
        double total = Double.parseDouble(txttotalbeli.getText());
        

        String idBeli = tb_pembelian.getValueAt(selectedRow, 0).toString(); // Gunakan id_beli sebagai primary key

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
        String sql = "UPDATE pembelian SET id_supplier=?, kd_produk=?, total_beli=? WHERE id_beli=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, idSupplier);
        pst.setString(2, kdProduk);
        pst.setDouble(3, total);
        pst.setString(4, idBeli);  // Pastikan menggunakan id_beli sebagai acuan update

        pst.executeUpdate();
        conn.close();


        JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
        tampilData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal edit: " + e.getMessage());
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
    String idSupplier = (String) idsupplier.getSelectedItem();
    String kdProduk = (String) kdproduk.getSelectedItem();
    String totalBeliStr = txttotalbeli.getText();
    

    if (idSupplier == null || idSupplier.trim().isEmpty() ||
        kdProduk == null || kdProduk.trim().isEmpty() ||
        totalBeliStr == null || totalBeliStr.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua kolom sebelum menyimpan.");
        return;
    }

    if (isEditMode) {
        JOptionPane.showMessageDialog(this, "Tidak bisa menyimpan. Silakan klik tombol 'Update' untuk mengedit data.");
        return;
    }
    
    String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }

    int totalBeli;
    try {
        totalBeli = Integer.parseInt(totalBeliStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Total Beli harus berupa angka!");
        return;
    }

    String idSupplierFix = idSupplier.split(" - ")[0];
    String kdProdukFix = kdProduk.split(" - ")[0];

    String sql = """
        INSERT INTO pembelian
          (id_user, id_supplier, kd_produk, tgl_beli, total_beli)
        VALUES
          (?, ?, ?, NOW(), ?)
    """;

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
         PreparedStatement pst = conn.prepareStatement(sql)) {


        pst.setString(1, username);
        pst.setString(2, idSupplierFix);
        pst.setString(3, kdProdukFix);
        pst.setInt(4, totalBeli);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        tampilData();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal simpan: " + ex.getMessage());
    }

    }//GEN-LAST:event_btnsaveActionPerformed

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
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PembelianAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpegawai;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsupplier;
    private javax.swing.JButton btntreatment;
    private javax.swing.JComboBox<String> idsupplier;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kdproduk;
    private javax.swing.JTable tb_pembelian;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotalbeli;
    // End of variables declaration//GEN-END:variables
}
