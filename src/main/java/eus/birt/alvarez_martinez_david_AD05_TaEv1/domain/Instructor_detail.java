package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones lombok
@Setter
@NoArgsConstructor
@Getter

@Entity
@Table(name="instructor_detail")
public class Instructor_detail extends BaseEntity{
	
	//Atributos del objeto que se corresponden con las columnas de la tabla de la base de datos

	@Column (name="blog")
	private String blog;

	@Column (name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructor_detail", cascade= CascadeType.ALL) // para OneToOne bidireccional. Campo con el JoinColumn de la entidad origen
	private Instructor instructor;      // no se especifica JoinColumn en el lado inverso de la asociación*/
	
	//Constructor
	public Instructor_detail(String blog, String hobby) {
		super();
		this.blog = blog;
		this.hobby = hobby;
	}
	
	
}


