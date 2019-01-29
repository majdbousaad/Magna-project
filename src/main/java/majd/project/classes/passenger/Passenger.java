package majd.project.classes.passenger;

import javax.persistence.Entity;

import majd.project.superclasses.person.Person;

@Entity
public class Passenger extends Person {
	
	private String destination;
	private int payment;
	
	
	public Passenger() {
	}

	public Passenger(String name, int age, String country, String destination, int payment) {
		super(name, age, country);
		this.destination = destination;
		this.payment = payment;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	

}
