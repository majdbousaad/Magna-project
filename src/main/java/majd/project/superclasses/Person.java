package majd.project.superclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Person_Generator")
	@SequenceGenerator(name="Person_Generator", sequenceName="Person_Seq")
	private Integer id;
	private String name;
	private Integer age;
	private String country;
	
	
	
	public Person() {
	}

	public Person(String name, Integer age, String country) {
		this.name = name;
		this.age = age;
		this.country = country;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
