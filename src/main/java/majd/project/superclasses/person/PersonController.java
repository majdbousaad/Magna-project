package majd.project.superclasses.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import majd.project.superclasses.person.Person;
import majd.project.superclasses.person.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/people")
	public Iterable<Person> showAllPeople() {
		return personRepository.findAll();
	}
	@RequestMapping("/person/{personId}")
	public Person showPersonById(@PathVariable Integer personId) {
		try {
			return personRepository.findById(personId).get();
		} catch (Exception e) {
			throw new RuntimeException("Person with id " + personId + " does not exist!", e);
		}
	}
}
