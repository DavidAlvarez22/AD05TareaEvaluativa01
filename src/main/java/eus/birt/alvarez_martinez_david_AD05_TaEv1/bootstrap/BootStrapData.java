package eus.birt.alvarez_martinez_david_AD05_TaEv1.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Address;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Course;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Instructor;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Instructor_detail;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Project;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Student;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Tuition;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.University;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.CourseRepository;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.InstructorRepository;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.Instructor_detailRepository;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.ProjectRepository;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.StudentRepository;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.TuitionRepository;
import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.UniversityRepository;
import jakarta.transaction.Transactional;

@Component
public class BootStrapData implements CommandLineRunner{
	
	//Obtenemos nuestros repositorios para poder hacer acciones JPA
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TuitionRepository tuitionRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private Instructor_detailRepository instructor_detailRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Transactional //Metodo con única transaccion, evita: object references an unsaved transient instance
	@Override
	public void run(String... arg0) throws Exception {
		
		//Creamos los distintos objetos necesarios para las tareas de aprendizaje
		Student student1 = new Student("Jill", "Admin","as@s");
		Address address1 = new Address("Araba Kalea", "4","Gasteiz", "01100");
		Tuition tuition1 = new Tuition(4000.0);
		University university1 = new University("EHU");
		Course course1 = new Course("Acceso a datos",4);
				
		student1.setAddress(address1);
		student1.getPhones().add("687452145");
		student1.getPhones().add("687452146");
		student1.setBirthdate(LocalDate.parse("1989-04-04"));
		university1.setAddress(address1);
		
		student1.setTuition(tuition1);
		tuition1.setStudent(student1);
		
		student1.setUniversity(university1);
		university1.getStudents().add(student1);
		
		course1.getStudents().add(student1);
		student1.getCourses().add(course1);
		
		//Ejercicio 1
		Instructor instructor = new Instructor("David", "Alvarez","dam@s");
		Address address2 = new Address("Bizkaia", "7","Barakaldo", "48901");
		instructor.setAddress(address2);
		
		course1.setInstructor(instructor);//Acciones bidireccionales
		instructor.getCursos().add(course1);
		
		//Ejercicio2
		Instructor instructor2 = new Instructor("Yo", "otravez","daw@s");
		Address address3 = new Address("Bizkaia", "8","Barakaldo", "48901");
		instructor2.setAddress(address3);
		Instructor_detail idetail = new Instructor_detail("blog","de`porte");
		
		instructor2.setInstructor_detail(idetail);//Acciones bidireccionales
		idetail.setInstructor(instructor2);
		
		//Ejercicio3
		Project proyecto = new Project ("Proyecto_prueba","informatica",4000.00);
		
		proyecto.getInstructores().add(instructor2);//Acciones bidireccionales
		instructor2.getProjects().add(proyecto);
				
		//Guardamos nuestros distintos objetos
		courseRepository.save(course1);	
		universityRepository.save(university1);
		studentRepository.save(student1);
		tuitionRepository.save(tuition1);
		instructorRepository.save(instructor);
		instructorRepository.save(instructor2);
		instructor_detailRepository.save(idetail);
		projectRepository.save(proyecto);
		
		
		System.out.println("Started in Bootstrap");
        System.out.println("Number of Students: " + studentRepository.count());
			
	}
	
}
