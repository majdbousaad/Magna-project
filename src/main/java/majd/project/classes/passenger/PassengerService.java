package majd.project.classes.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import majd.project.classes.passenger.Passenger;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public Iterable<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}
	public Passenger getPassenger(Integer id) {
		Passenger passenger = null;
		try {
			passenger = passengerRepository.findById(id).get();
		} catch (Exception e) {
			throw new RuntimeException("Passenger " + id + " does not exist", e);
		}
		return passenger;
	}
	public void addPassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}
	public void deletePassenger(Integer id) {
		try {
			passengerRepository.deleteById(id);
		} catch (Exception e) {
			
			throw new RuntimeException("Passenger " + id + " does not exist", e);
		}
		
	} 
}
