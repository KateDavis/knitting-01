package com.knitting.journal.io;

/**
 * Contract API for reading journal information.
 *
 */
public interface JournalReader {

	void load();

	ValidationResults getValidationResults();

}
