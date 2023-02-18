package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="university")
public class University extends BaseEntity{
	
	//Atributos del objeto que se corresponden con las columnas de la tabla de la base de datos
	@Column (name= "name")
	private String name;
		
	@Embedded
	private Address address;
	
	@OneToMany
	@JoinColumn (name = "university_id")
	List <Student> students = new ArrayList<>();
	
	//Constructor
	public University(String name) {
		super();
		this.name = name;
	}
	
}