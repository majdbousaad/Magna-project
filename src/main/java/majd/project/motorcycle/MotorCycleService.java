package majd.project.motorcycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorCycleService {
	
	@Autowired
	private MotorCycleRepository motorCycleRepository;
	
	public Iterable<MotorCycle> getAllMotorCycles() {
		return motorCycleRepository.findAll();
	}
	public MotorCycle getMotorCycle(Integer id) {
		return motorCycleRepository.findById(id).get();
	}
	public void deleteMotorCycle(Integer id) {
		motorCycleRepository.deleteById(id);
	}
	public void addMotorCycle(MotorCycle motorCycle) {
		motorCycleRepository.save(motorCycle);
	}
}
