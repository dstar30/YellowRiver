package edu.osu.cse5234.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.osu.cse5234.business.view.Item;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	@Column(name="STATUS")
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> items;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK",insertable=false, updatable=false)
	private PaymentInfo paymentInfo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK",insertable=false, updatable=false)
	private ShippingInfo shippingInfo;
	
	public Order(){};

//private ArrayList<Item> list = new ArrayList<Item>();
//	public ArrayList<Item> getList() {
//		return list;
//	}
//
//	public void setList(ArrayList<Item> list) {
//		this.list = list;
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	
	
}
