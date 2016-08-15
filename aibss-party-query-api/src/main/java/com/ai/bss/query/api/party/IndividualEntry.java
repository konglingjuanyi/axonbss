package com.ai.bss.query.api.party;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("INDIVIDUAL")
@SecondaryTable(
	    name = "PT_INDIVIDUAL",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "INDIVIDUAL_ID")
)
public class IndividualEntry extends PartyEntry{
	@Column(table="PT_INDIVIDUAL",name="FIRST_NAME")
	private String firstName;
	@Column(table="PT_INDIVIDUAL",name="LAST_NAME")
	private String lastName;

	
	public IndividualEntry(){}
	
	public IndividualEntry(String partyId,String firstName,String lastName){
		super(partyId,"Individual");
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public IndividualEntry(String firstName,String lastName){
		super();
		this.setType("Individual");
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		super.setName(this.getLastName()+" "+firstName);
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		super.setName(lastName+" "+this.getFirstName());
		this.lastName = lastName;
	}

	@Override
	public String getName() {
		return this.firstName+" "+this.lastName;
	}

}
