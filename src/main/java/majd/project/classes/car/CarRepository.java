package majd.project.classes.car;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
	public Car findByDriverId(Integer driverId);
}
