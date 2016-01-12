package webapp;

import java.util.Date;

public class PersonServiceAssociation {

	private int id;
	private String emailPerson;
	private int id_service;
	private String description;
	private Date limitDate;
	private Date creationDate;
	private boolean type;
	
	public PersonServiceAssociation(String emailPerson, int idService, String desc, Date limitDate, boolean type) {
		this.emailPerson = emailPerson;
		this.id_service = idService;
		this.description = desc;
		this.creationDate = new Date();
		this.limitDate = limitDate;
		this.type = type;
	}

	
	public int getId() {
		return id;
	}


	public String getEmailPerson() {
		return emailPerson;
	}



	public void setEmailPerson(String emailPerson) {
		this.emailPerson = emailPerson;
	}



	public int getId_service() {
		return id_service;
	}



	public void setId_service(int id_service) {
		this.id_service = id_service;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
	
}
