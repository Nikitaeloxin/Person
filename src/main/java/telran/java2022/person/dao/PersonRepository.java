package telran.java2022.person.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java2022.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	@Query(value = "SELECT * FROM persons WHERE city = ?1", nativeQuery = true)
	ArrayList<Person> findPersonsByCity(String city);
	
	
	ArrayList<Person> findByNameIgnoreCase(String name);
	
	ArrayList<Person> findByBirthDateBetween(LocalDate from,LocalDate to);
	
	@Query(value = "select city, count(*) from persons group by city", nativeQuery = true)
	ArrayList<String> countByCity();

}
