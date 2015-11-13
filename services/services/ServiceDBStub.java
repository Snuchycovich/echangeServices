package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Emiliano Castillo
 * @since Novembre 2015
 */
public class ServiceDBStub implements IServiceDB{
	
	/** List of services */
	protected List<Service> services;
	
	/** Build a new empty list of services */
	public ServiceDBStub(){
		this.services = new ArrayList<Service> ();
	}
	
	public void create(Service s) throws IllegalArgumentException
	{
		this.services.add(s);
	}
	
	public Collection<Service> retrieveAll(){
		return this.services;
	}
	
}
