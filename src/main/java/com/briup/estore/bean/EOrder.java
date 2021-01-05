package com.briup.estore.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class EOrder implements Serializable {
    private Integer id;

    private Float total;

    private Date orderdate;

    private Integer customerId;
    
    private Collection<EOrderline> line;

    private static final long serialVersionUID = 1L;
    
    public int getNums() {
    	int count = 0;
    	for(EOrderline orderline:line) {
    		count += orderline.getNum();
    	}
    	return count;
    }

    public Collection<EOrderline> getLine() {
		return line;
	}

	public void setLine(Collection<EOrderline> line) {
		this.line = line;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}