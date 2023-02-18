package eus.birt.alvarez_martinez_david_AD05_TaEv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.alvarez_martinez_david_AD05_TaEv1.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
   	private StudentRepository studentRepository;
    
    @RequestMapping({"/students", "/"})
    public String getStudents(Model model){
    	
    	//Pasaremos el listado de todos los estudiantes a nuestro listado en la web lists
        model.addAttribute("students", studentRepository.findAll());

        return "students/list";	
    }
 
}