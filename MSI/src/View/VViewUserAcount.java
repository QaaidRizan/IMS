/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JOptionPane;
import Model.MDBConnection;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class VViewUserAcount extends javax.swing.JFrame {

    /**
     * Creates new form VViewUserAcount
     */
    public VViewUserAcount() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        txt_display = new javax.swing.JButton();
        txt_userid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea8 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btn_search1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UserAcountID");

        txt_display.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txt_display.setText("Search");
        txt_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_displayActionPerformed(evt);
            }
        });

        txt_userid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_useridActionPerformed(evt);
            }
        });

        TextArea8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User_Name", "Password", "Name_With_Initials", "First_Name", "Last_Name", "Address", "Email", "Phone", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TextArea8);

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_search1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_search1.setText("Display");
        btn_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" User Acounts");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txt_display)
                .addGap(31, 31, 31)
                .addComponent(btn_search1)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(44, 44, 44))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(txt_display)
                    .addComponent(btn_search1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(974, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_displayActionPerformed
        // Validate the Order ID input
      DefaultTableModel model = (DefaultTableModel) TextArea8.getModel();
model.setRowCount(0); // Clear existing rows

String userId = txt_userid.getText(); // Get the User_ID from the text field

if (userId.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please enter a User ID.", "Error", JOptionPane.ERROR_MESSAGE);
    return; // Exit the method if no User ID is provided
}

try (Connection con = MDBConnection.createConnection();
     Statement st = con.createStatement();
     ResultSet rst = st.executeQuery("SELECT * FROM useraccount WHERE User_ID = " + userId)) {

    // Check if the result set contains any rows
    if (rst.next()) {
        // Add the row to the model
        model.addRow(new Object[]{
            rst.getInt("User_ID"),               // User_ID column
            rst.getString("User_Name"),           // User_Name column
            rst.getString("Password"),            // Password column
            rst.getString("Name_With_Initials"),  // Name_With_Initials column
            rst.getString("First_Name"),          // First_Name column
            rst.getString("Last_Name"),           // Last_Name column
            rst.getString("Address"),             // Address column
            rst.getString("Email"),               // Email column
            rst.getDate("Created_At"),            // Created_At column (use rst.getDate for date type)
            rst.getString("Phone"),               // Phone column
            rst.getDate("DOB"),                   // DOB column (use rst.getDate for date type)
            rst.getString("Role")                 // Role column
        });
    } else {
        // Show a message if no user is found with the given User_ID
        JOptionPane.showMessageDialog(null, "No user found with User ID: " + userId, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_displayActionPerformed

    private void txt_useridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_useridActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_useridActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
        VAdminDashboard vpmd =new VAdminDashboard();
        vpmd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search1ActionPerformed
        // Clear previous data
        DefaultTableModel model = (DefaultTableModel) TextArea8.getModel();
model.setRowCount(0); // Clear existing rows

try (Connection con = MDBConnection.createConnection();
     Statement st = con.createStatement();
     ResultSet rst = st.executeQuery("SELECT * FROM useraccount")) {

    // Loop through the result set and add each row to the model
    while (rst.next()) {
        model.addRow(new Object[]{
            rst.getInt("User_ID"),               // User_ID column
            rst.getString("User_Name"),           // User_Name column
            rst.getString("Password"),            // Password column
            rst.getString("Name_With_Initials"),  // Name_With_Initials column
            rst.getString("First_Name"),          // First_Name column
            rst.getString("Last_Name"),           // Last_Name column
            rst.getString("Address"),             // Address column
            rst.getString("Email"),               // Email column
            rst.getDate("Created_At"),            // Created_At column (use rst.getDate for date type)
            rst.getString("Phone"),               // Phone column
            rst.getDate("DOB"),                   // DOB column (use rst.getDate for date type)
            rst.getString("Role")                 // Role column
        });
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search1ActionPerformed

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
            java.util.logging.Logger.getLogger(VViewUserAcount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VViewUserAcount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VViewUserAcount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VViewUserAcount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VViewUserAcount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TextArea8;
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton txt_display;
    private javax.swing.JTextField txt_userid;
    // End of variables declaration//GEN-END:variables
}
