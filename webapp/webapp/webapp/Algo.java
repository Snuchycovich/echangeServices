package webapp;

import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import persons.Person;
import services.Service;

public class Algo {

	private Hashtable<Person, List> closed;
	private Deque open;
	
	public Algo() {
		this.closed = new Hashtable<Person,List>();
		this.open = new LinkedList<Person>();
	}
	
	public void run(Person p1, Service service, PersonServiceAssociation psa) {
		this.open.add(p1);
		
		LinkedList<Triplet> list = new LinkedList<Triplet>();
		list.add(new Triplet(null, null, 0));
		this.closed.put(p1, list);
		
		while(!open.isEmpty()) {
			Person p = (Person) open.pop();
		}
	}
	
}
