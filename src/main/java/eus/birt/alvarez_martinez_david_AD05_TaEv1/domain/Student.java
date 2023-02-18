package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="student")
public class Student extends BaseEntity{

	//Atributos del objeto que se corresponden con las columnas de la tabla de la base de datos
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable(name= "student_phone", joinColumns=@JoinColumn(name="student_id"))
	@Column(name="student_phone")
	private List<String> phones = new ArrayList<>();
	
	@Column (name="birthdate")
	private LocalDate birthdate;
	
	@OneToOne(mappedBy="student")
	private Tuition tuition;
	
	@ManyToOne
	@JoinColumn (name = "university_id")
	private University university;
	
	@ManyToMany 
	@JoinTable(name="student_course", joinColumns=@JoinColumn(name="student_id"), 
			inverseJoinColumns=@JoinColumn(name="course_id"))
	private Set<Course> courses = new HashSet<>();

	//Constructor
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}
