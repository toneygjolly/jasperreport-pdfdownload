package com.controller;


import java.util.List;

import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import com.business.empchecking;

import com.pojo.employeepojo;









public class Employeedetails extends SelectorComposer<Component>{
	private employeepojo n =new employeepojo();
	@Wire
	private Nav stocksnavid;
	@Wire
	private Include includezulid;
	@Wire
	private Button b1;
	@Wire
	private Label name,roleemp;
	@Wire
	private Image EmpImage,EmpImage1;
	@Wire
	private Listbox listboxallemployee,listboxteachingstaff,listboxnontechingstaff;

	@Wire
	private Nav techstaff;
	@Listen("onClick=#techstaff")	
	public void teach() {
		 includezulid.setSrc("Teachingstaff.zul");
	}
	@Wire
	private Nav nontechstaff;
	@Listen("onClick=#nontechstaff")
	
	public void nontech() {
		 includezulid.setSrc("nonteachingstaff.zul");
		
	}

	@Wire
	private Nav allstaff;
	@Listen("onClick=#allstaff")
	public void allstaff() {
		 includezulid.setSrc("allemployees.zul");
	}

	
	
//	@Listen("onSelect=#listboxallemployee,listboxteachingstaff,listboxnontechingstaff")
//    public void showImageAndName() {
//		//employeepojo selectedemp = listboxallemployee.getSelectedItem().getValue();
//		employeepojo selectedemp1 = listboxteachingstaff.getSelectedItem().getValue();
//		employeepojo selectedemp2 = listboxnontechingstaff.getSelectedItem().getValue();
//      //  employeepojo selectedemp = listbox.getSelectedItem().getValue();
//        //name.setValue("Employee Name: " + selectedemp.getEmpname());
//       // roleemp.setValue("Employee role:"+selectedemp.getRole());       
//        //name.setValue("Employee Name: " + selectedemp1.getEmpname());
//       // roleemp.setValue("Employee role:"+selectedemp.getRole());  
////        String imageUrl = selectedemp.getImageUrl();
////     
////        alert(imageUrl);
////        String imageUrl = selectedemp.getImageUrl();
//
//      
//
//	}
	

	
	
}
