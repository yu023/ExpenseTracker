package expenseTracker.dto;

import java.sql.Timestamp;

public class BankBook {
	
	private int bb_id;
	private String bb_category;
	private Boolean bb_type;
	private int bb_money;
	private int bb_amount;
	private Timestamp bb_create_date;
	
	public int getBb_id() {
		return bb_id;
	}
	public void setBb_id(int bb_id) {
		this.bb_id = bb_id;
	}
	public String getBb_category() {
		return bb_category;
	}
	public void setBb_category(String bb_category) {
		this.bb_category = bb_category;
	}
	public Boolean getBb_type() {
		return bb_type;
	}
	public void setBb_type(Boolean bb_type) {
		this.bb_type = bb_type;
	}
	public int getBb_money() {
		return bb_money;
	}
	public void setBb_money(int bb_money) {
		this.bb_money = bb_money;
	}
	public int getBb_amount() {
		return bb_amount;
	}
	public void setBb_amount(int bb_amount) {
		this.bb_amount = bb_amount;
	}
	public Timestamp getBb_create_date() {
		return bb_create_date;
	}
	public void setBb_create_date(Timestamp bb_create_date) {
		this.bb_create_date = bb_create_date;
	}
	
}

