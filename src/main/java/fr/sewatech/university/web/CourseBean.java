package fr.sewatech.university.web;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.richfaces.component.html.HtmlScrollableDataTable;
import org.richfaces.model.ScrollableTableDataModel.SimpleRowKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.sewatech.university.model.Course;
import fr.sewatech.university.service.CourseService;

@Component("courseBean")
@Scope("session")
public class CourseBean implements Serializable {

	@Autowired
	private transient CourseService courseService;
	private transient HtmlScrollableDataTable courseTable;
	
	private List<Course> courseList;
	private Course currentCourse;

	@PostConstruct
	public void init() {
		courseList = courseService.findAll();
	}
	
	public String viewNew() {
		currentCourse = new Course();
		return "detail";
	}
	public String viewDetail() {
		List<Course> valueList = (List<Course>) courseTable.getValue();
		Iterator<SimpleRowKey> keys = courseTable.getSelection().getKeys();
		
		if (keys.hasNext()) {
			currentCourse = valueList.get(keys.next().intValue());
			return "detail";
		} else {
			return null;
		}
	}
	
	public String update() {
		courseService.save(currentCourse);
		init();
		return null;
	}
	
	public HtmlScrollableDataTable getCourseTable() {
		return courseTable;
	}

	public void setCourseTable(HtmlScrollableDataTable courseTable) {
		this.courseTable = courseTable;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Course getCurrentCourse() {
		return currentCourse;
	}

	public void setCurrentCourse(Course currentCourse) {
		this.currentCourse = currentCourse;
	}
	
}
