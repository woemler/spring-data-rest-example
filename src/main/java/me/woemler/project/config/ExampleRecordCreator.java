package me.woemler.project.config;

import me.woemler.project.models.Person;
import me.woemler.project.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author woemler
 */
@Component
public class ExampleRecordCreator implements CommandLineRunner {

	@Autowired private PersonRepository personRepository;
	
	@Override 
	public void run(String... strings) throws Exception {

		Person person = new Person();
		person.setName("Joe Smith");
		person.setGender("M");
		person.setAge(35);
		personRepository.save(person);
		
		person = new Person();
		person.setName("Sue Jones");
		person.setGender("F");
		person.setAge(45);
		personRepository.save(person);
		
		person = new Person();
		person.setName("Hank Roberts");
		person.setAge(67);
		person.setGender("M");
		personRepository.save(person);
		
	}
}
