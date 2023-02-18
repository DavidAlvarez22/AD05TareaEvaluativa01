package eus.birt.alvarez_martinez_david_AD05_TaEv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.alvarez_martinez_david_AD05_TaEv1.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}