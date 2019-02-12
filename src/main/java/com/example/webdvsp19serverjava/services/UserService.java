package com.example.webdvsp19serverjava.services;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;
import com.example.webdvsp19serverjava.models.Modules;
import com.example.webdvsp19serverjava.models.Person;
import com.example.webdvsp19serverjava.models.Sections;
import com.example.webdvsp19serverjava.models.Students;

import java.util.ArrayList;

@RestController
public class UserService {
	Faculty alex = new Faculty(100, "bird", "bird", "Alice", "Kathie");
	Faculty alice = new Faculty(101, "sign", "sign", "Alex", "Mercer");
	
	Students frank = new Students(100, "ape", "ape", "Frank", "Wolf");
	Students pix = new Students(101, "elf", "elf", "Pix", "Bradley");
	
	Courses cs5610 = new Courses(1, "Web Dev");
	Courses cs5200 = new Courses(2, "Database");
	
	Sections section1 = new Sections(1, "Section 1");
	Sections section2 = new Sections(2, "Section 2");
	
	Modules jquery = new Modules(1, "Jquery");
	Modules react = new Modules(2, "React");
	
//	Person alice = new Person(100, "bird", "bird", "Alice", "Kathie", "Faculty");
//	Person alex = new Person(101, "sign", "sign", "Alex", "Mercer", "Student");
//	Courses cs5610 = new Courses(100, "cs5610");
//	Courses cs5200 = new Courses(101, "cs5200");
//	ArrayList<Person> persons = new ArrayList<Person>();
//	ArrayList<Courses> courses = new ArrayList<Courses>();
//	{
//		courses.add(cs5610);
//		courses.add(cs5200);
//		alice.setCourses(courses);
//		persons.add(alice);
//		persons.add(alex);
//	}
//	
//	@PostMapping("/api/users")
//	public ArrayList<Person> createUser(@RequestBody Person newUser){
//		persons.add(newUser);
//		return persons;
//	}
//	
//	@PutMapping("/api/users/{userID}")
//	public ArrayList<Person> updateUser(@PathVariable("userID") Integer id, 
//										@RequestBody Person newUser){
//		for(Person user : persons) {
//			if(user.getId().equals(id)) {
//				user.setFirstName(newUser.getFirstName());
//				return persons;
//			}
//		}
//		return persons;
//	}
//	
//	@DeleteMapping("/api/users/{userID}")
//	public ArrayList<Person> deleteUser(@PathVariable("userID") Integer id){
//		for(Person user : persons) {
//			if(user.getId().equals(id)) {
//				persons.remove(user);
//				return persons;
//			}
//		}
//		return persons;
//	}
//	
//	@GetMapping("/api/users")
//	public ArrayList<Person> findAllUser() {
//		return persons;
//	}
}
