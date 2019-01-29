package majd.project.superclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public abstract class Vehicle {
	@Id @GeneratedValue
	private Integer id;
	private String type;
	private Integer speed;
	
	
	
	public Vehicle() {
	}

	public Vehicle(String type, Integer speed) {
		this.type = type;
		this.speed = speed;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
}
