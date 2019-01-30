package majd.project.classes.motorcycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import majd.project.classes.car.Car;

@Service
public class MotorCycleService {
	
	@Autowired
	private MotorCycleRepository motorCycleRepository;
	
	public Iterable<MotorCycle> getAllMotorCycles() {
		return motorCycleRepository.findAll();
	}
	public MotorCycle getMotorCycle(Integer id) {
		MotorCycle motorCycle = null;
		try {
			motorCycle = motorCycleRepository.findById(id).get();
		} catch (Exception e) {
			throw new RuntimeException("MotorCycle " + id + " does not exist", e);
		}
		return motorCycle;
	}
	public void deleteMotorCycle(Integer id) {
		
		try {
			motorCycleRepository.deleteById(id);
		} catch (Exception e) {
			
			throw new RuntimeException("Motorcycle " + id + " does not exist", e);
		}
		
	}
	public void addMotorCycle(MotorCycle motorCycle) {
		motorCycleRepository.save(motorCycle);
	}
}
