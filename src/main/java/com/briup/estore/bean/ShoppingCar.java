package com.briup.estore.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCar {

	private Map<Integer, EOrderline> car = new HashMap<>();
	
	public Collection<EOrderline> getItems(){
		return car.values();
	}
	
	public void add(EBook book,int num) {
		EOrderline line = car.get(book.getId());
		if (line==null) {
			line = new EOrderline();
			line.setBook(book);
			line.setNum(num);
			car.put(book.getId(), line);
		}else {
			line.setNum(line.getNum()+num);
		}
	}
	
	public void remove(Integer bookId) {
		car.remove(bookId);
	}
	
	public void clear() {
		car.clear();
	}
	
	public int getCountNum() {
		int count = 0;
		for(EOrderline line:car.values()) {
			count += line.getNum();
		}
		return count;
	}
	
	public Float getPriceNum() {
		float price = 0;
		for(EOrderline line:car.values()) {
			price += line.getBook().getPrice()*line.getNum();
		}
		return price;
	}
}
