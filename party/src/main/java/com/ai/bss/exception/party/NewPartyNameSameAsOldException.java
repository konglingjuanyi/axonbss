package com.ai.bss.exception.party;

public class NewPartyNameSameAsOldException extends Exception {
 
 	public NewPartyNameSameAsOldException() {
 	}
 
	public NewPartyNameSameAsOldException( String arg0) {
		super("The new party name "+arg0+" is same as the old  name!");
	 }

}
