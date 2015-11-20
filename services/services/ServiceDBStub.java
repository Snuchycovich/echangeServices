package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
	@Override
	public void create(Service s) throws IllegalArgumentException
	{
		this.services.add(s);
	}
	
	@Override
	public Collection<Service> retrieveAll(){
		return this.services;
	}
	
	@Override
	public Service retrieve(int id) throws Exception {
		for(Service s : this.services){
			Integer serviceId = s.getId();
			if(serviceId.equals(id)) {
				return s;
			}
		}
		throw new IndexOutOfBoundsException("No service with id" + id);
		
	}

	@Override
	public void update(String title, String Description, String type, String category, Date limitDate)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws IndexOutOfBoundsException {
		int index = -1;
		for (int i = 0; i < services.size(); i++) {
			Integer serviceId = this.services.get(i).getId();
			if(serviceId.equals(id)){
				index = i;
				break;
			}
		}
		if(index == -1){
			throw new IndexOutOfBoundsException("No service with id" +id);
		}
		this.services.remove(index);
	}
	
}
