package majd.project.superclasses.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Vehicle_Generator")
	@SequenceGenerator(name="Vehicle_Generator", sequenceName="Vehicle_Seq")
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