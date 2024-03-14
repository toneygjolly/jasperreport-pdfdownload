package com.business;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lowagie.text.Phrase;
import com.pojo.employeepojo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportGenerator {
public void dataa() {
	try {
		empchecking datalist =new empchecking();
   	// DataBeanList DataBeanList = new DataBeanList();
   	 List<employeepojo> dataa = datalist.allstaffs();
       // Compile the JRXML file (JasperReports XML template)
       JasperReport jasperReport = JasperCompileManager.compileReport("/home/administrator/eclipse-workspace/pdfproject/jasper_report_template.jrxml");
       
       // Create a sample data source (you can replace this with your data source)
       JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataa);

       // Set parameters, if any
       Map<String, Object> parameters = new HashMap<>();
       parameters.put("ReportTitle", "Sample Report");
       // Fill the report
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

       // Export the report to PDF
       JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/administrator/eclipse-workspace/pdfproject/report5.pdf");

       System.out.println("Report generation successful!");

   } catch (JRException e) {
       e.printStackTrace();
   }
}
    public static void main(String[] args) {
    	ReportGenerator r =new ReportGenerator();
    	r.dataa();
//        try {
//        	 DataBeanList DataBeanList = new DataBeanList();
//        	 ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
//            // Compile the JRXML file (JasperReports XML template)
//            JasperReport jasperReport = JasperCompileManager.compileReport("jasper_report_template.jrxml");
//            
//            // Create a sample data source (you can replace this with your data source)
//            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
//
//            // Set parameters, if any
//            Map<String, Object> parameters = new HashMap<>();
//            parameters.put("ReportTitle", "Sample Report");
//            // Fill the report
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//            // Export the report to PDF
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");
//
//            System.out.println("Report generation successful!");
//
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
    }
}
