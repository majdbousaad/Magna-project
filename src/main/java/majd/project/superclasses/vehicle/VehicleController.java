package majd.project.superclasses.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@RequestMapping("/vehicles")
	public Iterable<Vehicle> showAllVehicles() {
		return vehicleRepository.findAll();
	}
	@RequestMapping("/vehicle/{vehicleId}")
	public Vehicle showVehicleById(@PathVariable Integer vehicleId) {
		try {
			return vehicleRepository.findById(vehicleId).get();
		} catch (Exception e) {
			throw new RuntimeException("Vehicle with id " + vehicleId + " does not exist!", e);
		}
	}
}
