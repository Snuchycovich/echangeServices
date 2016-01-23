package webapp;

import java.util.Date;

public class PSCompleteInfo {
	
	private String description;
	private Date creationDate;
	private Date limitDate;
	private int status;
	private String title;
	private String name;
	private String firstName;
	private String email;
	private Date inscriptionDate;
	
	
	
	public PSCompleteInfo(String description, Date creationDate, Date limitDate, int status, String title, String name, String firstName, String email, Date inscriptionDate) {
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public Date getLimitDate() {
		return limitDate;
	}



	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getInscriptionDate() {
		return inscriptionDate;
	}



	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	
	
}
