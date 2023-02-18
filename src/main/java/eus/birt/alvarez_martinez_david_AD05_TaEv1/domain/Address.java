package eus.birt.alvarez_martinez_david_AD05_TaEv1.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Embeddable
public class Address {
	
	//Atributos del objeto que se corresponden con las columnas de la tabla de la base de datos
	@Column (name ="address_line_1")
	private String addressLine1;
	
	@Column (name ="address_line_2")
	private String addressLine2;
	
	@Column (name ="city")
	private String city;
	
	@Column (name ="zip_code")
	private String zipCode;
	
}
