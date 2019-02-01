package majd.project.classes.passenger;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PassengerRepository extends CrudRepository<Passenger, Integer>{
	public Iterable<Passenger> findByVehicleId(Integer vehicleId);
	

}
