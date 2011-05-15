package fr.sewatech.university.model;

// Generated 14 févr. 2008 09:26:50 by Hibernate Tools 3.2.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements java.io.Serializable {

	private Integer id;
	private Teacher teacher;
	private String code;
	private String name;
	private Integer length;
	private Set<Student> students = new HashSet<Student>(0);

	public Course() {
	}

	public Course(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Course(Teacher teacher, String code, String name, Integer length,
			Set<Student> students) {
		this.teacher = teacher;
		this.code = code;
		this.name = name;
		this.length = length;
		this.students = students;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "code", nullable = false, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "length")
	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "course_student", catalog = "university", joinColumns = { @JoinColumn(name = "course_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "student_id", nullable = false, updatable = false) })
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return this.code + " " + this.name;
	}

}
