package majd.project.classes.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;
	
	public Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}
	public Car getCar(Integer id) {
		Car car = null;
		try {
			car = carRepository.findById(id).get();
		} catch (Exception e) {
			throw new RuntimeException("Car " + id + " does not exist", e);
		}
		return car;
	}
	public void addCar(Car car) {
		carRepository.save(car);
	}
	public void deleteCar(Integer id) {
		
		try {
			carRepository.deleteById(id);
		} catch (Exception e) {
			
			throw new RuntimeException("Car " + id + " does not exist", e);
		}
		
	}
	
}
