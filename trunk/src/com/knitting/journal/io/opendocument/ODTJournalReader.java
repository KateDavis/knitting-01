package com.knitting.journal.io.opendocument;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.jopendocument.dom.ODValueType;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.knitting.journal.io.JournalReader;
import com.knitting.journal.io.ValidationResults;
import com.knitting.journal.model.Transaction;

public class ODTJournalReader implements JournalReader {
	private static enum TABS {Transactions};
	private static enum COLS {Date};

	private final File file;
	private ValidationResults results = new ValidationResults();

	public ODTJournalReader(File file) {
		this.file = file;
	}


	public ValidationResults load() {
		SpreadSheet ss = safeLoadFile();
		if (ss != null) {
			loadTransactions(ss);
		}
		return results;
	}

	private void loadTransactions(SpreadSheet ss) {
		Sheet sheet = ss.getSheet(TABS.Transactions.toString(), false);
		if (sheet == null) {
			results.addError("Unable to find sheet: " + TABS.Transactions);
			return;
		}
		
		int row = findNextDataRow(sheet, 0);
		while (row != -1) {
			Transaction transaction = loadTransaction(sheet, row);
			if (transaction != null) {
				results.addTransaction(transaction);
			}
			row = findNextDataRow(sheet, row + 1);
		}
		
		if (results.getTransactions().size() == 0) {
			results.addError("No Transactions found to load");
		}
	}

	private Transaction loadTransaction(Sheet sheet, int row) {
		int col = COLS.Date.ordinal();
		MutableCell<SpreadSheet> cell = sheet.getCellAt(col, row);
		System.err.println(String.format("found at %d, %d : %s : %s", col, row, cell.getValue(), cell.getValueType()));
		Object value = cell.getValue();
		if (!(value instanceof Date)) {
			results.addError("expecting Date type for " + COLS.Date + " at row " + row + "; col " + col);
			return null;
		}
		
		return new Transaction((Date)value);
	}

	/**
	 * Use 'date' to determine the next row with data.  Find the next row, beginning with start, whose value
	 * in the 'date' column actually is a date.  This will skip blank lines and header rows
	 * 
	 * @param sheet
	 * @param start
	 * @return
	 */
	private int findNextDataRow(Sheet sheet, int start) {
		int rowFound = -1;
		int col = COLS.Date.ordinal();
		int rowCount = sheet.getRowCount();
		for (int row = start; row < Math.min(rowCount, start+100); row++) {
			MutableCell<SpreadSheet> cell = sheet.getCellAt(col, row);
			ODValueType valueType = cell.getValueType();
			if (valueType == ODValueType.DATE) {
				rowFound = row;
				break;
			}
		}
		return rowFound;
	}

	private SpreadSheet safeLoadFile() {
		SpreadSheet spreadSheet = null;
		
		try {
			spreadSheet = SpreadSheet.createFromFile(file);
		} catch (IOException e) {
			results.addError("Unable to load file: ", e);
		}
		return spreadSheet;
	}

}
