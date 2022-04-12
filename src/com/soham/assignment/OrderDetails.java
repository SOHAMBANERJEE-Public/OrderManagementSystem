package com.soham.assignment;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderDetails implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int orderID;
private String orderDesc;
private String delivAdd;
private String orderDate;
private String delivDate="";
private double orderAmount;


public OrderDetails(int orderID, String orderDesc, String delivAdd,double orderAmount,String orderDate) {
	this.orderID = orderID;
	this.orderDesc = orderDesc;
	this.delivAdd=delivAdd;
	this.orderDate = orderDate;
	this.orderAmount = orderAmount;
}

public void setDelivDate(String delivDate) {
	this.delivDate = delivDate;
}

//**********************************************


public int getOrderID() {
	return orderID;
}

public String getOrderDesc() {
	return orderDesc;
}

public String getDelivAdd() {
	return delivAdd;
}

public String getOrderDate() {
	return orderDate;
}

public String getDelivDate() {
	return delivDate;
}

public double getOrderAmount() {
	return orderAmount;
}




//************************************************

@Override
public String toString() {
	return orderID + "		" + orderDesc + "		" + delivAdd + "            "+ orderAmount + "           " +orderDate + "             " + delivDate + "		\n" ;
}








 
}
