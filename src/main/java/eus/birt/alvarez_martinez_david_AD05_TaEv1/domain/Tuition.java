package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name="tuition")
public class Tuition extends BaseEntity{
	
	//Atributos del objeto que se corresponden con las columnas de la tabla de la base de datos
	@Column (name="fee")
	private Double fee;
	
	@OneToOne
	@JoinColumn(name="student_id", referencedColumnName="id")
	private Student student;
	
	//Constructor
	public Tuition(Double fee) {
		super();
		this.fee = fee;
	}

	
}
