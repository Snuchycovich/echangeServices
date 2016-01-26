package webapp;

import java.util.Date;

public class PSCompleteInfo {
	
	private int id;
	private String description;
	private Date creationDate;
	private Date limitDate;
	private int status;
	private String title;
	private String name;
	private String firstName;
	private String email;
	private Date inscriptionDate;
	
	
	
	public PSCompleteInfo(int id, String description, Date creationDate, Date limitDate, int status, String title, String name, String firstName, String email, Date inscriptionDate) {
		this.id = id;
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

	public int getId() {
		return id;
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
