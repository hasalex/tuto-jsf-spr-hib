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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher implements java.io.Serializable {

	private Integer id;
	private String name;
	private String forname;
	private Integer age;
	private Set<Course> courses = new HashSet<Course>(0);

	public Teacher() {
	}

	public Teacher(String name) {
		this.name = name;
	}

	public Teacher(String name, String forname, Integer age, Set<Course> courses) {
		this.name = name;
		this.forname = forname;
		this.age = age;
		this.courses = courses;
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

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "forname", length = 30)
	public String getForname() {
		return this.forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
