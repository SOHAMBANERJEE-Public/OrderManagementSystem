import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderDetails implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String orderID;
private String orderDesc;
private String delivAdd;
private String orderDate;
private LocalDateTime delivDate;
private double orderAmount;


public OrderDetails(String orderID, String orderDesc, String delivAdd,double orderAmount,String orderDate) {
	this.orderID = orderID;
	this.orderDesc = orderDesc;
	this.delivAdd=delivAdd;
	this.orderDate = orderDate;
	this.orderAmount = orderAmount;
}

public void setDelivDate(LocalDateTime delivDate) {
	this.delivDate = delivDate;
}



@Override
public String toString() {
	return "" + orderID + "" + orderDesc + "" + delivAdd + ""
			+ orderDate + "" + delivDate + "" + orderAmount + "";
}







 
}
