import java.util.*;

import com.soham.assignment.OrderFunc;

public class HomePage {
	
	public static void main (String[] args) throws InterruptedException {
	  int loop=1;
	  
	
	  
	  Scanner sc=new Scanner(System.in);
	  OrderFunc of=new OrderFunc();
	  
	  do {int choice=0,ch;
		  System.out.println("**********Order Management System***********");
		  System.out.println("1. Add Order \r\n"
		  		+ "\r\n"
		  		+ "2. View Order \r\n"
		  		+ "\r\n"
		  		+ "3. View By Order Id \r\n"
		  		+ "\r\n"
		  		+ "4. Sort Order \r\n"
		  		+ "\r\n"
		  		+ "5. Delete Order by Id \r\n"
		  		+ "\r\n"
		  		+ "6. Mark as Delivered. \r\n"
		  		+ "\r\n"
		  		+ "7. Generate Report. \r\n"
		  		+ "\r\n"
		  		+ "0 Exit ");
		  
		  System.out.println("Enter your choice : ");
		  
		  
		  choice = sc.nextInt();
//		  System.out.println(ch);
//		  Thread.sleep(1000);
//		  choice=ch;
		  
		  switch(choice) {
		  case 1: 
			  of.add_Order();
			  break;
		  case 2:
			  of.view_Order();
			   
			  break;
		  case 3:
			  int srchId;
			  System.out.println("Enter the orderId: ");
			  srchId=sc.nextInt();
			  of.view_Order(srchId);
			  
			  break;
		  case 4:
			  of.sort_Order();
			  
			  
			  break;
		  case 5: 
			
			  System.out.println("Enter the orderId: ");
			  srchId=sc.nextInt();
			  of.delete_Order(srchId);
			    
			  break;
		
		  case 6:
			  System.out.println("Enter the orderId: ");
			  srchId=sc.nextInt();
			  of.marked_Deliver(srchId);
			  
			  
			  break;
			  
		  case 7:
			  of.rprt_Generate();
			  
			  break;
			  
		  case 0:
			  of.save_Data();
			  loop=0;
			  System.out.println("Exiting from the Order management system...!");
			  
			  break;
	      default:
	    	  System.out.println("Wrong Option...!");
		  
		  
		  }
		  
	  }while(loop!=0);
	  sc.close();
	}

}
