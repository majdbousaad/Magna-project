package majd.project.classes.driver;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import majd.project.superclasses.vehicle.Vehicle;
import majd.project.superclasses.vehicle.VehicleRepository;


@Service
public class DriverService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
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
	public Driver getDriverByVehicleId(Integer vehicleId) {
		
		Query query = entityManager.createQuery("SELECT b FROM Driver b WHERE vehicle_id = ?1", Driver.class);
		
		query.setParameter(1, vehicleId);
		Driver driver = null;
		try {
			driver = (Driver) query.getResultList().get(0);
		} catch (Exception e) {
			throw new RuntimeException("No driver assigned to vehicle " + vehicleId, e);
		}
		return driver;
	}
	public void assignVehicleToDriver(Integer driverId, Integer vehicleId) {
		Driver driver = null;
		Vehicle vehicle = null;
		Query query = entityManager.createQuery("SELECT b FROM Vehicle b WHERE id = ?1", Vehicle.class);
		query.setParameter(1, vehicleId);
		
		try {
			driver = driverRepository.findById(driverId).get();
			vehicle = (Vehicle) query.getResultList().get(0);
			
		} catch (Exception e) {
			throw new RuntimeException("Error finding Driver " + driverId + " or Vehicle " + vehicleId, e);
		}
		vehicle.setDriver(driver);
		vehicleRepository.save(vehicle);
		
		driver.setVehicle(vehicle);
		driverRepository.save(driver);
		
		
	}
}
