package com.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.business.ReportGenerator;
import com.business.empchecking;
import com.pojo.employeepojo;

public class allemployee  extends SelectorComposer<Component>{
	@Wire
	private Button bb1;
	@Listen("onClick=#bb1")
	public void bb1() {
		alert("hi");
		ReportGenerator m =new ReportGenerator();
		m.dataa();
		alert("sucessfull");
	}
	@Wire
	private Image teachEmpImage,allEmpImage,nonteachingEmpImage;
	@Wire
	private Label nonTeachingrole,nonTeachingactive,Teachingrole,Teachingactive,active,role,name,roleemp,Teachingstaffname,Teachingstaffroleemp,nontechingname,nontechingroleemp;
		private employeepojo n =new employeepojo();
		@Wire
		private Button b1,allemployeemoredetails,teachingmoredetails,nonteachermoredetails;
//		@Listen("onClick=#b1")
//		public void r() {
//			alert("hi");
//		}
		@Wire
		private Listbox listboxallemployee,listboxteachingstaff,listboxnontechingstaff;
		@Wire
		private Nav nontechstaff;
		@Listen("onCreate=#listboxnontechingstaff")
		public void nontech() {
			empchecking l =new empchecking();
			List<employeepojo>list = l.nonteacher();
			listboxnontechingstaff.setModel(new ListModelList<employeepojo>(list));
		}
		@Listen("onCreate=#listboxteachingstaff")
		public void techingstaff() {
			empchecking l =new empchecking();
			List<employeepojo>list = l.teach();
			listboxteachingstaff.setModel(new ListModelList<employeepojo>(list));
		}
		
		@Listen("onCreate=#listboxallemployee")
		public void allstaff() {
			empchecking l =new empchecking();
			List<employeepojo>list=l.allstaffs();
			listboxallemployee.setModel(new ListModelList<employeepojo>(list));
		}
		
		
		
		
		
		@Listen("onSelect=#listboxallemployee")
		public void allemployee() {
			employeepojo selectedemp = listboxallemployee.getSelectedItem().getValue();
			name.setValue("Employee Name: " + selectedemp.getEmpname());
			roleemp.setValue("Employee role:"+selectedemp.getRole()); 
		       // String imageUrl = selectedemp.getImageUrl();
		        allEmpImage.setSrc(selectedemp.getImageUrl());
		       // allEmpImage.setSrc(imageUrl);
		       // String imageUrl = selectedemp.getImageUrl();
		}
		
		
		
		
		
		
		
		@Listen("onSelect=#listboxteachingstaff")
		public void teachingstaff1() {
			employeepojo selectedemp1 = listboxteachingstaff.getSelectedItem().getValue();
			Teachingstaffname.setValue("Employee Name: " + selectedemp1.getEmpname());
			Teachingstaffroleemp.setValue("Employee role:"+selectedemp1.getRole());
			teachEmpImage.setSrc(selectedemp1.getImageUrl());
		       // String imageUrl = selectedemp1.getImageUrl();
		       // String imageUrl = selectedemp.getImageUrl();
		}
		
		
		
		
		
		@Listen("onSelect=#listboxnontechingstaff")
		public void nonteachingstaff1() {
			employeepojo selectedemp2 = listboxnontechingstaff.getSelectedItem().getValue();
			nontechingname.setValue("Employee Name: " + selectedemp2.getEmpname());
			nontechingroleemp.setValue("Employee role:"+selectedemp2.getRole()); 
			nonteachingEmpImage.setSrc(selectedemp2.getImageUrl());;
		       // String imageUrl = selectedemp2.getImageUrl();
		       // String imageUrl = selectedemp.getImageUrl();
		}
		
		 @Listen("onClick=#allemployeemoredetails")
		    public void  moredetails() {
		    	employeepojo selectedemp = listboxallemployee.getSelectedItem().getValue();
		    	role.setValue("Employee Role: " + selectedemp.getRole());
		    	active.setValue("Employee now: " + selectedemp.getType());
		    	//alert("hi");
		    }
		 @Listen("onClick=#teachingmoredetails")
		    public void  teachersmoredetails() {
			 //alert("hi");
		    	employeepojo selectedemp1 = listboxteachingstaff.getSelectedItem().getValue();
		    	Teachingrole.setValue("Employee Role: " + selectedemp1.getRole());
		    	Teachingactive.setValue("Employee now: " + selectedemp1.getType());
		    	//alert("hi");
		    }
		 @Listen("onClick=#nonteachermoredetails")
		    public void  nonteachersmoredetails() {
			 
		    	employeepojo selectedemp2 = listboxnontechingstaff.getSelectedItem().getValue();
		    	nonTeachingrole.setValue("Employee Role: " + selectedemp2.getRole());
		    	nonTeachingactive.setValue("Employee now: " + selectedemp2.getType());
		    	//alert("hi");
		    }

}
