package services;


/**
 * 
 * @author Julien Foucault- Universit&eacute; de Caen Basse-Normandie, France
 * @author Emiliano Castillo - Universit&eacute; de Caen Basse-Normandie, France
 * @since Janaury 2016
 */
public class Service {
	
	/** The Service's id */
	protected int id;
	
	/** The Service's title */ 
	protected String title;
	
	
	/**
	 * Builds a new service.
	 * @param id The service's id
	 * @param title The service's title
	 */
	public Service(int id, String title)
	{
		this.id = id;
		this.title = title;
	}
	
	/**
	 * Builds a new service.
	 * @param title The service's title
	 */
	public Service(String title)
	{
		this.title = title;
	}
	
	/**
	 * Return the service's id
	 * @return The service's id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Modify the service's id value 
	 * @param id The service's title
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
	/**
	 * Modify the service's title value 
	 * @param title The service's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	/**
	 * @return the service's string "title" 
	 */
	public String toString() {
		return "\""+title+"\"";
	}
	
	/**
	 * Check if an Object is a Service
	 * @param Object
	 */
	public boolean equals(Object o) {
	    if(o == null) return false;
	    if( !(o instanceof Service) ) return false;
	
	    Service other = (Service) o;
	    return id == other.id;
    }

}
