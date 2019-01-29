package majd.project.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import majd.project.passenger.Passenger;

@RestController
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@RequestMapping("/passengers")
	public Iterable<Passenger> showPassengers() {
		return passengerService.getAllPassengers();
	}
	@RequestMapping("/passenger/{id}")
	public Passenger showPassenger(@PathVariable Integer id) {
		return passengerService.getPassenger(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/passenger")
	public void addPassenger(@RequestBody Passenger passenger) {
		passengerService.addPassenger(passenger);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/passenger/{id}")
	public void deletePassenger(@PathVariable Integer id) {
		passengerService.deletePassenger(id);
	}
}
