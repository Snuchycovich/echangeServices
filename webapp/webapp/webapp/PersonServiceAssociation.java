package webapp;

import java.util.Date;

public class PersonServiceAssociation {

	private int idPerson;
	private int idService;
	private String description;
	private Date creationDate;
	
	public PersonServiceAssociation(int idPerson, int idService, String description, Date creationDate) {
		this.idPerson = idPerson;
		this.idService = idService;
		this.description = description;
		this.creationDate = new Date();
	}

	
	public int getIdPerson() {
		return idPerson;
	}


	public int getIdService() {
		return idService;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
}
