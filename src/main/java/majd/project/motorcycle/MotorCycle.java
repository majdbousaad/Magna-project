package majd.project.motorcycle;

import javax.persistence.Entity;

import majd.project.superclasses.Vehicle;

@Entity
public class MotorCycle extends Vehicle{
	
	private HelmetStrength helmetStrength;
	private String fuelType;
	
	public MotorCycle() {
	}

	public MotorCycle(String type, int speed, HelmetStrength helmetStrength, String fuelType) {
		super(type, speed);
		this.helmetStrength = helmetStrength;
		this.fuelType = fuelType;
	}
	
	public HelmetStrength getHelmetStrength() {
		return helmetStrength;
	}
	public void setHelmetStrength(HelmetStrength helmetStrength) {
		this.helmetStrength = helmetStrength;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	
	
	
	
}
