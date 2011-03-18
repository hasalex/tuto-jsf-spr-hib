package fr.sewatech.university.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.sewatech.university.model.Course;

public class CourseServiceTest {

	private static ClassPathXmlApplicationContext context;
	private static CourseService courseService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		courseService = (CourseService) context.getBean("courseService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<Course> allCourses = courseService.findAll();
		assertNotNull(allCourses);
		assertTrue(allCourses.size() > 0);
		System.out.println(allCourses);
	}

	@Test
	public void testFindById() {
		Course course = courseService.findById(1);
		assertNotNull(course);
		assertEquals(Integer.valueOf(1), course.getId());
		System.out.println(course);
	}

	@Test
	public void testSave() {
		Course course = new Course("NN", "Nouveau Cours");
		courseService.save(course);
		assertNotNull(course.getId());
	}

}
