package edu.osu.cse5234.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LineItem(){};
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ITEM_NAME")
	private String name;
	
	@Column(name="QUANTITY")
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
