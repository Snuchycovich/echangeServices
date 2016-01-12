package services;

import java.util.Date;


/**
 * 
 * @author Julien Foucault- Universit&eacute; de Caen Basse-Normandie, France
 * @author Emiliano Castillo - Universit&eacute; de Caen Basse-Normandie, France
 * @since Novembre 2015
 */
public class Service {
	
	/** The Service's id */
	protected int id;
	
	/** The Service's title */ 
	protected String title;
	
	/** The limit date of the service */
	private Date limitDate;
	
	private int status;
	
	
	/**
	 * Builds a new service.
	 * @param id The service's id
	 * @param title The service's title
	 * @param limitDate The service's limit date
	 * @param status The service's status
	 */
	public Service(int id, String title, Date limitDate, int status)
	{
		this.id = id;
		this.title = title;
		this.limitDate = limitDate;
		this.status = status;
	}
	
	/**
	 * Builds a new service.
	 * @param title The service's title
	 * @param limitDate The service's limit date
	 * @param status The service's status
	 */
	public Service(String title, Date limitDate, int status)
	{
		this.title = title;
		this.limitDate = limitDate;
		this.status = status;
	}
	
	/**
	 * Return the service's id
	 * @return the service's id
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 *  Return the service's title
	 * @return The service's title
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 *  Return the service's limit date
	 * @return The service's limit date
	 */
	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 *  Return the service's status (0 if it is an offer, 1 if it is a demand)
	 * @return The service's status
	 */
	public int getStatus() {
		return status;
	}


	@Override
	public String toString() {
		return "Service [id=" + id + ", title=" + title+"]";
	}

	
	

}
