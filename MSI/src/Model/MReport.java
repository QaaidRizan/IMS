/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
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
 * @author moham
 */
public class MReport {
     public void Report(){

   try {
            Connection report_con = MDBConnection.createConnection();
            JasperDesign jasperdesign1 = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\ExpenseReport1.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("SELECT * FROM expense");
            jasperdesign1.setQuery(designquery);
            JasperReport report = JasperCompileManager.compileReport(jasperdesign1);
            JasperPrint print = JasperFillManager.fillReport(report, null, report_con);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
      public void Report1(){

   try {
            Connection report_con = MDBConnection.createConnection();
            JasperDesign jasperdesign1 = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\ProductReport1.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("SELECT * FROM product");
            jasperdesign1.setQuery(designquery);
            JasperReport report = JasperCompileManager.compileReport(jasperdesign1);
            JasperPrint print = JasperFillManager.fillReport(report, null, report_con);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        public void Report2(){

   try {
            Connection report_con = MDBConnection.createConnection();
            JasperDesign jasperdesign1 = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\OrderReport1.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("SELECT * FROM orders");
            jasperdesign1.setQuery(designquery);
            JasperReport report = JasperCompileManager.compileReport(jasperdesign1);
            JasperPrint print = JasperFillManager.fillReport(report, null, report_con);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
}
       

   public void Report3(){

   try {
            Connection report_con = MDBConnection.createConnection();
            JasperDesign jasperdesign1 = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\StockReport1.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("SELECT * FROM stock");
            jasperdesign1.setQuery(designquery);
            JasperReport report = JasperCompileManager.compileReport(jasperdesign1);
            JasperPrint print = JasperFillManager.fillReport(report, null, report_con);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
}

 public void Report4(){

   try {
            Connection report_con = MDBConnection.createConnection();
            JasperDesign jasperdesign1 = JRXmlLoader.load("C:\\Users\\USER\\Documents\\NetBeansProjects\\Ims2\\MSI\\src\\Model\\SupplierReport1.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText("SELECT * FROM supplier");
            jasperdesign1.setQuery(designquery);
            JasperReport report = JasperCompileManager.compileReport(jasperdesign1);
            JasperPrint print = JasperFillManager.fillReport(report, null, report_con);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
}
}

