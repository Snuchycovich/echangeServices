package webapp;

import persons.Person;
import services.Service;

public class Triplet {
	
	private Person person;
	private Service service;
	private int level;
	
	public Triplet(Person person, Service service, int level) {
		this.person = person;
		this.service = service;
		this.level = level;
	}
	
	public Service getService() {
		return service;
	}
	
	public String toString() {
		return "{"+person+","+service+", "+level+" }";
	}
	
}
