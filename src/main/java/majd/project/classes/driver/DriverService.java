package majd.project.classes.driver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import majd.project.classes.car.CarRepository;

@Service
public class DriverService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private CarRepository carRepository;
	
	public Iterable<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}
	public Driver getDriver(Integer id) {
		return driverRepository.findById(id).get();
	}
	public void addDriver(Driver driver) {
		driverRepository.save(driver);
	}
	public void deleteDriver(Integer id) {
		driverRepository.deleteById(id);
	}
	public Driver getDriverByCarId(Integer carId) {
		
		
		Query query = entityManager.createNativeQuery("SELECT * FROM driver WHERE car_id = ?");
		query.setParameter(0, carId);
		
		
		return (Driver) query.getResultList();
	}
	public void assignCarToDriver(Integer driverId, Integer carId) {
		Driver driver = driverRepository.findById(driverId).get();
		driver.setCar(carRepository.findById(carId).get());
		driverRepository.save(driver);
	}
}
