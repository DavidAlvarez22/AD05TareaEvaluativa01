package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

//Superclase

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

////Anotaciones lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
	
	//Atributos 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	 
}