package majd.project.car.wheels;

import javax.persistence.Embeddable;

@Embeddable
public class Wheels {
	
	private int number = 0;
	private String size;
	
	
	public Wheels() {
	}
	
	public Wheels(int number, String size) {
		this.number = number;
		this.size = size;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getsize() {
		return size;
	}
	public void setsize(String size) {
		this.size = size;
	}
	
	
}
