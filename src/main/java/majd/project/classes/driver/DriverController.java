package majd.project.classes.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import majd.project.classes.driver.Driver;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping("/drivers")
	public Iterable<Driver> showDrivers() {
		return driverService.getAllDrivers();
	}
	@RequestMapping("/driver/{id}")
	public Driver showDriver(@PathVariable Integer id) {
		return driverService.getDriver(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/driver")
	public void addDriver(@RequestBody Driver driver) {
		driverService.addDriver(driver);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/driver/{id}")
	public void deleteDriver(@PathVariable Integer id) {
		driverService.deleteDriver(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/assign/driver/{driverId}/to/car/{carId}")
	public void assignCarToDriver(@PathVariable Integer carId, @PathVariable Integer driverId) {
		
		driverService.assignCarToDriver(driverId, carId);
	}
	
	@RequestMapping("/find/driver/of/car/{carId}")
	public Driver getDriverByCarId(@PathVariable Integer carId) {
		return driverService.getDriverByCarId(carId);
	}
}
