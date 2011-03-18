package fr.sewatech.university.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sewatech.university.model.Course;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Course> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Course").list();
	}

	@Override
	public Course findById(Integer id) {
		return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
	}

	@Override
	public void save(Course course) {
		sessionFactory.getCurrentSession().saveOrUpdate(course);
	}

}
