package persons;

import java.util.Date;

/**
 * A class for representing persons, with a name, a first name, and an email address.
 * @author Charlotte Lecluze and Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France
 * @since January, 2016
 */
public class Person {
	
	/** The person's id */
	protected int id;

    /** The person's name. */
    protected String name;

    /** The person's first name. */
    protected String firstName; 

    /** The person's email address. */
    protected String email;
    
    /** The person's subscription date. */
    protected Date subscriptionDate;
    
    /** The person's role. */
    protected int role;
    
    /**
     * Builds a new person.
     * @param name The person's name
     * @param firstName The person's first name
     * @param email The person's email address
     */
    public Person (String name, String firstName, String email) {
        this.name=name;
        this.firstName=firstName;
        this.email=email;
        this.subscriptionDate = new Date();
    }
    
    /**
     * Builds a new person.
     * @param id the person's id
     * @param name The person's name
     * @param firstName The person's first name
     * @param email The person's email address
     * @param role The person's role
     */
    public Person (int id, String name, String firstName, String email, int role) {
    	this.id = id;
        this.name=name;
        this.firstName=firstName;
        this.email=email;
        this.subscriptionDate = new Date();
        this.role = role;
    }
    
    /**
	 * Return the person's id
	 * @return the person's id
	 */
	public int getId() {
		return id;
	}

    /**
     * Returns the person's name.
     * @return The person's name
     */
    public String getName () {
        return this.name;
    }

    public void setName(String name) {
		this.name = name;
	}

	/**
     * Returns the person's first name.
     * @return The person's first name.
     */
    public String getFirstName () {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
     * Returns the person's email address.
     * @return The person's email address
     */
    public String getEmail () {
        return this.email;
    }
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    /**
     * Returns the person's email address.
     * @return The person's email address
     */
    public Date getSubscriptionDate () {
        return this.subscriptionDate;
    }

    /**
     * Returns a representation of this person as a string.
     * @return A representation of this person as a string
     */
    public String toString () {
        return "\""+this.firstName+" "+this.name+"\"";
    }
    /**
     * Returns the person's role
     * @return the person's role 1 Public 0 Admin
     */
	public int getRole() {
		return role;
	}

    public void setRole(int role) {
    	this.role = role;
    }
    
    public int hashCode(){
        return id;
    }
    
    public boolean equals(Object o) {
	    if(o == null) return false;
	    if( !(o instanceof Person) ) return false;
	
	    Person other = (Person) o;
	    return id == other.id;
    }
}
