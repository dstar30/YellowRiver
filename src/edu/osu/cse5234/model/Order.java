package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> list = new ArrayList<Item>();
	
	public ArrayList<Item> getList() {
		return list;
	}

	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	
}
