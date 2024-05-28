/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrameForm;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import master.MenuNavigasi;
import master.koneksi;

/**
 *
 * @author Asus
 */
public class Staff extends javax.swing.JFrame {

    /**
     * Creates new form Staff
     */
    public Staff() {
        initComponents();
        buka_tabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKontak = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtIdStaff = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Jabatan", "Kontak"
            }
        ));
        tblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaff);

        jLabel1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        jLabel1.setText("Form Staff Yudha Hotel");

        jLabel2.setText("ID Staff");

        jLabel3.setText("Nama");

        jLabel4.setText("Jabatan");

        jLabel5.setText("Kontak");

        btnSubmit.setText("Tambahkan");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKontak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubmit)
                            .addComponent(btnHapus)
                            .addComponent(btnEdit))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffMouseClicked

         int row = tblStaff.getSelectedRow();
         
        txtIdStaff.setText(tblStaff.getModel().getValueAt(row, 0).toString());
        
        txtNama.setText(tblStaff.getModel().
        getValueAt(row, 1).toString());
        
        txtJabatan.setText(tblStaff.getModel().
        getValueAt(row, 2).toString());
        
        txtKontak.setText(tblStaff.getModel().
        getValueAt(row, 3).toString());
        
        txtIdStaff.disable();
    }//GEN-LAST:event_tblStaffMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
                                                    
    String sql = "INSERT INTO tb_staff (id_staff, nama, jabatan, kontak) VALUES (?, ?, ?, ?)";
    try {
        java.sql.Connection conn = koneksi.ConnectionDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtIdStaff.getText());
//        pst.setInt(1, Integer.parseInt(txtIdStaff.getText()));
        pst.setString(2, txtNama.getText());
        pst.setString(3, txtJabatan.getText());
        pst.setString(4, txtKontak.getText());
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data inserted successfully!");
        
         // Clear the text fields after insertion
        clearFields();
        
        // Refresh the table
        refreshTable();
        
        buka_tabel();
        
    } catch (SQLException e) {
        // Handle any SQL errors
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error inserting data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
             try {
                // Hubungkan ke database
                java.sql.Connection conn = koneksi.ConnectionDB();

                // Buat pernyataan SQL update
                String sql = "UPDATE tb_staff SET "
                        + "nama = ?, "
                        + "jabatan = ?, "
                        + "kontak = ? "
                        + "WHERE id_staff = ?";

                // Siapkan pernyataan
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                // Set nilai parameter
                pst.setString(1, txtNama.getText());
                pst.setString(2, txtJabatan.getText());
                pst.setString(3, txtKontak.getText());
                pst.setInt(4, Integer.parseInt(txtIdStaff.getText()));
                

                // Eksekusi pernyataan
                pst.executeUpdate();

                // Tampilkan pesan sukses
                JOptionPane.showMessageDialog(null, "Data berhasil di Edit");

                // Bersihkan input
                txtIdStaff.setText("");
                txtNama.setText("");
                txtJabatan.setText("");
                txtKontak.setText("");
                txtIdStaff.setEnabled(true);
                
                txtIdStaff.requestFocusInWindow();

                // Refresh tabel
                buka_tabel();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Proses edit gagal: " + e.getMessage());
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
// Get the selected row index
    int selectedRow = tblStaff.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Get the id of the selected row
    String idStaff = tblStaff.getValueAt(selectedRow, 0).toString(); // Assuming id_barang is in the first column
    
    // Prompt the user to confirm deletion
    int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
        try {
            // Create SQL delete statement
            String sql = "DELETE FROM tb_staff WHERE id_staff = ?";
            
            // Connect to database and execute delete statement
            java.sql.Connection conn = koneksi.ConnectionDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idStaff);
            int rowsDeleted = pst.executeUpdate();
            
            // Check if deletion was successful
            if (rowsDeleted > 0) {
                // Refresh the table after deletion
                refreshTable();
                buka_tabel();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete record.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting record: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuNavigasi frameNavigasi = new MenuNavigasi();
        frameNavigasi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextField txtIdStaff;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

    private void refreshTable() {
    txtIdStaff.setText("");
    txtNama.setText("");
    txtJabatan.setText("");
    txtKontak.setText("");
    }

    private void clearFields() {
    DefaultTableModel model = (DefaultTableModel) tblStaff.getModel();
    model.setRowCount(0); // Clear the existing rows
    buka_tabel(); // Reload the data
    }

    private void buka_tabel() {
        
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id");
    model.addColumn("Nama");
    model.addColumn("Jabatan");
    model.addColumn("Kontak");
    try {
        String sql = "select * from tb_staff";
        java.sql.Connection conn = koneksi.ConnectionDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            model.addRow(new Object[]{res.getString(1), res.getString(2),
                res.getString(3), res.getString(4)});   
        }
        tblStaff.setModel(model);
    } catch (Exception e){
        e.printStackTrace();
    }
    }
}
