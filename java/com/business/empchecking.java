package com.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.DataConnect;
import com.pojo.employeepojo;

public class empchecking {
	private Connection con;
	private PreparedStatement stat;
	private List<employeepojo>teaching;
	
public empchecking() {
	con=DataConnect.getConnection();
	teaching=new ArrayList<employeepojo>();
}
//public List<employeepojo> teach(){
//	stat=con.prepareStatement("Select emptype,from employee where emptype='"+Teaching+"'");
//	//boolean result=stat.execute();
//    ResultSet result1=stat.executeQuery();
//	return teaching;
//	
//}

public List<employeepojo> teach() {
    List<employeepojo> teachingList = new ArrayList<>();

    try {
        // Assuming that con is your database connection
        stat = con.prepareStatement("SELECT * FROM employee WHERE emptype = ?");
        stat.setString(1, "Teaching");

        ResultSet result = stat.executeQuery();

        while (result.next()) {
            employeepojo employee = new employeepojo();
            // Assuming that employeepojo has setters to set values
            employee.setEmpid(result.getInt("empid"));
            employee.setEmpname(result.getString("empname"));
            employee.setRole(result.getString("role"));
            employee.setType(result.getString("type"));
            employee.setEmptype(result.getString("emptype"));
           // employee.setImageUrl("ImageUrl");
            employee.setImageUrl(result.getString(6));
            teachingList.add(employee);
        }

    } catch (SQLException e) {
        // Handle any potential exceptions
        e.printStackTrace();
    } 

    return teachingList;
}

public List<employeepojo> nonteacher() {
    List<employeepojo> teachingList = new ArrayList<>();

    try {
        
        stat = con.prepareStatement("SELECT * FROM employee WHERE emptype = ?");
        stat.setString(1, "nonTeaching");

        ResultSet result = stat.executeQuery();

        while (result.next()) {
            employeepojo employee = new employeepojo();
            
            employee.setEmpid(result.getInt("empid"));
            employee.setEmpname(result.getString("empname"));
            employee.setRole(result.getString("role"));
            employee.setType(result.getString("type"));
            employee.setEmptype(result.getString("emptype"));
            employee.setImageUrl(result.getString(6));

            teachingList.add(employee);
        }

    } catch (SQLException e) {
        
        e.printStackTrace();
    } 

    return teachingList;
}


public List<employeepojo> allstaffs() {
    List<employeepojo> teachingList = new ArrayList<>();

    try {
        // Assuming that con is your database connection
        stat = con.prepareStatement("SELECT * FROM employee");
       // stat.setString(1, "Teaching");

        ResultSet result = stat.executeQuery();

        while (result.next()) {
            employeepojo employee = new employeepojo();
            // Assuming that employeepojo has setters to set values
            employee.setEmpid(result.getInt("empid"));
            employee.setEmpname(result.getString("empname"));
            employee.setRole(result.getString("role"));
//            employee.setType(result.getString("type"));
//            employee.setEmptype(result.getString("emptype"));
//            employee.setImageUrl(result.getString(6));
            teachingList.add(employee);
        }

    } catch (SQLException e) {
        // Handle any potential exceptions
        e.printStackTrace();
    } 

    return teachingList;
}


public List<employeepojo> imagefetching() {
    List<employeepojo> teachingList = new ArrayList<>();

    try {
        
        stat = con.prepareStatement("SELECT * FROM employee");
        //stat.setString(1, "nonTeaching");

        ResultSet result = stat.executeQuery();

        while (result.next()) {
            employeepojo employee = new employeepojo();
            
            employee.setEmpid(result.getInt(1));
            employee.setEmpname(result.getString(2));
            employee.setRole(result.getString(3));
            employee.setType(result.getString(4));
            employee.setEmptype(result.getString(5));
           employee.setImageUrl(result.getString(6));
          
            teaching.add(employee);
            System.out.println(result.getString(6));
        }

    } catch (SQLException e) {
        
        e.printStackTrace();
    } 

    return teaching;
}


public static void main(String args[]) {
	empchecking l=new empchecking();
		    List<employeepojo> teachingList = l.teach();

	    // Print the details of employees with emptype "Teaching"
	    for (employeepojo employee : teachingList) {
	        System.out.println("Employee ID: " + employee.getEmpid());
	        System.out.println("Employee Name: " + employee.getEmpname());
	        System.out.println("Role: " + employee.getRole());
	        System.out.println("Type: " + employee.getType());
	        System.out.println("Employee Type: " + employee.getEmptype());
	        System.out.println("iMAGE: " + employee.getImageUrl());
	        System.out.println("---------------------------");
	    }
}
}
