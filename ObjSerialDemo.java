package com.phoenix.demos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class DemoSerial implements Serializable	//Marker interface
{
	int i;
	String str;
	DemoSerial()
	{
	}

	DemoSerial(int i,String str)
	{
		this.i=i;
		this.str=str;
	}
	
	public void printData()
	{
		System.out.println("Value of i" + i);
		System.out.println("Value of str" + str);
	}

	public String toString()
	{
		return i+"\t"+ str;
	} 
}

class ObjectOutDemo// for serialization 
{
	public static void main(String[] args) 
	{
		try
		{
			DemoSerial obj1 = new DemoSerial(100,"abc");
			DemoSerial obj2 = new DemoSerial(101,"xyz");

			FileOutputStream fout = new FileOutputStream("demoobj.txt");
			ObjectOutputStream oos =new ObjectOutputStream(fout);
			oos.writeObject(obj1);
			oos.writeObject(obj2);
			oos.flush();
			oos.close();
			System.out.println("Object is Written to File demoobj");
		}

		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}

	}//main ends here
}

class  ObjectInDemo // for deserialization
{
	public static void main(String[] args) 
	{
		try
		{
			FileInputStream fin = new FileInputStream("demoobj.txt");
			ObjectInputStream oin =new ObjectInputStream(fin);

			DemoSerial obj= new DemoSerial();
		
			obj=(DemoSerial)oin.readObject();
			obj.printData();
		/*	System.out.println(obj);
		
			obj=(DemoSerial)oin.readObject();
			obj.printData();
			System.out.println(obj);

			System.out.println((DemoSerial)oin.readObject());

			
			System.out.println("Object is Read");*/
			oin.close();
		}
		catch(Exception e)
		{ }

	}
}