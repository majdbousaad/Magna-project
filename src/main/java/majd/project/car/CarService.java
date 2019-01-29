package majd.project.car;

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
		
		return carRepository.findById(id).get();
	}
	public void addCar(Car car) {
		carRepository.save(car);
	}
	public void deleteCar(Integer id) {
		carRepository.deleteById(id);
	}
	
}
