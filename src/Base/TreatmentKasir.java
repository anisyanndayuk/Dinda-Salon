/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Base;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class TreatmentKasir extends javax.swing.JFrame {

    /**
     * Creates new form TreatmentKasir
     */
    public TreatmentKasir() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            LoadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak berhasil tampil! Error: " + e.getMessage());
        }
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
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnPembelian = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnTreatment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_treatment = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(936, 666));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/back100.png"))); // NOI18N
        btnBack.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/back50.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 580, 73, 70));

        btnMember.setContentAreaFilled(false);
        btnMember.setBorderPainted(false);
        btnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnMembership100.png"))); // NOI18N
        btnMember.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnMembership50.png"))); // NOI18N
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });
        jPanel2.add(btnMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 290, 73, 70));

        btnTransaksi.setBorderPainted(false);
        btnTransaksi.setContentAreaFilled(false);
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnTransaksi100.png"))); // NOI18N
        btnTransaksi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnTransaksi50.png"))); // NOI18N
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        jPanel2.add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 220, 73, 70));

        btnPembelian.setBorderPainted(false);
        btnPembelian.setContentAreaFilled(false);
        btnPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnPembelian100.png"))); // NOI18N
        btnPembelian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnPembelian50.png"))); // NOI18N
        btnPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembelianActionPerformed(evt);
            }
        });
        jPanel2.add(btnPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 150, 73, 70));

        btnProduct.setBorderPainted(false);
        btnProduct.setContentAreaFilled(false);
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnProduk100.png"))); // NOI18N
        btnProduct.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnProduk50.png"))); // NOI18N
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        jPanel2.add(btnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 73, 70));

        btnTreatment.setBorderPainted(false);
        btnTreatment.setContentAreaFilled(false);
        btnTreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnTreatment100.png"))); // NOI18N
        btnTreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnTreatment50.png"))); // NOI18N
        btnTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreatmentActionPerformed(evt);
            }
        });
        jPanel2.add(btnTreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 73, 70));

        tb_treatment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kategori", "Nama Layanan", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_treatment);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 660, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designKasir/Treatment (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatmentActionPerformed
        TreatmentKasir abal = new TreatmentKasir();
        abal.setVisible(true);
        abal.pack();
        abal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnTreatmentActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        ProductKasir abal = new ProductKasir();
        abal.setVisible(true);
        abal.pack();
        abal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembelianActionPerformed
        PembelianKasir abal = new PembelianKasir();
        abal.setVisible(true);
        abal.pack();
        abal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnPembelianActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        TransaksiKasir abal = new TransaksiKasir();
        abal.setVisible(true);
        abal.pack();
        abal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
        MemberKasir abal = new MemberKasir();
        abal.setVisible(true);
        abal.pack();
        abal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnMemberActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new DashboardKasir().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed
    public void LoadData() throws java.sql.SQLException {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String Query = "SELECT layanan.id_layanan, layanan.nama_layanan, "
                + "layanan.harga_layanan, kategori_layanan.keterangan FROM layanan JOIN kategori_layanan "
                + "ON layanan.id_kategori = kategori_layanan.id_kategori";
        
        try {
            Connection connect = java.sql.DriverManager.getConnection(url, user, pw);
            java.sql.Statement stm = connect.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(Query);
            
            DefaultTableModel model = (DefaultTableModel) tb_treatment.getModel();
            model.setRowCount(0);
            
            while (rs.next()) {                
                Object[] row = {
                rs.getString("id_layanan"),
                rs.getString("keterangan"),
                rs.getString("nama_layanan"),
                rs.getString("harga_layanan")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data tidak bisa tampil! Error: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreatmentKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnPembelian;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnTreatment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_treatment;
    // End of variables declaration//GEN-END:variables
}
