package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name="instructor")
public class Instructor extends BaseEntity{
	
	//Atributos del objeto inspector que se corresponden con las columnas de la tabla de la base de datos
	@Column(name="first_name")
	private String firstName;
	
	@Column (name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	//Atributo embebido que se corresponde con la tabla address. Recoge los datos del objeto Address que se ha utilizado también con el objeto Student
	@Embedded
	private Address address;
	
	// Atributo correspondiente al ejercicio 1 de la tarea Evaluativa.
	@OneToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})// No ponemos CascadeType.ALL, para que no desaparezca el curso, pues el curso puede existir asignándo un nuevo instructor.
	@JoinColumn (name = "instructor_id")// La columna que unirá ambas tablas será instructor_iD de la tabla course.
	List <Course> cursos = new ArrayList<>();// Al ser una relación OneToMany se necesita un List del objeto cursos
	
	// Atributo correspondiente al ejercicio 2 de la tarea Evaluativa.
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id", referencedColumnName="id")// La columna que unirá ambas tablas será instructor_detail_id de la tabla instructor y hace referencia a la tabla id de la tabla instructor detail
	private Instructor_detail instructor_detail;
	
	// Atributo correspondiente al ejercicio 3 de la tarea Evaluativa.
	@ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})// No ponemos CascadeType.ALL, para que no desaparezca el proyecto, pues el proyecto puede existir acon distintos instructores.
	@JoinTable(name="instructor_project", joinColumns=@JoinColumn(name="instructor_id"), //Señlamos la tabla que hace de unión que es instructor_project y ponemos qué columas son de unión y la columna inversa
			inverseJoinColumns=@JoinColumn(name="project_id"))
	private Set<Project> projects = new HashSet<>();
	
	//Constructor		
	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	@Override
	public String toString() {
		return "Instructor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

}