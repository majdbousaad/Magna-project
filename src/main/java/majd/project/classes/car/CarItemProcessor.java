package majd.project.classes.car;

import org.springframework.batch.item.ItemProcessor;

public class CarItemProcessor implements ItemProcessor<Car, Car>{
	
	@Override
	public Car process(Car item) throws Exception {
		
		return item;
	}
}
