package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table (name="project")
public class Project extends BaseEntity{
	
	//Atributos del objeto project que se corresponden con las columnas de la tabla de la base de datos
	@Column (name= "name")
	private String name;
		
	@Column (name= "field")
	private String campo;
	
	@Column (name= "budget")
	private Double presupuesto;
	
	@ManyToMany (mappedBy="projects")
	private Set<Instructor> instructores = new HashSet<>();		
	
	//Constructor
	public Project(String name, String campo, Double presupuesto) {
		super();
		this.name = name;
		this.campo = campo;
		this.presupuesto = presupuesto;
	}	
}
