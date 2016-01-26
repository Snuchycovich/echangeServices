package webapp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import persons.Person;
import services.Service;

public class Algo {

	private LinkedHashMap<Person, List> closed;
	private Deque open;
	
	public Algo() {
		this.closed = new LinkedHashMap<Person,List>();
		this.open = new LinkedList<Person>();
	}
	
	public String runAlgoServiceDemande(Person p1, Service service, Hashtable<Person, List> listServicesDemandes, Hashtable<Person, List> listeServicesOfferts) {
		this.open.add(p1);
		int level = 0;
		String test = "";

		LinkedList<Triplet> list = new LinkedList<Triplet>();
		list.add(new Triplet(null, null, level));
		this.closed.put(p1, list);
		
		List<Service> servicep1 = new ArrayList<Service>();
		servicep1.add(service);
		listServicesDemandes.put(p1, servicep1);
		
		while(!open.isEmpty()) {
			Person p = (Person) open.pop();
			
			List<Service> servicesDemandes = listServicesDemandes.get(p);
			
			for(Service s : servicesDemandes) {
				int levelClosedPerson = level;
				Iterator i = listeServicesOfferts.keySet().iterator();
				while (i.hasNext())
				{
					Person person = (Person)i.next();
					
					if(!person.equals(p)) {
						
						List<Service> servicesOfferts = (List<Service>)listeServicesOfferts.get(person);
						List<Service> closedPerson = closed.get(person);
						
						if(servicesOfferts.contains(s)) {
							if(person.equals(p1)) {
								return computeCycle(closed, p1, service);
							}
							else if(closedPerson == null){
								open.add(person);
								LinkedList<Triplet> newListTriplet = new LinkedList<Triplet>();
								newListTriplet.add(new Triplet(p, s, level+1));
								closed.put(person, newListTriplet);
								levelClosedPerson = level+1;
							}
							else if(levelClosedPerson == level+1) {
								List<Triplet> newListTriplet = closed.get(person);
								newListTriplet.add(new Triplet(p, s, level+1));
							}
						}
					}
				}
			}
			
			level++;
		}
		return errorCycle();
	}
	
	public String runAlgoServiceOffert(Person p1, Service service, Hashtable<Person, List> listServicesDemandes, Hashtable<Person, List> listeServicesOfferts) {
		return "";
	}
	
	public String computeCycle(LinkedHashMap<Person, List> closed2, Person person, Service service) {
		String res = "Pour obtenir le service "+service+", le cycle le plus court est : ";
		
		Set<Person> keys = closed2.keySet();
		int count = 0;
		
        for(Person p: keys){
        	
        	if(count == 0) {
        		res += "<b>"+p.getFirstName()+" "+p.getName()+"</b> -> (<i>{null, null, 0}</i>) , ";
        	} else {
        		res += "<b>"+p.getFirstName()+" "+p.getName()+"</b> -> (";
        		List<Triplet> triplets = closed.get(p);
        		for(Triplet t: triplets) {
            			res += "<i>"+t+"</i> ";
            	}
        		if(count+1 < keys.size())
        			res += ") , ";
        	}
        	count++;
        }
        return res;
	}
	
	public String errorCycle() {
		return "Pas de cycle possible";
	}
	
}
