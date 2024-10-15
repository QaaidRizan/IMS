/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import Model.MReport;

/**
 *
 * @author moham
 */
public class AdminReports extends javax.swing.JFrame {

    
    
    
    
    /**
     * Creates new form NewJFrame
     */
    public AdminReports() {
        initComponents();
    }
@SuppressWarnings("unchecked")
    public void getReport1() {
       try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "")) {
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\ExpenseReport1.jrxml");
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText("SELECT * FROM expense");
            jdesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint, false);
        } catch (SQLException | JRException ex) {
            Logger.getLogger(VHrDashboard.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void getReport2() {
       try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "")) {
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\ProductReport1.jrxml");
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText("SELECT * FROM product");
            jdesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint, false);
        } catch (SQLException | JRException ex) {
            Logger.getLogger(VProductManagerDashboard.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void getReport3() {
       try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "")) {
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\OrderReport1.jrxml");
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText("SELECT * FROM orders");
            jdesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint, false);
        } catch (SQLException | JRException ex) {
            Logger.getLogger(VProductManagerDashboard.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void getReport4() {
       try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "")) {
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\StockReport1.jrxml");
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText("SELECT * FROM stock");
            jdesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint, false);
        } catch (SQLException | JRException ex) {
            Logger.getLogger(VStockManagerDashboard.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void getReport5() {
       try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "")) {
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\SupplierReport1.jrxml");
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText("SELECT * FROM supplier");
            jdesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint, false);
        } catch (SQLException | JRException ex) {
            Logger.getLogger(VStockManagerDashboard.class.getName()).log(Level.SEVERE,null, ex);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btn_OrderReport = new javax.swing.JButton();
        btn_ExpenceReport = new javax.swing.JButton();
        btn_ProductReport = new javax.swing.JButton();
        btn_StockReport = new javax.swing.JButton();
        btn_SupReport = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(301, 337));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Images\\hr.png")); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        btn_OrderReport.setBackground(new java.awt.Color(0, 153, 153));
        btn_OrderReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_OrderReport.setForeground(new java.awt.Color(255, 255, 255));
        btn_OrderReport.setText("Order Report");
        btn_OrderReport.setPreferredSize(new java.awt.Dimension(124, 30));
        btn_OrderReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OrderReportActionPerformed(evt);
            }
        });

        btn_ExpenceReport.setBackground(new java.awt.Color(0, 153, 153));
        btn_ExpenceReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_ExpenceReport.setForeground(new java.awt.Color(255, 255, 255));
        btn_ExpenceReport.setText("Expence Report");
        btn_ExpenceReport.setMaximumSize(new java.awt.Dimension(124, 30));
        btn_ExpenceReport.setMinimumSize(new java.awt.Dimension(124, 30));
        btn_ExpenceReport.setPreferredSize(new java.awt.Dimension(124, 30));
        btn_ExpenceReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExpenceReportActionPerformed(evt);
            }
        });

        btn_ProductReport.setBackground(new java.awt.Color(0, 153, 153));
        btn_ProductReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_ProductReport.setForeground(new java.awt.Color(255, 255, 255));
        btn_ProductReport.setText("Product Report");
        btn_ProductReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductReportActionPerformed(evt);
            }
        });

        btn_StockReport.setBackground(new java.awt.Color(0, 153, 153));
        btn_StockReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_StockReport.setForeground(new java.awt.Color(255, 255, 255));
        btn_StockReport.setText("Stock Report");
        btn_StockReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StockReportActionPerformed(evt);
            }
        });

        btn_SupReport.setBackground(new java.awt.Color(0, 153, 153));
        btn_SupReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_SupReport.setForeground(new java.awt.Color(255, 255, 255));
        btn_SupReport.setText("Supplier Report");
        btn_SupReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SupReportActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setText("All Reports");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_OrderReport, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_StockReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_SupReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ProductReport, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_ExpenceReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(72, 72, 72)
                .addComponent(btn_OrderReport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ExpenceReport, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ProductReport, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_StockReport, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_SupReport, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(974, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
        VAdminDashboard vpmd =new VAdminDashboard();
        vpmd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_OrderReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OrderReportActionPerformed
        getReport3();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_OrderReportActionPerformed

    private void btn_ExpenceReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExpenceReportActionPerformed
        getReport1();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ExpenceReportActionPerformed

    private void btn_ProductReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProductReportActionPerformed
        getReport2();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ProductReportActionPerformed

    private void btn_StockReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StockReportActionPerformed

        getReport4();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_StockReportActionPerformed

    private void btn_SupReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SupReportActionPerformed
        getReport5();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SupReportActionPerformed

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
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ExpenceReport;
    private javax.swing.JButton btn_OrderReport;
    private javax.swing.JButton btn_ProductReport;
    private javax.swing.JButton btn_StockReport;
    private javax.swing.JButton btn_SupReport;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
