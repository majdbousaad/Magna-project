package majd.project.classes.car;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import majd.project.classes.car.wheels.Wheels;
import majd.project.classes.driver.Driver;
import majd.project.superclasses.vehicle.Vehicle;

@Entity
public class Car extends Vehicle {
	
	private int numberOfDoors;
	private String fuelType;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="number", column=@Column(name="Number_Of_Wheels")),
			@AttributeOverride(name="size", column=@Column(name="Wheel_Size"))
	})
	private Wheels wheels;
	
	@OneToOne(mappedBy="car")
	private Driver driver;
	
	public Car(String type, int speed, int numberOfDoors, String fuelType) {
		super(type, speed);
		this.numberOfDoors = numberOfDoors;
		this.fuelType = fuelType;
		
	}
	
	public Car() {
	}

	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
