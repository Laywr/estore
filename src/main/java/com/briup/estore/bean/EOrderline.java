package com.briup.estore.bean;

import java.io.Serializable;

public class EOrderline implements Serializable {
    private Integer id;

    private Integer num;

    private Integer bookId;
    
    private EBook book;

    private Integer orderId;

    private static final long serialVersionUID = 1L;
    

    public EBook getBook() {
		return book;
	}

	public void setBook(EBook book) {
		this.book = book;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}