package com.knitting.journal.io;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.knitting.journal.model.Transaction;

/**
 * Aggregate container to store the results of a full journal validation attempt.  The intent is to
 * attempt the entire validation and store a record of all the errors.  This way, the user can be
 * presented with a list of all errors instead of stopping the process and displaying one error at
 * a time.
 *
 * @see JournalReader
 */
public class ValidationResults {
	private List<Tuple> errors = new ArrayList<Tuple>();
	private List<Transaction> transactions = new ArrayList<Transaction>();

	/**
	 * @return the number of errors found from a journal load
	 */
	public int errorCount() {
		return errors.size();
	}


	/**
	 * @return the list of transactions retrieved from a Journal load
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void addError(String message, Exception e) {
		errors.add(new Tuple(message, e));
	}
	
	public void addError(String message) {
		errors.add(new Tuple(message));
	}
	
	public String toString() {
		StringWriter sw = new StringWriter();
		BufferedWriter buf = new BufferedWriter(sw);
		safeStringWrite(buf);
		
		return sw.getBuffer().toString();
		
	}


	private void safeStringWrite(BufferedWriter buf)  {
		try {
			buf.write(errors.size() + " errors found.");
			for (Tuple tuple : errors) {
				buf.newLine();
				Exception exception = tuple.getException();
				buf.write(String.format("%s : %s", tuple.getMessage(), 
						  (exception == null ? "(no exception)" : exception.getMessage())));
			}
			buf.close();
		} catch (Exception e) {
			System.err.println("Error creating string for output.");
			e.printStackTrace(System.err);
		}
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	
	private class Tuple {

		private final String message;
		private final Exception exception;


		public Tuple(String message, Exception exception) {
			this.message = message;
			this.exception = exception;
		}

		public Tuple(String message) {
			this.message = message;
			this.exception = null;
		}
		
		public String getMessage() {
			return message;
		}

		public Exception getException() {
			return exception;
		}
	}




}
