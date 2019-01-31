package majd.project.classes.passenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import majd.project.superclasses.person.Person;
import majd.project.superclasses.vehicle.Vehicle;

@Entity
public class Passenger extends Person {
	
	@Column(nullable=false)
	private String destination;
	private int payment;
	
	
	@ManyToOne
	@JsonBackReference
	private Vehicle vehicle;
	
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
