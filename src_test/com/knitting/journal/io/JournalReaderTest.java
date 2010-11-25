package com.knitting.journal.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.knitting.journal.io.opendocument.ODTJournalReader;
import com.knitting.journal.model.Transaction;

public class JournalReaderTest {
	
	@Test
	public void validateSingleRow() throws URISyntaxException {
		
		URL url = this.getClass().getResource("test-transactions.ods");
		File file = new File(url.toURI());
		System.err.println(file.getAbsolutePath());
		
		JournalReader reader = new ODTJournalReader(file);
		reader.load();
		ValidationResults results = reader.getValidationResults();
		assertEquals(results.toString(), results.errorCount(), 0);
		
		List<Transaction> transactions = results.getTransactions();
		assertTrue(transactions.size() >= 1);
		
		Transaction transaction = transactions.get(0);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		assertEquals("11/24/2010", sdf.format(transaction.getDate()));
	}
}
