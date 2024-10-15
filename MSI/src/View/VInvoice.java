/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.CSalary;
import Model.MDBConnection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;

/**
 *
 * @author USER
 */
public class VInvoice extends javax.swing.JFrame {

    /**
     * Creates new form VInvoice
     */
    public VInvoice() {
        initComponents();
        id_autoincrement();
        invoice_date.setDate(new Date());
    }
private int orderId;  // Store orderId here
public void clear(){

   txt_orderid1.setText(""); // Clear the product name field
    txt_orderid1.setText("");  // Clear the order ID field
    txt_qty.setText("");      // Clear the quantity field
    txt_totalamount.setText(""); // Clear the total amount field
    
    // Clear date picker
    invoice_date.setDate(null); // Reset the date picker

}
private int getLastInsertedInvoiceId() {
    int invoiceId = -1;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        con = MDBConnection.createConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT MAX(InvoiceID) AS last_id FROM Invoice"); // Adjust table name if necessary
        if (rs.next()) {
            invoiceId = rs.getInt("last_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return invoiceId;
}


public void generateInvoiceReport() {
    int lastInvoiceId = getLastInsertedInvoiceId(); // Fetch the last invoice ID
    try {
        // Step 1: Compile the Jasper report from .jrxml to .jasper
        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\invoice2.jrxml");
        
        // Step 2: Create a connection to the database
        Connection con = MDBConnection.createConnection();
        
        // Step 3: Fetch invoice data using InvoiceID
        String query = "SELECT InvoiceID, InvoiceDate, OrderID, ProductName, Qty, Total FROM Invoice WHERE InvoiceID = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, lastInvoiceId);  // Set the last InvoiceID for which you want the report
        ResultSet rs = pst.executeQuery();
        
        // Step 4: Convert ResultSet to JRDataSource
        JRResultSetDataSource jrDataSource = new JRResultSetDataSource(rs);
        
        // Step 5: Fill the report with the fetched data
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
        
        // Step 6: Display the report in JasperViewer
        JasperViewer.viewReport(jasperPrint, false);
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to generate invoice report: " + e.getMessage());
    }
}




 private void id_autoincrement(){
        
      try {
        var conn = MDBConnection.createConnection();
        String sql = "SELECT MAX(InvoiceID) FROM Invoice";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        int nextId = 1;  // Default ID if no records are found
        
        if (rs.next()) {
            int maxId = rs.getInt(1);
            nextId = maxId + 1;
        }
        
        // Set the nextId value to the txt_productid text field
        txt_invoice.setText(String.valueOf(nextId));

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    
    }
    }
    // Constructor to accept orderId
    

    // Method to populate order details using the passed orderId
    private void populateOrderDetails() {
        try {
            Connection conn = MDBConnection.createConnection();
            String sql = "SELECT ProductID, ProductName, Qty, TotalPrice FROM Orders WHERE OrderID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, orderId);  // Use the passed orderId here
            ResultSet rs = pst.executeQuery();
            
            // Populate your UI components, like JTable, labels, etc.
            while (rs.next()) {
                // Retrieve and display data
                int productId = rs.getInt("ProductID");
                String productName = rs.getString("ProductName");
                int qty = rs.getInt("Qty");
                int totalPrice = rs.getInt("TotalPrice");
                
                // Example: Populate some JTextFields or JTable here
                // txtProductId.setText(String.valueOf(productId));
                // txtProductName.setText(productName);
                // txtQty.setText(String.valueOf(qty));
                // txtTotalPrice.setText(String.valueOf(totalPrice));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // initComponents method here...

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
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_search1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_invoice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        invoice_date = new com.toedter.calendar.JDateChooser();
        txt_membername = new javax.swing.JLabel();
        txt_productn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_totalamount = new javax.swing.JTextField();
        btn_search2 = new javax.swing.JButton();
        txt_membername1 = new javax.swing.JLabel();
        txt_orderid1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INVOICE");

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btn_search1.setBackground(new java.awt.Color(0, 153, 153));
        btn_search1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_search1.setForeground(new java.awt.Color(255, 255, 255));
        btn_search1.setText("Genarate Invoice");
        btn_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Invoice ID");

        txt_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_invoiceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Invoice Date");

        txt_membername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_membername.setText("Products Name");

        txt_productn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Qty");

        txt_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtyActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("TotalBillAmount");

        txt_totalamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalamountActionPerformed(evt);
            }
        });

        btn_search2.setBackground(new java.awt.Color(0, 153, 153));
        btn_search2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_search2.setForeground(new java.awt.Color(255, 255, 255));
        btn_search2.setText("Payment");
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
            }
        });

        txt_membername1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_membername1.setText("OrderID");

        txt_orderid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_orderid1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invoice_date, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_membername1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_membername, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_productn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_orderid1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_qty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_totalamount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(357, 357, 357))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(btn_search1)
                .addGap(68, 68, 68)
                .addComponent(btn_search2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(invoice_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(95, 95, 95))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_membername)
                                    .addComponent(txt_productn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_search1)
                            .addComponent(btn_search2))
                        .addGap(104, 104, 104))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_membername1)
                            .addComponent(txt_orderid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(974, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
        VOrder vpmd =new VOrder();
        vpmd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search1ActionPerformed
       
        String productname = txt_productn.getText();
    java.util.Date utilDate = invoice_date.getDate();
    java.sql.Date sdate = new java.sql.Date(utilDate.getTime());
    int orderid = Integer.parseInt(txt_orderid1.getText());
    int qty = Integer.parseInt(txt_qty.getText());
    int total = Integer.parseInt(txt_totalamount.getText());

    // Insert data into the database
    try {
        Connection conn = MDBConnection.createConnection(); // Replace with your connection method

        // SQL query to insert data into the Invoice table
        String sql = "INSERT INTO Invoice (InvoiceDate, OrderID, ProductName, Qty, Total) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        // Set parameters for the prepared statement
        pst.setDate(1, sdate);
        pst.setInt(2, orderid);
        pst.setString(3, productname);
        pst.setInt(4, qty);
        pst.setInt(5, total);

        // Execute the insert statement
        int rowsInserted = pst.executeUpdate();

        // Check if the insertion was successful
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Invoice generated successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to generate invoice.");
        }

        conn.close(); // Close the connection
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error while generating invoice: " + e.getMessage());
    }
    generateInvoiceReport();
    
    
    
    id_autoincrement();
    


        // Clear previous data
        

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search1ActionPerformed

    private void txt_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_invoiceActionPerformed

  // TODO add your handling code here:
    }//GEN-LAST:event_txt_invoiceActionPerformed

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qtyActionPerformed

    private void txt_totalamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalamountActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed
 this.setVisible(false);
        VPayment vpmd =new VPayment();
        vpmd.setVisible(true);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search2ActionPerformed

    private void txt_orderid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_orderid1ActionPerformed
int orderId;
    try {
        orderId = Integer.parseInt(txt_orderid1.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid Order ID", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // SQL query to fetch order details based on OrderID
    String sql = "SELECT ProductName, Qty, TotalPrice FROM Orders WHERE OrderID = ?";

    try {
        // Establish a connection to the database
        Connection conn = MDBConnection.createConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, orderId);  // Set the OrderID in the query

        // Execute the query
        ResultSet rs = pst.executeQuery();

        // Check if we got a result
        if (rs.next()) {
            // Fetch the data from the result set
            String productName = rs.getString("ProductName");
            int qty = rs.getInt("Qty");
            int totalPrice = rs.getInt("TotalPrice");

            // Set the fetched data to the corresponding text fields
            txt_productn.setText(productName);
            txt_qty.setText(String.valueOf(qty));  // Convert int to String
            txt_totalamount.setText(String.valueOf(totalPrice));  // Convert int to String
        } else {
            // If no matching order found, show a message
            JOptionPane.showMessageDialog(this, "Order not found with ID: " + orderId, "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Close the connection
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching order details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_orderid1ActionPerformed

    private void txt_productnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productnActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productnActionPerformed

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
            java.util.logging.Logger.getLogger(VInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton btn_search2;
    private com.toedter.calendar.JDateChooser invoice_date;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_invoice;
    private javax.swing.JLabel txt_membername;
    private javax.swing.JLabel txt_membername1;
    private javax.swing.JTextField txt_orderid1;
    private javax.swing.JTextField txt_productn;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_totalamount;
    // End of variables declaration//GEN-END:variables
}
