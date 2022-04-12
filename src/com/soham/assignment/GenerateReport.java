package com.soham.assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;

public class GenerateReport extends Thread {
	LocalDateTime ldt=LocalDateTime.now();
	Scanner sc=new Scanner(System.in);
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	public  GenerateReport(ArrayList<OrderDetails> od)  {
		
		System.out.println("Give a file name : ");
		
		PrintWriter pw;
		
		try {
		String temp= sc.nextLine();
		File f = new File("C:\\Users\\Soham Banerjee\\eclipse-workspace\\OrderManagementSystem\\"+temp+".txt");
		FileWriter fw;
		fw = new FileWriter(f);
		pw= new PrintWriter(fw);
		pw.println(ldt.format(dtf));
		for( OrderDetails i : od  ) {
			pw.println(i.toString());
			
			
		}
		
		pw.close();
		
		
		System.out.println("Report generate successfully");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
