package lab4pkg;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lab4pkg.FoodItem;;

public class Order{
	public final int id;
	public final int qty;
	public final double total;
	public FoodItem foodItems;
	public final String customerName;
	public final String ostatus;
	public final Date created;
	public enum Statuses
	{
		IN_QUEUE, 
		IN_PROGRESS, 
		COMPLETED;
	};

	public Order (int id, FoodItem foodItems, String customerName, String ostatus, Date created,int qty, double total) {
		this.id = id;
		this.foodItems = foodItems;
		this.customerName = customerName;
		this.ostatus = ostatus;
		this.created = created;
		this.qty = qty;
		this.total = total;
	}

	public int getId() {
		return id;
	}
	
	public String getOrderName()
	{
		return this.foodItems.getName();
	}

	public FoodItem getItems() {
		return foodItems;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public String getOstatus() {
		return ostatus;
	}
	
	public Date getCreated()
	{
		return created;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public int getQty()
	{
		return qty;
	}
}
