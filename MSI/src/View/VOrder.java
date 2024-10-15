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
import Model.MDBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import com.toedter.calendar.JDateChooser;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author USER
 */
public class VOrder extends javax.swing.JFrame {

    /**
     * Creates new form VBulkOrder
     */
    public VOrder() {
        initComponents();
         id_autoincrement();
          date_order.setDate(new java.util.Date());
       
    
    }
    private int orderId;
    
    private DefaultTableModel tableModel;
    private void updateGrandTotal(DefaultTableModel tableModel) {
    int rowCount = tableModel.getRowCount(); // Get the number of rows in the table
    int grandTotal = 0;  // Initialize the grand total

    // Loop through each row in the table to calculate the grand total
    for (int i = 0; i < rowCount; i++) {
        // Assuming the total price for each product is in the 4th column (index 3)
        Object value = tableModel.getValueAt(i, 3);
        if (value != null) {
            grandTotal += (Integer) value;  // Add the total price of each row to the grand total
        }
    }

    // Update the total price field (txt_total)
    txt_total.setText(String.valueOf(grandTotal));
}


    private int getLastInsertedOrderId() {
    int orderId = -1;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        con = MDBConnection.createConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT MAX(OrderID) AS last_id FROM Orders");
        if (rs.next()) {
            orderId = rs.getInt("last_id");
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

    return orderId;
}
   
 public void addOrderDetail(Date orderDate, int totalQty, int totalPrice, String productNames) {
    Connection con = null;
    PreparedStatement pst = null;

    try {
        con = MDBConnection.createConnection();
        String sql = "INSERT INTO orders (OrderDate, Qty, TotalPrice, ProductName) VALUES (?, ?, ?, ?)";
        pst = con.prepareStatement(sql);

        // Set the values for the SQL query
        pst.setDate(1, new java.sql.Date(orderDate.getTime())); // OrderDate
        pst.setInt(2, totalQty);                                // TotalQty
        pst.setInt(3, totalPrice);                             // TotalPrice
        pst.setString(4, productNames);                        // ProductNames

        // Execute the query
        int count = pst.executeUpdate();

        // Check if the record was successfully added
        if (count > 0) {
           // JOptionPane.showMessageDialog(null, "Order Details Added!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



private void addOrder() {
    // Retrieve the order date from the date picker
    java.util.Date utilOrderDate = date_order.getDate();
    if (utilOrderDate == null) {
        JOptionPane.showMessageDialog(this, "Please select a valid date", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    java.sql.Date sqlOrderDate = new java.sql.Date(utilOrderDate.getTime());

    // Retrieve the table model from jTable1
    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

    // Initialize variables for aggregated data
    int totalQty = 0;
    int totalPrice = 0;
    StringBuilder productDetails = new StringBuilder(); // To store product details in the format "productName (qty)"

    // Loop through the rows of the table to aggregate data
    int rowCount = tableModel.getRowCount();
    for (int i = 0; i < rowCount; i++) {
        // Retrieve values from each row with null checks
        Integer productId = (Integer) tableModel.getValueAt(i, 0); // ProductID
        String productName = (String) tableModel.getValueAt(i, 1); // ProductName
        Integer qty = (Integer) tableModel.getValueAt(i, 2); // Quantity
        Integer price = (Integer) tableModel.getValueAt(i, 3); // TotalPrice

        // Handle possible null values
        if (productId == null) productId = 0;
        if (productName == null) productName = "";
        if (qty == null) qty = 0;
        if (price == null) price = 0;

        // Skip rows with quantity 0
        if (qty > 0) {
            // Aggregate data
            totalQty += qty;
            totalPrice += price;

            // Append product details in the format "productName (qty)"
            if (productDetails.length() > 0) {
                productDetails.append(", "); // Add comma separator
            }
            productDetails.append(productName).append(" (").append(qty).append(")");
        }

        // Optionally, remove the processed row from the table
        tableModel.removeRow(i);
        i--; // Adjust index after removal
        rowCount--; // Adjust row count after removal
    }

    // Insert aggregated data into the database
    addOrderDetail(sqlOrderDate, totalQty, totalPrice, productDetails.toString());

    // Assuming getLastInsertedOrderId() retrieves the last inserted order
    int orderId = getLastInsertedOrderId();

    // Generate the report for the current order
  

    // Optionally, show a success message
    JOptionPane.showMessageDialog(this, "Order Added Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
   
}


private void loadOrderDetailsToCart() {
    // Get the Order ID from the input field
    int orderId = Integer.parseInt(txt_orderid.getText().trim());
    if (orderId == 0) {
        JOptionPane.showMessageDialog(null, "Please enter the Order ID to view details");
        return;
    }

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

    try {
        conn = MDBConnection.createConnection();

        // Step 1: Fetch order details
        String sqlOrderDetails = "SELECT OrderDate FROM Orders WHERE OrderID = ?";
        pst = conn.prepareStatement(sqlOrderDetails);
        pst.setInt(1, orderId);
        rs = pst.executeQuery();

        if (rs.next()) {
            // Assuming these text fields are defined and used for displaying member details
            date_order.setDate(rs.getDate("OrderDate"));
        } else {
            JOptionPane.showMessageDialog(null, "Order ID not found");
            return;
        }

        // Clear the existing rows in the cart table before adding new data
        tableModel.setRowCount(0);

        // Step 2: Fetch products associated with the order
        String sqlOrderProducts = "SELECT ProductID, ProductName, Qty, TotalPrice FROM orders WHERE OrderID = ?";
        pst = conn.prepareStatement(sqlOrderProducts);
        pst.setInt(1, orderId);
        rs = pst.executeQuery();

        while (rs.next()) {
            // Add each product to the cart table
            int productId = rs.getInt("ProductID");
            String productName = rs.getString("ProductName");
            int qty = rs.getInt("Qty");
            int price = rs.getInt("TotalPrice");

            tableModel.addRow(new Object[]{productId, productName, qty, price});
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving order details: " + e.getMessage());
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void populateTableWithOrderData(int orderId) {
    try {
        Connection conn = MDBConnection.createConnection();
        String sql = "SELECT ProductID, ProductName, Qty, TotalPrice FROM Orders WHERE OrderID = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, orderId);
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows
        
        while (rs.next()) {
            int productId = rs.getInt("ProductID");
            String productName = rs.getString("ProductName");
            int qty = rs.getInt("Qty");
            int totalPrice = rs.getInt("TotalPrice");
            model.addRow(new Object[]{productId, productName, qty, totalPrice});
        }
        
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving order details: " + e.getMessage());
    }
}
private void updateOrderFromTable(int orderId) {
    try {
        Connection conn = MDBConnection.createConnection();
        
        // Prepare SQL statement for updating the order
        String sql = "UPDATE Orders SET ProductID = ?, ProductName = ?, Qty = ?, TotalPrice = ? WHERE OrderID = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        
        for (int i = 0; i < rowCount; i++) {
            int productId = (Integer) model.getValueAt(i, 0);
            String productName = (String) model.getValueAt(i, 1);
            int qty = (Integer) model.getValueAt(i, 2);
            int totalPrice = (Integer) model.getValueAt(i, 3);
            
            pst.setInt(1, productId);
            pst.setString(2, productName);
            pst.setInt(3, qty);
            pst.setInt(4, totalPrice);
            pst.setInt(5, orderId);
            
            pst.executeUpdate(); // Update the database
        }
        
        conn.close();
        JOptionPane.showMessageDialog(null, "Order updated successfully!");
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating order: " + e.getMessage());
    }
}


      private void id_autoincrement(){
        
      try {
        var conn = MDBConnection.createConnection();
        String sql = "SELECT MAX(OrderID) FROM Orders";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        int nextId = 1;  // Default ID if no records are found
        
        if (rs.next()) {
            int maxId = rs.getInt(1);
            nextId = maxId + 1;
        }
        
        // Set the nextId value to the txt_productid text field
        txt_orderid.setText(String.valueOf(nextId));

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    
    }
    }

       public void clearField(){
           txt_productid.setText("");
                txt_productname.setText("");
                
                
                 txt_avbqty.setText(null); 
                  txt_qty.setText(null);
                   txt_price.setText(null);
                    txt_unitprice.setText(null); 
               
    
    
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
        jLabel7 = new javax.swing.JLabel();
        txt_orderid = new javax.swing.JTextField();
        txt_productid = new javax.swing.JTextField();
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
        jLabel3 = new javax.swing.JLabel();
        date_order = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_unitprice = new javax.swing.JTextField();
        btn_Add1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Order ID");

        txt_orderid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_orderidActionPerformed(evt);
            }
        });

        txt_productid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productidActionPerformed(evt);
            }
        });

        jLabel2.setText("Product ID");

        txt_membername.setText("Total  Price");

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
        btn_Add.setText("Add Cart");
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

        jLabel4.setText("Avalable Qty");

        jLabel5.setText(" Qty");

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

        jLabel6.setText("Product Name");

        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        jLabel8.setText("Product Price");

        jLabel3.setText("Order Date");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel9.setText("Orders");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductID", "ProductName", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setText(" Price");

        txt_unitprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_unitpriceActionPerformed(evt);
            }
        });

        btn_Add1.setBackground(new java.awt.Color(0, 153, 153));
        btn_Add1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_Add1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Add1.setText("Add Order");
        btn_Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_return.setBackground(new java.awt.Color(0, 153, 153));
        btn_return.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setText("Return");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(date_order, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_orderid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btn_Update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_return)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_productid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_productname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_unitprice, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_avbqty, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txt_membername, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Add1)
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Add)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_productid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_orderid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_avbqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btn_Update)
                            .addComponent(btn_Delete)
                            .addComponent(btn_clear)
                            .addComponent(btn_return))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_unitprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(btn_Add))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(date_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_membername)
                    .addComponent(btn_Add1))
                .addGap(23, 23, 23))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productnameActionPerformed

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed
   // Fetch the entered quantity and product ID
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
        txt_unitprice.setText(String.valueOf(total));

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
       if (txt_orderid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Order ID cannot be empty");
        return;
    }

    // Prompt the user for confirmation before deletion
    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this order?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
    // If the user selects "Yes", proceed with the deletion
    if (response == JOptionPane.YES_OPTION) {
        int orderid = Integer.parseInt(txt_orderid.getText());
        COrder cp = new COrder();
        cp.deleteOrder(orderid);  // Perform the deletion

        clearField();             // Clear the form fields
        id_autoincrement();       // Call your method to auto-increment the ID
        JOptionPane.showMessageDialog(null, "Order deleted successfully!"); // Notify the user
    } else {
        // If the user selects "No", cancel the deletion
        JOptionPane.showMessageDialog(null, "Deletion canceled.");
    }
    date_order.setDate(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
 
   try{     
    int productId = Integer.parseInt(txt_productid.getText().trim());   // Product ID
        String productName = txt_productname.getText().trim();              // Product Name
        int qty = Integer.parseInt(txt_qty.getText().trim());               // Quantity
        int unitPrice = Integer.parseInt(txt_unitprice.getText().trim());   // Unit Price
        int price = qty * unitPrice;                                        // Total price (qty * unit price)

        // Get the table model of jTable1
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        // Add the product details to the table (with separate row for each product)
        tableModel.addRow(new Object[]{productId, productName, qty, price});

        // After adding the item, update the grand total (sum of all items' prices)
        updateGrandTotal(tableModel);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values", "Error", JOptionPane.ERROR_MESSAGE);
    }



clearField();
        
        
        
        /*
        if (!validateInputs()) {
            return;
        }

        int orderid = Integer.parseInt(txt_orderid.getText());
        int productid = Integer.parseInt(txt_productid.getText());
        java.util.Date utilOrderDate = date_order.getDate();
        java.sql.Date sqlcreatedate = new java.sql.Date(utilOrderDate.getTime());
        int qty = Integer.parseInt(txt_qty.getText());
        int total = Integer.parseInt(txt_total.getText());

        COrder co = new COrder();
        co.addOrder(orderid, sqlcreatedate, productid, qty, total);
        id_autoincrement();
        clearField();*/
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearField();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearActionPerformed

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

    private void txt_productidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productidActionPerformed

        int productid = Integer.parseInt(txt_productid.getText());

        if (productid == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the product ID to view details");
            return;
        }

        try {
            try (Connection conn = MDBConnection.createConnection()) {
                String sql = "SELECT ProductName,Price,Qty FROM Product WHERE ProductID= ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, productid);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    txt_productname.setText(rs.getString("ProductName"));
                    
                    int currentqty = rs.getInt("Qty");
                    txt_avbqty.setText(String.valueOf(currentqty));

                    int Price = rs.getInt("Price");
                    txt_price.setText(String.valueOf(Price));

                } else {
                    JOptionPane.showMessageDialog(null, "Product ID not found");
                }       }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving product details: " + e.getMessage());
            }

            // TODO add your handling code here:
    }//GEN-LAST:event_txt_productidActionPerformed

    private void txt_orderidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_orderidActionPerformed
        //id_autoincrement();
        loadOrderDetailsToCart();
       /* int orderid=Integer.parseInt(txt_orderid.getText());
        if (orderid==0) {
            JOptionPane.showMessageDialog(null, "Please enter the Order ID to view details");
            return;
        }

        try {
            Connection conn = MDBConnection.createConnection();
            String sql = "SELECT ProductID,OrderDate, Qty, TotalPrice FROM Orders WHERE OrderID = ?";
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
                date_order.setDate(rs.getDate("OrderDate"));

            } else {
                JOptionPane.showMessageDialog(null, "Product ID not found");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving product details: " + e.getMessage());*/
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_orderidActionPerformed

    private void txt_unitpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_unitpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_unitpriceActionPerformed

    private void btn_Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add1ActionPerformed

      addOrder();
       this.setVisible(false);
        VInvoice vpmd =new VInvoice();
        vpmd.setVisible(true);
      id_autoincrement();
      txt_total.setText(null);
      date_order.setDate(null);
        
        
        
        
        
        
        /*java.util.Date utilOrderDate = date_order.getDate();
    if (utilOrderDate == null) {
        JOptionPane.showMessageDialog(this, "Please select a valid date", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    java.sql.Date sqlOrderDate = new java.sql.Date(utilOrderDate.getTime());

    // Retrieve table model from jTable1
    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

    // Loop through the table rows and insert each product into the database
    int rowCount = tableModel.getRowCount();
    for (int i = 0; i < rowCount; i++) {
        // Retrieve values from each row
        String productName = (String) tableModel.getValueAt(i, 1); // Assuming product name is in the 2nd column
        int qty = (Integer) tableModel.getValueAt(i, 2); // Assuming quantity is in the 3rd column
        int total = (Integer) tableModel.getValueAt(i, 3); // Assuming total price is in the 4th column

        // Call method to insert data into database
        addOrderDetail(productName, total, sqlOrderDate, qty);
    }
    
    // Optionally, clear the table and input fields after successful insertion
    tableModel.setRowCount(0);
    JOptionPane.showMessageDialog(this, "Order Added Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);*/
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Add1ActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed

        populateTableWithOrderData(orderId);
        updateOrderFromTable(orderId);

        /* if (!validateInputs()) {
            return;
        }

        int orderid = Integer.parseInt(txt_orderid.getText());
        int productid = Integer.parseInt(txt_productid.getText());
        java.util.Date utilOrderDate = date_order.getDate();
        java.sql.Date sqlcreatedate = new java.sql.Date(utilOrderDate.getTime());
        int qty = Integer.parseInt(txt_qty.getText());
        int total = Integer.parseInt(txt_total.getText());

        COrder co = new COrder();
        co.updateOrder(sqlcreatedate, productid, qty, total, orderid);
        id_autoincrement();
        clearField();
        */
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
        VCashierdashboard vpmd =new VCashierdashboard();
        vpmd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
       if (txt_orderid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Order ID cannot be empty");
        return;
    }

    int orderId = Integer.parseInt(txt_orderid.getText());
    
    Connection con = null;
    PreparedStatement pst = null;

    try {
        con = MDBConnection.createConnection();
        String sql = "INSERT INTO `Return` (OrderID) VALUES (?)";
        pst = con.prepareStatement(sql);
        pst.setInt(1, orderId);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Return added successfully!");
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding return: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_returnActionPerformed

  private boolean validateInputs() {
    if (txt_orderid.getText().isEmpty()) {
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
        Integer.parseInt(txt_orderid.getText());
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
            java.util.logging.Logger.getLogger(VOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Add1;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_return;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_avbqty;
    private javax.swing.JLabel txt_membername;
    private javax.swing.JTextField txt_orderid;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_productid;
    private javax.swing.JTextField txt_productname;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_unitprice;
    // End of variables declaration//GEN-END:variables
}
