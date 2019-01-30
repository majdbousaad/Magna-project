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
		Driver driver = null;
		try {
			driver = driverRepository.findById(id).get();
		} catch (Exception e) {
			throw new RuntimeException("Driver " + id + " does not exist", e);
		}
		return driver;
	}
	public void addDriver(Driver driver) {
		driverRepository.save(driver);
	}
	public void deleteDriver(Integer id) {
		
		try {
			driverRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Driver " + id + " does not exist", e);
		}
		
	}
	public Driver getDriverByCarId(Integer carId) {
		
		Query query = entityManager.createNativeQuery("SELECT * FROM driver WHERE car_id = ?", Driver.class);
		query.setParameter(1, carId);
		Driver driver = null;
		try {
			driver = (Driver) query.getResultList().get(0);
		} catch (Exception e) {
			throw new RuntimeException("No driver assigned to car " + carId, e);
		}
		return driver;
	}
	public void assignCarToDriver(Integer driverId, Integer carId) {
		Driver driver = null;
		try {
			driver = driverRepository.findById(driverId).get();
			driver.setCar(carRepository.findById(carId).get());
			
		} catch (Exception e) {
			throw new RuntimeException("Error finding Driver " + driverId + " or Car " + carId, e);
		}
		driverRepository.save(driver);
		
	}
}
