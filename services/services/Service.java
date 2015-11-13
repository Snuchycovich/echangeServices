package services;

/**
 * Class pour representer un service avec son titre, sa description, son type, et sa categorie.
 * 
 * @author Emiliano Castillo - Universit&eacute; de Caen Basse-Normandie, France
 * @since Novembre 2015
 */
public class Service {
	
	/** The Service's id */
	protected int id;
	
	/** The Service's title */ 
	protected String title;
	
	/** The Service's description */ 
	protected String description;
	
	/** The Service's type */ 
	protected String type;
	
	/** The Service's category */ 
	protected String category;
	
	/** The Service's category */ 
	protected int idPerson;
	
	/**
	 * Builds a new service.
	 * @param id The service's id
	 * @param title The service's title
	 * @param description The service's description
	 * @param type The service's type
	 * @param category The service's category
	 * @param idPerson The service's id Person 
	 */
	public Service(int id, String title, String description, String type, String category, int idPerson)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.category = category;
		this.idPerson = idPerson;
		
	}
	/**
	 * Return the service's id
	 * @return the service's id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Modify the service's id
	 * @param id The service's id
	 */
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Service [id=" + id + ", title=" + title + ", description="
				+ description + ", type=" + type + ", category=" + category
				+ ", idPerson=" + idPerson + "]";
	}

}
