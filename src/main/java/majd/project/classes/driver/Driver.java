package majd.project.classes.driver;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import majd.project.classes.car.Car;
import majd.project.superclasses.person.Person;

@Entity
public class Driver extends Person {
	
	private String destination;
	
	@OneToOne
	@JsonBackReference
	private Car car;
	
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
	

}
