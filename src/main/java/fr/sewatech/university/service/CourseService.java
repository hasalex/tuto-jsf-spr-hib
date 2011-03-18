package fr.sewatech.university.service;

import java.util.List;

import fr.sewatech.university.model.Course;

public interface CourseService {
	
	List<Course> findAll();
	Course findById(Integer id);
	void save(Course course);

}
