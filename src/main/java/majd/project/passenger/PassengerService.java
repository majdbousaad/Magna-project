package majd.project.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public Iterable<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}
	public Passenger getPassenger(Integer id) {
		return passengerRepository.findById(id).get();
	}
	public void addPassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}
	public void deletePassenger(Integer id) {
		passengerRepository.deleteById(id);
	} 
}
