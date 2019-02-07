package majd.project.classes.car;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	JobLauncher jobLauncher;
 
	@Autowired
	Job job;
	
	@Autowired 
	private TaskScheduler taskScheduler;
	
	@Autowired 
	private CarTask carTask;
	
	
	@RequestMapping("/cars")
	public Iterable<Car> showCars() {
		return carService.getAllCars();
	}
	@RequestMapping("/car/{id}")
	public Car showCar(@PathVariable Integer id) {
		return carService.getCar(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/car")
	public void addCar(@RequestBody Car car) {
		carService.addCar(car);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/car/{id}")
	public void deleteCar(@PathVariable Integer id) {
		carService.deleteCar(id);
	}
	
	@RequestMapping("/download/cars")
	public String execute() throws Exception {
		taskScheduler.schedule(carTask,  new CronTrigger("0 * * * * ?"));

		return "<h>Done. This task will be triggered every minute from now on</h>";
		
	}
}
