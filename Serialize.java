package com.phoenix.demos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Emp e=new Emp(12, "XYZ", new MyDate(12,12,12));
			FileOutputStream fout=new FileOutputStream("data.txt");
			ObjectOutputStream oout=new ObjectOutputStream(fout);
			
			oout.writeObject(e);
			oout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
