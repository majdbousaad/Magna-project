package majd.project.classes.driver;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Integer>{
	public Optional<Driver> findByVehicleId(Integer vehicleId);

}
