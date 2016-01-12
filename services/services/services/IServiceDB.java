package services;

import java.util.Collection;
import java.util.Date;

public interface IServiceDB {

	/**
	 * Add a service to database
	 * @param s The service to add to the database
	 * @return The Id of the created service
	 * @throws Exception if not a instance of service error occurs
	 */
	public int create(Service s)throws Exception;
	
	/**
	 * Returns the list of all services in this database.
	 * @return
	 * @throws Exception
	 */
	public Collection<Service> retrieveAll() throws Exception;
	
	/**
	 * Return the service with the given id
	 * @param id The service's id
	 * @return The service with the given id
	 * @throws Exception if no service with given id exists in the list or database error occurs
	 */
	public Service retrieve (int id) throws Exception;
	
	/**
	 * Update informations about a service
	 * @param a Service Object
	 * @throws Exception if database error occurs
	 */
	public void update (Service s) throws Exception;
	
	/**
	 * Remove the service with the given id from this database
	 * @param id The service's id
	 * @throws Exception if no service with given id exists in the list or database error occurs
	 */
	public void delete (int id) throws Exception;
}
