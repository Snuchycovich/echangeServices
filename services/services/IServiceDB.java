package services;

import java.util.Collection;

public interface IServiceDB {

	/**
	 * Add service to database
	 * @param s
	 * @throws Exception
	 */
	public void create(Service s)throws Exception;
	
	/**
	 * Returns the list of all services in this database.
	 * @return
	 * @throws Exception
	 */
	public Collection<Service> retrieveAll() throws Exception;
}
