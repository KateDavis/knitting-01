package com.knitting.journal.model;

import java.util.Date;

/**
 * Simple model object to represent a trade transaction.
 *
 */
public class Transaction {
	private final Date date;
	
	public Transaction(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
}
