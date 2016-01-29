package webapp;

import java.util.Date;
/**
 * 
 * @author Julien Foucault- Universit&eacute; de Caen Basse-Normandie, France
 * @author Emiliano Castillo - Universit&eacute; de Caen Basse-Normandie, France
 * @since Janaury 2016
 */
public class PSCompleteInfo {
	
	private int idPerson;
	private int idService;
	private String description;
	private Date creationDate;
	private Date limitDate;
	private int status;
	private String title;
	private String name;
	private String firstName;
	private String email;
	private Date inscriptionDate;
	
	
	
	public PSCompleteInfo(int idPerson, int idService, String description, Date creationDate, Date limitDate, int status, String title, String name, String firstName, String email, Date inscriptionDate) {
		this.idPerson = idPerson;
		this.idService = idService;
		this.description = description;
		this.creationDate = creationDate;
		this.limitDate = limitDate;
		this.status = status;
		this.title = title;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.inscriptionDate = inscriptionDate;
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

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}
	
}
