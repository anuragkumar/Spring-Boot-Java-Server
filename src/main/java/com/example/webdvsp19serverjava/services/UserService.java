package com.example.webdvsp19serverjava.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdvsp19serverjava.models.Chapters;
import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Faculty;
import com.example.webdvsp19serverjava.models.HeadingWidget;
import com.example.webdvsp19serverjava.models.ImageWidget;
import com.example.webdvsp19serverjava.models.LinkWidget;
import com.example.webdvsp19serverjava.models.ListWidget;
import com.example.webdvsp19serverjava.models.Modules;
import com.example.webdvsp19serverjava.models.ParagraphWidget;
import com.example.webdvsp19serverjava.models.Sections;
import com.example.webdvsp19serverjava.models.Students;
import com.example.webdvsp19serverjava.models.Topics;
import com.example.webdvsp19serverjava.models.Widgets;
import com.example.webdvsp19serverjava.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true", allowedHeaders = "*")
public class UserService {
	Random ran = new Random();
	
	@Autowired
    FacultyRepository userRepository;
	
//	Faculty alex = new Faculty(100, "bird", "bird", "Alice", "Kathie");
//	Faculty alice = new Faculty(101, "sign", "sign", "Alex", "Mercer");
//	
//	Students frank = new Students(100, "ape", "ape", "Frank", "Wolf");
//	Students pix = new Students(101, "elf", "elf", "Pix", "Bradley");
//	
//	Courses cs5610 = new Courses(1, "Web Dev");
//	Courses cs5200 = new Courses(2, "Database");
//	Courses cs5600 = new Courses(3, "Software Engineering");
//	
//	Sections section1 = new Sections(1, "Section 1");
//	Sections section2 = new Sections(2, "Section 2");
//	
//	Modules jquery = new Modules(1, "Jquery");
//	Modules react = new Modules(2, "React");
//	Modules sql = new Modules(1, "SQL");
//	Modules jpa = new Modules(2, "JPA");
//	Modules agile = new Modules(1, "Agile");
//	Modules testing = new Modules(2, "Testing");
//	
//	Chapters chapter1 = new Chapters(1, "Lesson 1 Jquery Basics");
//	Chapters chapter2 = new Chapters(2, "Lesson 2 Jquery Syntax");
//	Chapters chapter3 = new Chapters(1, "Lesson 1 React State");
//	Chapters chapter4 = new Chapters(2, "Lesson 2 React Render");
//	Chapters chapter5 = new Chapters(1, "Lesson 1 SQL Syntax");
//	Chapters chapter6 = new Chapters(2, "Lesson 2 SQL Keys");
//	Chapters chapter7 = new Chapters(1, "Lesson 1 JPA API");
//	Chapters chapter8 = new Chapters(2, "Lesson 2 JPA Arch");
//	Chapters chapter9 = new Chapters(1, "Lesson 1 Agile Methods");
//	Chapters chapter10 = new Chapters(2, "Lesson 2 Agile Workflow");
//	Chapters chapter11 = new Chapters(1, "Lesson 1 Unit Testing");
//	Chapters chapter12 = new Chapters(2, "Lesson 2 Regression Testing");
//	
//	Topics topic1 = new Topics(1, "Topic 1 DOM");
//	Topics topic2 = new Topics(2, "Topic 2 Events");
//	Topics topic3 = new Topics(1, "Topic 1 Click");
//	Topics topic4 = new Topics(2, "Topic 2 Callbacks");
//	Topics topic5 = new Topics(1, "Topic 1 State");
//	Topics topic6 = new Topics(2, "Topic 2 Components");
//	Topics topic7 = new Topics(1, "Topic 2 Stateful");
//	Topics topic8 = new Topics(2, "Topic 2 Stateless");
//	
//	HeadingWidget heading1 = new HeadingWidget(1, "Heading Text", "Heading Text", 1);
//	ParagraphWidget paragraph1 = new ParagraphWidget(1, "Paragraph Text", "Paragraph Text");
//	ImageWidget image1 = new ImageWidget(1, "Image URL", "https://picsum.photos/300/200");
//	ListWidget list1 = new ListWidget(1, "List Text", "List text is here", 1);
//	LinkWidget link1 = new LinkWidget(1, "Link URL", "https://picsum.photos/300/200", "image");
//	
//	List<Faculty> users = new ArrayList<Faculty>();
//	List<Courses> courses1 = new ArrayList<Courses>();
//	List<Courses> courses2 = new ArrayList<Courses>();
//	List<Modules> cs5610Modules = new ArrayList<Modules>();
//	List<Modules> cs5200Modules = new ArrayList<Modules>();
//	List<Modules> cs5600Modules = new ArrayList<Modules>();
//	List<Chapters> jqueryChapters = new ArrayList<Chapters>();
//	List<Chapters> reactChapters = new ArrayList<Chapters>();
//	List<Chapters> sqlChapters = new ArrayList<Chapters>();
//	List<Chapters> jpaChapters = new ArrayList<Chapters>();
//	List<Chapters> agileChapters = new ArrayList<Chapters>();
//	List<Chapters> testingChapters = new ArrayList<Chapters>();
//	List<Topics> jqueryLessTopics1 = new ArrayList<Topics>();
//	List<Topics> jqueryLessTopics2 = new ArrayList<Topics>();
//	List<Topics> reactLessTopics1 = new ArrayList<Topics>();
//	List<Topics> reactLessTopics2 = new ArrayList<Topics>();
//	List<Topics> sqlLessTopics = new ArrayList<Topics>();
//	List<Widgets> jquerytopic1 = new ArrayList<Widgets>();
//	List<Widgets> jquerytopic2 = new ArrayList<Widgets>();
//	List<Widgets> sqltopic1 = new ArrayList<Widgets>();
//	List<Widgets> sqltopic2 = new ArrayList<Widgets>();
//	{
//		sqltopic2.add(image1);
//		sqltopic2.add(list1);
//		topic4.setWidgets(sqltopic2);
//		sqltopic1.add(heading1);
//		sqltopic1.add(image1);
//		topic3.setWidgets(sqltopic1);
//		jquerytopic2.add(heading1);
//		jquerytopic2.add(image1);
//		jquerytopic2.add(paragraph1);
//		jquerytopic2.add(list1);
//		jquerytopic2.add(link1);
//		topic2.setWidgets(jquerytopic2);
//		jquerytopic1.add(heading1);
//		jquerytopic1.add(paragraph1);
//		topic1.setWidgets(jquerytopic1);
//		reactLessTopics2.add(topic7);
//		reactLessTopics2.add(topic8);
//		chapter4.setTopics(reactLessTopics2);
//		reactLessTopics1.add(topic5);
//		reactLessTopics1.add(topic6);
//		chapter3.setTopics(reactLessTopics1);
//		jqueryLessTopics2.add(topic3);
//		jqueryLessTopics2.add(topic4);
//		chapter2.setTopics(jqueryLessTopics2);
//		jqueryLessTopics1.add(topic1);
//		jqueryLessTopics1.add(topic2);
//		chapter1.setTopics(jqueryLessTopics1);
//		testingChapters.add(chapter11);
//		testingChapters.add(chapter12);
//		testing.setChapters(testingChapters);
//		agileChapters.add(chapter9);
//		agileChapters.add(chapter10);
//		agile.setChapters(agileChapters);
//		jpaChapters.add(chapter7);
//		jpaChapters.add(chapter8);
//		jpa.setChapters(jpaChapters);
//		sqlChapters.add(chapter5);
//		sqlChapters.add(chapter6);
//		sql.setChapters(sqlChapters);
//		reactChapters.add(chapter3);
//		reactChapters.add(chapter4);
//		react.setChapters(reactChapters);
//		jqueryChapters.add(chapter1);
//		jqueryChapters.add(chapter2);
//		jquery.setChapters(jqueryChapters);
//		cs5610Modules.add(jquery);
//		cs5610Modules.add(react);
//		cs5200Modules.add(jpa);
//		cs5200Modules.add(sql);
//		cs5600Modules.add(agile);
//		cs5600Modules.add(testing);
//		cs5610.setModules(cs5610Modules);
//		cs5200.setModules(cs5200Modules);
//		cs5600.setModules(cs5600Modules);
//		courses1.add(cs5610);
//		courses1.add(cs5200);
//		courses2.add(cs5600);
//		alex.setCourses(courses1);
//		alice.setCourses(courses2);
//		users.add(alex);
//		users.add(alice);
//	}
	
	@GetMapping("/api/users")
	public List<Faculty> findAllUser() {
		return (List<Faculty>) userRepository.findAll();
	}
	
	@GetMapping("/api/users/{userID}")
	public Faculty findUserById(@PathVariable("userID") Integer id) {
		List<Faculty> users = (List<Faculty>) userRepository.findAll();
		for(Faculty user: users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	@PostMapping("/api/register")
	public Faculty createUser(@RequestBody Faculty newUser, HttpSession session){
		List<Faculty> users = (List<Faculty>) userRepository.findAll();
		int flag = 0;
		for(Faculty user: users) {
			if(user.getUsername().equals(newUser.getUsername())) {
				flag = 1;
				return newUser;
			}
		}
		if(flag == 0) {
			userRepository.save(newUser);
			session.setAttribute("currentUser", newUser);
			return newUser;
		}
		return null;
	}
	
	@PostMapping("/api/login")
	public Faculty loginUser(@RequestBody Faculty loginUser, HttpSession session){
		List<Faculty> users = (List<Faculty>) userRepository.findAll();
		for(Faculty user: users) {
			if(user.getUsername().equals(loginUser.getUsername()) && 
					user.getPassword().equals(loginUser.getPassword())) {
				session.setAttribute("currentUser", user);
				
				return user;
			}
		}
		return null;
	}
	
	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@GetMapping("/api/profile")
	public Faculty profile(HttpSession session){
		return (Faculty)session.getAttribute("currentUser");
	}
	
	@PostMapping("/api/loggedInUser")
	public Faculty getLoggedInUser(HttpSession session){
		return (Faculty)session.getAttribute("currentUser");
	}
	
	@PostMapping("/api/updateUser")
	public Faculty updateUser(@RequestBody Faculty updateUser, 
								HttpSession session){
		Faculty currentUser = (Faculty)session.getAttribute("currentUser");
		currentUser.setFirstName(updateUser.getFirstName());
		currentUser.setLastName(updateUser.getLastName());
		return currentUser;
	}
	
}
