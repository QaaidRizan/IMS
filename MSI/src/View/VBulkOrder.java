/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.COrder;
import Model.MDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class VBulkOrder extends javax.swing.JFrame {

    /**
     * Creates new form VBulkOrder
     */
    public VBulkOrder() {
        initComponents();
        id_autoincrement();
         date_order.setDate(new java.util.Date());
    }

     private void id_autoincrement(){
        
      try {
        var conn = MDBConnection.createConnection();
        String sql = "SELECT MAX(BulkOrderID) FROM BulkOrder";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        int nextId = 1;  // Default ID if no records are found
        
        if (rs.next()) {
            int maxId = rs.getInt(1);
            nextId = maxId + 1;
        }
        
        // Set the nextId value to the txt_productid text field
        txt_bulkorderid.setText(String.valueOf(nextId));

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    
    }
    }

       public void clearField(){
    
                txt_productname.setText("");
                txt_total.setText(null); 
                date_order.setDate(null);
                 txt_avbqty.setText(null); 
                  txt_qty.setText(null);
                   txt_price.setText(null);
                    txt_productid.setText(null); 
               
    
    
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
        jLabel2 = new javax.swing.JLabel();
        txt_membername = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_Update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_Add = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        txt_avbqty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        txt_productname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_productid = new javax.swing.JTextField();
        date_order = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_bulkorderid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Product ID");

        txt_membername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_membername.setText("Total ");

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        btn_Update.setBackground(new java.awt.Color(0, 153, 153));
        btn_Update.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_Update.setForeground(new java.awt.Color(255, 255, 255));
        btn_Update.setText("Update");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(0, 153, 153));
        btn_clear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_Add.setBackground(new java.awt.Color(0, 153, 153));
        btn_Add.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_Add.setForeground(new java.awt.Color(255, 255, 255));
        btn_Add.setText("Add");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_Delete.setBackground(new java.awt.Color(0, 153, 153));
        btn_Delete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Delete.setText("Delete");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        txt_avbqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_avbqtyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Avalable Qty");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Qty");

        txt_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtyActionPerformed(evt);
            }
        });

        txt_productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productnameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Product Name");

        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Product Price");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(301, 337));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Images\\or.png")); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel9.setText("Bulk Orders");

        txt_productid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productidActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Order Date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Bulk Order ID");

        txt_bulkorderid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bulkorderidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_membername)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_productid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_bulkorderid)
                                .addComponent(date_order, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_avbqty, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_productname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Add)
                        .addGap(29, 29, 29)
                        .addComponent(btn_Update)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Delete)
                        .addGap(31, 31, 31)
                        .addComponent(btn_clear)
                        .addGap(101, 101, 101))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_bulkorderid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_productid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_avbqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_membername))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Add)
                    .addComponent(btn_Update)
                    .addComponent(btn_Delete)
                    .addComponent(btn_clear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(974, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_productidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productidActionPerformed

        int productid = Integer.parseInt(txt_productid.getText());

        if (productid == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the product ID to view details");
            return;
        }

        try {
            try (Connection conn = MDBConnection.createConnection()) {
                String sql = "SELECT ProductName,Qty,Price FROM Product WHERE ProductID = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, productid);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    txt_productname.setText(rs.getString("ProductName"));
                    int currentqty = rs.getInt("Qty");
                    txt_avbqty.setText(String.valueOf(currentqty));

                    int price = rs.getInt("Price");
                    txt_price.setText(String.valueOf(price));

                } else {
                    JOptionPane.showMessageDialog(null, "Product ID not found");
                }       }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving product details: " + e.getMessage());
            }

            // TODO add your handling code here:
    }//GEN-LAST:event_txt_productidActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
        VSalesManagerDashboard vpmd =new VSalesManagerDashboard();
        vpmd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productnameActionPerformed

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed
        int qty = Integer.parseInt(txt_qty.getText());
        int productid = Integer.parseInt(txt_productid.getText());

        // Check if quantity is zero
        if (qty == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity greater than zero.");
            return; // Exit the method to prevent further execution
        }

        try (Connection conn = MDBConnection.createConnection()) {
            // Prepare the SQL query to get the price of the product by its ID
            String sql = "SELECT Price, Qty FROM Product WHERE ProductID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, productid);
            ResultSet rs = pst.executeQuery();

            // Check if the product exists
            if (rs.next()) {
                // Fetch the price and current quantity from the database
                int price = rs.getInt("Price");
                int currentQty = rs.getInt("Qty");

                // Check if there is enough quantity in stock
                if (qty > currentQty) {
                    JOptionPane.showMessageDialog(null, "Not enough quantity in stock");
                    return; // Exit the method to prevent further execution
                }

                // Calculate the total price based on quantity
                int total = price * qty;

                // Set the total in the text field for display
                txt_total.setText(String.valueOf(total));

                // Now reduce the quantity in the Product table
                String updateProductSql = "UPDATE product SET Qty = Qty - ? WHERE productID = ?";
                PreparedStatement pstUpdate = conn.prepareStatement(updateProductSql);
                pstUpdate.setInt(1, qty);
                pstUpdate.setInt(2, productid);

                int updateCount = pstUpdate.executeUpdate(); // Execute the update

                if (updateCount > 0) {
                    // Update successful, notify the user

                } else {
                    // If update fails

                }

            } else {
                // If product ID is not found, show an error message

            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error processing order: " + e.getMessage());
        }
    }//GEN-LAST:event_txt_qtyActionPerformed

    private void txt_avbqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_avbqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_avbqtyActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        if (txt_bulkorderid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Order ID cannot be empty");
            return;
        }

         int bulkOrderId = Integer.parseInt(txt_bulkorderid.getText());  // BulkOrderID

    Connection con = null;
    PreparedStatement pst = null;

    try {
        con = MDBConnection.createConnection();
        String sql = "DELETE FROM BulkOrder WHERE BulkOrderID = ?";

        pst = con.prepareStatement(sql);
        pst.setInt(1, bulkOrderId);  // Set BulkOrderID for deletion

        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this bulk order?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bulk Order deleted successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting Bulk Order: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        clearField();
        id_autoincrement();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed

        if (!validateInputs()) {
            return;
        }

      int bulkOrderId = Integer.parseInt(txt_bulkorderid.getText());  // BulkOrderID (Optional if it's auto-increment)
int productId = Integer.parseInt(txt_productid.getText());      // ProductID
java.util.Date utilOrderDate = date_order.getDate();            // BulkOrderDate
java.sql.Date sqlcreatedate = new java.sql.Date(utilOrderDate.getTime());
int qty = Integer.parseInt(txt_qty.getText());                  // Qty
int totalPrice = Integer.parseInt(txt_total.getText());         // TotalPrice
String productName = txt_productname.getText();                 // ProductName

Connection con = null;
PreparedStatement pst = null;

try {
    con = MDBConnection.createConnection();  // Assuming MDBConnection is your DB connection helper class
    String sql = "INSERT INTO BulkOrder (BulkOrderDate, ProductID, Qty, TotalPrice, ProductName) VALUES (?, ?, ?, ?, ?)";
    
    pst = con.prepareStatement(sql);
    pst.setDate(1, sqlcreatedate);  // Set BulkOrderDate
    pst.setInt(2, productId);       // Set ProductID
    pst.setInt(3, qty);             // Set Qty
    pst.setInt(4, totalPrice);      // Set TotalPrice
    pst.setString(5, productName);  // Set ProductName
    
    pst.executeUpdate();
    
    JOptionPane.showMessageDialog(null, "Bulk Order added successfully!");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error adding Bulk Order: " + e.getMessage());
} finally {
    try {
        if (pst != null) pst.close();
        if (con != null) con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Clear fields after the operation if needed
clearField();


       
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearField();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        if (!validateInputs()) {
            return;
        }
int bulkOrderId = Integer.parseInt(txt_bulkorderid.getText());  // BulkOrderID
    int productId = Integer.parseInt(txt_productid.getText());      // ProductID
    java.util.Date utilOrderDate = date_order.getDate();            // BulkOrderDate
    java.sql.Date sqlcreatedate = new java.sql.Date(utilOrderDate.getTime());
    int qty = Integer.parseInt(txt_qty.getText());                  // Qty
    int totalPrice = Integer.parseInt(txt_total.getText());         // TotalPrice
    String productName = txt_productname.getText();                 // ProductName

    Connection con = null;
    PreparedStatement pst = null;

    try {
        con = MDBConnection.createConnection();
        String sql = "UPDATE BulkOrder SET BulkOrderDate = ?, ProductID = ?, Qty = ?, TotalPrice = ?, ProductName = ? WHERE BulkOrderID = ?";

        pst = con.prepareStatement(sql);
        pst.setDate(1, sqlcreatedate);    // Set BulkOrderDate
        pst.setInt(2, productId);         // Set ProductID
        pst.setInt(3, qty);               // Set Qty
        pst.setInt(4, totalPrice);        // Set TotalPrice
        pst.setString(5, productName);    // Set ProductName
        pst.setInt(6, bulkOrderId);       // Where BulkOrderID

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Bulk Order updated successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating Bulk Order: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }clearField();
     id_autoincrement();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed

        int qty = Integer.parseInt(txt_qty.getText());
        int productid = Integer.parseInt(txt_productid.getText());

        if (qty == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the product ID to view details");
            return;
        }

        try {
            try (Connection conn = MDBConnection.createConnection()) {
                String sql = "SELECT Price FROM Product WHERE ProductID = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, productid);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    int price = rs.getInt("Price");
                    int total;
                    total = price * qty;
                    txt_total.setText(String.valueOf(total));

                } else {
                    JOptionPane.showMessageDialog(null, "Product ID not found");
                }       }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving product details: " + e.getMessage());
            }
            // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_bulkorderidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bulkorderidActionPerformed
        //id_autoincrement();
        int orderid=Integer.parseInt(txt_bulkorderid.getText());
        if (orderid==0) {
            JOptionPane.showMessageDialog(null, "Please enter the Order ID to view details");
            return;
        }

        try {
            Connection conn = MDBConnection.createConnection();
            String sql = "SELECT ProductID,BulkOrderDate, Qty, TotalPrice FROM BulkOrder WHERE BulkOrderID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, orderid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Assuming these text fields are defined and used for displaying member details

                txt_productid.setText(rs.getString("ProductID"));
                int total = rs.getInt("TotalPrice");
                txt_total.setText(String.valueOf(total));
                int qty = rs.getInt("Qty");
                txt_qty.setText(String.valueOf(qty));
                date_order.setDate(rs.getDate("BulkOrderDate"));

            } else {
                JOptionPane.showMessageDialog(null, "Product ID not found");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving product details: " + e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bulkorderidActionPerformed

     private boolean validateInputs() {
    if (txt_bulkorderid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Order ID cannot be empty");
        return false;
    }
    
    if (txt_productid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Product ID cannot be empty");
        return false;
    }

    if (txt_qty.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Quantity cannot be empty");
        return false;
    }

    if (txt_total.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Total cannot be empty");
        return false;
    }

    try {
        Integer.parseInt(txt_bulkorderid.getText());
        Integer.parseInt(txt_productid.getText());
        Integer.parseInt(txt_qty.getText());
        Integer.parseInt(txt_total.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter valid numeric values");
        return false;
    }

    if (date_order.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Order Date cannot be empty");
        return false;
    }

    return true;
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
            java.util.logging.Logger.getLogger(VBulkOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VBulkOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VBulkOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VBulkOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VBulkOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_clear;
    private com.toedter.calendar.JDateChooser date_order;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_avbqty;
    private javax.swing.JTextField txt_bulkorderid;
    private javax.swing.JLabel txt_membername;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_productid;
    private javax.swing.JTextField txt_productname;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
