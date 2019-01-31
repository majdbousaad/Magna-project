package majd.project.classes.passenger;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import majd.project.classes.passenger.Passenger;
import majd.project.superclasses.vehicle.Vehicle;
import majd.project.superclasses.vehicle.VehicleRepository;

@Service
public class PassengerService {
	

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
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
	
	public void assignPassengersToVehicle(List<Passenger> passengers, Integer vehicleId)  {
		
		Vehicle vehicle = null;
		try {
			 vehicle = vehicleRepository.findById(vehicleId).get();
		} catch (Exception e) {
			throw new RuntimeException("Vehicle with id " + vehicleId + " does not exist!", e);
		}
		
		
		for(Passenger passenger : passengers) {
			passenger.setVehicle(vehicle);
			try {
				passengerRepository.save(passenger);
			} catch (Exception e) {
				
				throw new RuntimeException("Error saving some passenger", e);
			}
			
			
			vehicle.getPassengers().add(passenger);
			
		}
		vehicleRepository.save(vehicle);
	}
	
	public Iterable<Passenger> findPassengersOfVehicleId(Integer vehicleId) {
		return passengerRepository.findByVehicleId(vehicleId);
	}
}
