package com.phoenix.demos;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyDate implements Externalizable
{
	int dd;
	int mm;
	int yy;
	
	
	
	public MyDate(int dd, int mm, int yy) {
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
	}
	public int getDd() {
		return dd;
	}
	public void setDd(int dd) {
		this.dd = dd;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getYy() {
		return yy;
	}
	public void setYy(int yy) {
		this.yy = yy;
	}
	
	public static void main(String[] args) {

		MyDate m=new MyDate(12,12,12);
		System.out.println(m);
	}
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		System.out.println("Perform your read operations here");
		
	}
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Perform your write operations here");
		arg0.writeObject(this);
	}

/*	public String toString()
	{
		return "[dd:"+this.dd+", mm:"+this.mm+", yy:"+this.yy+"]";
	}*/
}





