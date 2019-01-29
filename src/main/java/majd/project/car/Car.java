package majd.project.car;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import majd.project.car.wheels.Wheels;
import majd.project.superclasses.Vehicle;

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
	
	
}
