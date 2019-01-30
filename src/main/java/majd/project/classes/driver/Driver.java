package majd.project.classes.driver;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import majd.project.superclasses.person.Person;
import majd.project.superclasses.vehicle.Vehicle;

@Entity
public class Driver extends Person {
	
	private String destination;
	
	@OneToOne
	@JsonBackReference
	private Vehicle vehicle;
	
	public Driver() {
	}

	public Driver(String name, int age, String country, String destination) {
		super(name, age, country);
		this.destination = destination;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	

}
