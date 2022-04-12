package com.soham.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderFunc implements OrderManagement  {
	
	File f = new File("C:\\Users\\Soham Banerjee\\eclipse-workspace\\OrderManagementSystem\\Ordermanagement.txt");
	
	
	ArrayList<OrderDetails> al=new ArrayList<>();
	
	Scanner sc=new Scanner(System.in);
	
	ObjectOutputStream oos=null;
	
	OrderDetails ordDet;
	
	
	
	
	LocalDateTime ldt=LocalDateTime.now();
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
	
	public OrderFunc()  {
		
		if(f.isFile()) {
			try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			al=(ArrayList<OrderDetails>) ois.readObject();
			ois.close();
			}catch(Exception e)
			{
				System.out.println("No order history...!");
				
				
				//System.out.println(e + "File reading Error...!");
			}
			
			}
	}

	@Override
	public void add_Order() {
		char add='y';
		int ordId;
		String odrDesc,odrAdd;
		double odrAmnt;
		outer:
		while(add=='y' || add== 'Y') {
			
			System.out.println("Enter orderId: ");
			try {
			ordId=Integer.parseInt(sc.nextLine());
			
			
			for(OrderDetails i: al) {
				if(i.getOrderID()==ordId)
				{
					System.out.println("Order Id exist....!");
					break outer;
				}
				
			}
	
			
			System.out.println("Enter order description: ");
			
			odrDesc=sc.nextLine();
			
			System.out.println("Enter order address: ");
			
			odrAdd=sc.nextLine();
			
			System.out.println("Enter order amount: ");
			odrAmnt=Double.parseDouble(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Invalid amount should be double or OrderId should be integer");
				break outer;
			}
			al.add(new OrderDetails( ordId, odrDesc, odrAdd, odrAmnt,ldt.format(dtf)));
			
			System.out.println("Order added successfully\nWants to add another ? (Y/N)");
			String temp=sc.nextLine();
			add=temp.charAt(0);
			
		}
		
		
		try {
		
		oos=new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(al);
		oos.close();
		}catch(Exception e) {
			System.out.println("Issue in registering file");
		}
		
	}

	@Override
	public void view_Order() {
		System.out.println("OrderId  |  Order Description  |  Delivery Address  |    Order Amount    |      Order date      |     Delivery Date  |");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		for(OrderDetails i: al) {
			System.out.println(i);
		}
	    System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
	}

	@Override
	public void view_Order(int srchID) {
		System.out.println("-----------------------------------------------------");
		System.out.println("Order Details : ");
		System.out.println("-----------------------------------------------------");
		for(OrderDetails i: al) {
			if(i.getOrderID()==srchID) {
			System.out.println("OrderId : "+i.getOrderID());
			System.out.println("Order Desc : "+i.getOrderDesc());
			System.out.println("Order Address : "+i.getDelivAdd());
			System.out.println("Order Amount : "+i.getOrderAmount());
			System.out.println("Order Date : "+i.getOrderDate());
			System.out.println("Delivered Date : "+i.getDelivDate());
			}
		}
	    
		
	}

	@Override
	public void sort_Order() {
		int loop=1;
		do {
			System.out.println("*************Sorting Order************");
			System.out.println("1. OrderId \r\n"
					+ "\r\n"
					+ "2. Order Desc \r\n"
					+ "\r\n"
					+ "3. DeliveryAddress \r\n"
					+ "\r\n"
					+ "4. Order Date \r\n"
					+ "\r\n"
					+ "5. Amount \r\n"
					+ "\r\n"
					+ "6. Delivery Datetime \r\n"
					+ "\r\n"
					+ "0.Exit\n " );
			System.out.println("Enter your choice : ");
			loop=sc.nextInt();
			switch(loop) {
			case 1: 
				Collections.sort(al,new Comparator<OrderDetails>() {

					@Override
					public int compare(OrderDetails o1, OrderDetails o2) {
						return o1.getOrderID()-o2.getOrderID();
					}});
				
				System.out.println(al);
				System.out.println("Successfully sorted by OrderId");
				break;
			case 2:
				Collections.sort(al,new Comparator<OrderDetails>() {

					@Override
					public int compare(OrderDetails o1, OrderDetails o2) {
						return o1.getOrderDesc().compareTo(o2.getOrderDesc());
					}});
				System.out.println(al);
				System.out.println("Successfully sorted by description");
				break;
			case 3:
				Collections.sort(al,new Comparator<OrderDetails>() {

					@Override
					public int compare(OrderDetails o1, OrderDetails o2) {
						return o1.getDelivAdd().compareTo(o2.getDelivAdd());
					}});
				System.out.println(al);
				System.out.println("Successfully sorted by address");
				break;
			case 4:
				Collections.sort(al,new Comparator<OrderDetails>() {

					@Override
					public int compare(OrderDetails o1, OrderDetails o2) {
						return o1.getOrderDate().compareTo(o2.getOrderDate());
					}});
				System.out.println(al);
				System.out.println("Successfully sorted by order date");
				break;
			case 5:
				Collections.sort(al,new Comparator<OrderDetails>() {

					@Override
					public int compare(OrderDetails o1, OrderDetails o2) {
						return (int)( o1.getOrderAmount()- o2.getOrderAmount());
					}});
				System.out.println(al);
				System.out.println("Successfully sorted by amount");
				break;
			case 6:
				Collections.sort(al,new Comparator<OrderDetails>() {

					@Override
					public int compare(OrderDetails o1, OrderDetails o2) {
						return o1.getDelivDate().compareTo(o2.getDelivDate());
					}});
				System.out.println(al);
				System.out.println("Successfully sorted by delivery date");
				break;
			case 0:
				loop=0;
				break;
			}
		}while(loop!=0);
		
		
	}

	@Override
	public void delete_Order(int srchID) {
		boolean found=false;
		for(OrderDetails i : al) {
			if(i.getOrderID()== srchID) {
			  al.remove(i);
			  System.out.println(al);
			  found=true;
			  break;
			  }
			
		}
		if(found) {
			
	    try {
			
			oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(al);
			oos.close();
			}catch(Exception e) {
				System.out.println("Issue in registering file");
			}
	    System.out.println("Successfully deleted...!");
			
		}
	}

	@Override
	public void marked_Deliver(int srchID ) {
		
		int flag=0;
		outer:
		for(OrderDetails i: al) {
			
			if(i.getOrderID()==srchID ) {
				if(i.getDelivDate()=="") {
				  i.setDelivDate(ldt.format(dtf));
				}
				else {
					System.out.println("Order already delivered on "+i.getDelivDate());
					flag=1;
					break outer;
				}
			}
		}
	   if(flag==0) {
	    try {
			oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(al);
			oos.close();
			System.out.println("Marked Delivered");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Odrfunc save data");
		}
	    
	    }
		
		
		
		
	}

	@Override
	public void save_Data() {
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(al);
			oos.close();
			System.out.println("Data saved successfully");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Odrfunc save data");
		}
		
		sc.close();
	}

	@Override
	public void rprt_Generate() {
		GenerateReport gn=new GenerateReport(al);
		gn.start();
		
	}
	
	

}
