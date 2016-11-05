package com.phoenix.demos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f=new File("c:/HaxLogs.txt");
		try {
			int data=0;
			FileInputStream fin=new FileInputStream(f);
			BufferedInputStream bin=new BufferedInputStream(fin);
			while((data=bin.read())!=-1)
			{
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
