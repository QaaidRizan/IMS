/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.CLogin;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author moham
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form Login_Page
     */
    public LoginPage() {
        initComponents();
       
    }
    
    // Assuming you have a JLabel named 'label_forgotpassword'



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        combrole = new javax.swing.JComboBox<>();
        labe_forgotpassword = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_password2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        ck_password2 = new javax.swing.JCheckBox();
        btn_login2 = new javax.swing.JButton();
        btn_clear2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_username2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combrole.setForeground(new java.awt.Color(255, 255, 255));
        combrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "ProductManager", "HR", "Cashier", "SalesManager", "StockManager" }));
        combrole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combroleActionPerformed(evt);
            }
        });
        jPanel1.add(combrole, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 203, -1));

        labe_forgotpassword.setForeground(new java.awt.Color(0, 153, 255));
        labe_forgotpassword.setText("Forgot Password");
        labe_forgotpassword.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                labe_forgotpasswordAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        labe_forgotpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labe_forgotpasswordMouseClicked(evt);
            }
        });
        jPanel1.add(labe_forgotpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 90, -1));

        jLabel14.setText("Username");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 109, -1));
        jPanel1.add(txt_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 200, -1));

        jLabel9.setText("Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 109, -1));

        ck_password2.setText("Show Password");
        ck_password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_password2ActionPerformed(evt);
            }
        });
        jPanel1.add(ck_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 119, -1));

        btn_login2.setBackground(new java.awt.Color(0, 153, 153));
        btn_login2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_login2.setForeground(new java.awt.Color(255, 255, 255));
        btn_login2.setText("Login");
        btn_login2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));

        btn_clear2.setBackground(new java.awt.Color(0, 153, 153));
        btn_clear2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_clear2.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear2.setText("Clear");
        btn_clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 51, 204));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("LOGIN");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 91, 25));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 384, -1, 137));

        txt_username2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username2ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 200, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(301, 337));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Images\\E.M.Sons.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 500));

        jLabel11.setText("Role");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 109, -1));

        Exit.setBackground(new java.awt.Color(204, 0, 0));
        Exit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jPanel1.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(836, 496));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void combroleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combroleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combroleActionPerformed

    private void ck_password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_password2ActionPerformed
        char echoChar = ck_password2.isSelected() ? (char) 0 : '*';
        txt_password2.setEchoChar(echoChar);        // TODO add your handling code here:
    }//GEN-LAST:event_ck_password2ActionPerformed

    private void btn_login2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login2ActionPerformed
        String role = combrole.getSelectedItem().toString();
        String username = txt_username2.getText().trim();
        String password = new String(txt_password2.getPassword());

        // Validation
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty!");
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty!");
            return;
        }

        if (role.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a role!");
            return;
        }

        // Proceed with login logic
        CLogin cl = new CLogin();
        ResultSet rst = null;

        try {
            rst = cl.Userlogin(role, username, password);

            switch (role) {
                case "ProductManager":
                if (rst.next()) {
                    this.setVisible(false);
                    VProductManagerDashboard vpmd = new VProductManagerDashboard();
                    vpmd.setVisible(true);
                } else {
                    showLoginError();
                }
                break;

                case "SalesManager":
                if (rst.next()) {
                    this.setVisible(false);
                    VSalesManagerDashboard vsmd = new VSalesManagerDashboard();
                    vsmd.setVisible(true);
                } else {
                    showLoginError();
                }
                break;

                case "StockManager":
                if (rst.next()) {
                    this.setVisible(false);
                    VStockManagerDashboard vsmd = new VStockManagerDashboard();
                    vsmd.setVisible(true);
                } else {
                    showLoginError();
                }
                break;

                case "Cashier":
                if (rst.next()) {
                    this.setVisible(false);
                    VCashierdashboard vcdb = new VCashierdashboard();
                    vcdb.setVisible(true);
                } else {
                    showLoginError();
                }
                break;

                case "HR":
                if (rst.next()) {
                    this.setVisible(false);
                    VHrDashboard vhrd = new VHrDashboard();
                    vhrd.setVisible(true);
                } else {
                    showLoginError();
                }
                break;

                case "Admin":
                ResultSet rst2 = cl.login(username, password);
                if (rst2.next()) {
                    this.setVisible(false);
                    VAdminDashboard vad = new VAdminDashboard();
                    vad.setVisible(true);
                } else {
                    showLoginError();
                }
                break;

                default:
                JOptionPane.showMessageDialog(null, "Invalid role selected!");
                break;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
        }
        private void showLoginError() {
            JOptionPane.showMessageDialog(null, "Check username and password!");
            clearFields();
    }//GEN-LAST:event_btn_login2ActionPerformed

    private void btn_clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear2ActionPerformed
        clearFields();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clear2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
        LoginPage vpmd =new LoginPage();
        vpmd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_username2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username2ActionPerformed

    private void labe_forgotpasswordAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_labe_forgotpasswordAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_labe_forgotpasswordAncestorAdded

    private void labe_forgotpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labe_forgotpasswordMouseClicked
        
          this.setVisible(false);
        VUserAcount vpmd =new VUserAcount();
        vpmd.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_labe_forgotpasswordMouseClicked

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed

       dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed
private void clearFields() {
        
        txt_username2.setText("");
        txt_password2.setText("");
        
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton btn_clear2;
    private javax.swing.JButton btn_login2;
    private javax.swing.JCheckBox ck_password2;
    private javax.swing.JComboBox<String> combrole;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labe_forgotpassword;
    private javax.swing.JPasswordField txt_password2;
    private javax.swing.JTextField txt_username2;
    // End of variables declaration//GEN-END:variables
}
