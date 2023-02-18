package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table (name="course")
public class Course extends BaseEntity{
	
	//Atributos del objeto que se corresponden con las columnas de la tabla de la base de datos
	@Column (name= "name")
	private String name;
	
	@Column (name= "credits")
	private int credits;
	
	@ManyToMany (mappedBy="courses")
	private Set<Student> students = new HashSet<>();
	
	//Para hacer birireccional la relación OneTo Many con Instructor
	@ManyToOne
	@JoinColumn (name = "instructor_id")
	private Instructor instructor;

	//Constructor
	public Course(String name, int credits) {
		super();
		this.name = name;
		this.credits = credits;
	}
}