package com.phoenix.demos;

import java.io.Serializable;

public class Emp implements Serializable {

	int empId=12;
	String empName="XYZ";
/*	int joindd;
	int joinmm;
	int joinyy;
*/	
	
	MyDate join_dt=new MyDate(12, 12, 12);
	
	public Emp()
	{
		empId=33;
		empName="Default";
	}

	public Emp(int v1, String v2, MyDate v3)
	{
		empId=v1;
		empName=v2;
		join_dt=v3;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public static void main(String[] args) {
		
		
		Emp e=new Emp(21,"Name",new MyDate(1,1,1));
		//e.setEmpId(23);
		e.display("ABC");

	}
	
	public void display()
	{
		System.out.println("The Id is " + empId);
		System.out.println("The name is "+empName);
		System.out.println("The date of joining is "+join_dt.dd);
	}
	
	public String display(String variable)
	{
		return empId+empName;
	}

}







