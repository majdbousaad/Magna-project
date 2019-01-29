package majd.project.classes.motorcycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MotorCycleController {
	
	@Autowired
	private MotorCycleService motorCycleService;
	
	@RequestMapping("/motors")
	public Iterable<MotorCycle> showMotorCycles() {
		return motorCycleService.getAllMotorCycles();
	}
	@RequestMapping("/motor/{id}")
	public MotorCycle showMotorCycle(@PathVariable Integer id) {
		return motorCycleService.getMotorCycle(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/motor")
	public void addMotorCycle(@RequestBody MotorCycle MotorCycle) {
		motorCycleService.addMotorCycle(MotorCycle);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/motor/{id}")
	public void deleteMotorCycle(@PathVariable Integer id) {
		motorCycleService.deleteMotorCycle(id);
	}
	
	
}
