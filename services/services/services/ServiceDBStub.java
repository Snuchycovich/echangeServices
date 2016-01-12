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
	public int create(Service s) throws IllegalArgumentException
	{
		this.services.add(s);
		return s.getId();
	}
	
	@Override
	public Collection<Service> retrieveAll(){
		return this.services;
	}
	
	@Override
	public Service retrieve(int id) throws Exception {
		for(Service s : this.services){
			Integer serviceId = (int) s.getId();
			if(serviceId.equals(id)) {
				return s;
			}
		}
		throw new IndexOutOfBoundsException("No service with id" + id);
		
	}
	
	public void delete(int id) throws IndexOutOfBoundsException {
		int index = -1;
		for (int i = 0; i < services.size(); i++) {
			Integer serviceId = (int) this.services.get(i).getId();
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
	@Override
	public void update(Service s) throws Exception {
		for(Service service : this.services){
			Integer serviceId = (int) service.getId();
			if(serviceId.equals(s.getId())) {
				service.setTitle(s.getTitle());
				service.setLimitDate(s.getLimitDate());
			}
		}
	}
	
}
