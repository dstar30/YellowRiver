package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CREDIT_CARD_NUMBER")
	private String credit_card_number;
	@Column(name="EXPIRATION_DATE")
	private String expiration_date;
	@Column(name="CVV_CODE")
	private String cvvCode;
	@Column(name="CARD_HOLDER_NAME")
	private String card_holder_name;
	
	public PaymentInfo(){};
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCredit_card_number() {
		return credit_card_number;
	}
	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
	
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	
	public String getCard_holder_name() {
		return card_holder_name;
	}
	public void setCard_holder_name(String card_holder_name) {
		this.card_holder_name = card_holder_name;
	}
	
	
}
