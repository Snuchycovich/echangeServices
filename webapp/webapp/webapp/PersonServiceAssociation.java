package webapp;

import java.util.Date;

public class PersonServiceAssociation {

	private int idPerson;
	private int idService;
	private String description;
	private Date creationDate;
	private Date limitDate;
	private int status;
	
	public PersonServiceAssociation(int idPerson, int idService, String description, Date creationDate, Date limitDate, int status) {
		this.idPerson = idPerson;
		this.idService = idService;
		this.description = description;
		this.creationDate = creationDate;
		this.limitDate = limitDate;
		this.status = status;
	}
	
	public PersonServiceAssociation(int idPerson, int idService, String description, Date limitDate, int status) {
		this(idPerson, idService, description, new Date(), limitDate, status);
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
	
	public Date getLimitDate() {
		return limitDate;
	}
	
	public int getStatus() {
		return status;
	}
	
}
