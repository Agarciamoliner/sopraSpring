package com.sopra.java.patterns.business;

import java.util.HashSet;
import java.util.Set;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.entities.Alumno;
import com.sopra.java.patterns.model.entities.Persona;
import com.sopra.java.patterns.model.entities.Profesor;

public class GestionPersonas {
	private IMultipleDao<Persona,String> personaDao;
	
	public GestionPersonas() {
		this.personaDao = Factory.getPersonaDao();
	}

	
	public void crearAlumno(String dni, String nombre) {
		personaDao.insert(new Alumno(nombre, dni));
	}
	
	public void crearProfesor(String nombre, String dni) {
		personaDao.insert(new Profesor(nombre, dni));
	}
	
	public Set<Persona> listarPersonas(){   // Me da igual el orden pero no puede haber repeticiones
		// utilizar la forma más simple y clara
		
		return new HashSet<Persona>(personaDao.list());
	}
	
	// CUIDADO CON LOS WARNINGS			
	
	public Set<Profesor> listarProfesores(){   // Me da igual el orden pero no puede haber repeticiones
		
		// utilizar la forma más simple y clara
		
		Set<Profesor> profesores = new HashSet<>();
		for(Persona persona: personaDao.list()) {
			if(persona instanceof Profesor) {
			Profesor profesor = (Profesor) persona;    // PERSONA PUEDE SER PROFESOR        // hay que poner cast (Profesor) porque no estamos seguros de que una persona sea profesor       
			                                           // Hay que hablar en términos de : es (HERENCIA) y tiene (ATRIBUTOS Y CAMPOS)
//			Persona p = profesor; // PROFESOR ES PERSONA  
			profesores.add(profesor);
			}
		}
		return profesores;
	}
	
	public Set<Alumno> listarAlumnos(){   // Me da igual el orden pero no puede haber repeticiones
		
		// utilizar la forma más simple y clara
		
		Set<Alumno> alumnos = new HashSet<>();
		for(Persona persona: personaDao.list()) {
			if(persona instanceof Alumno) {
				Alumno alumno = (Alumno) persona;    // PERSONA PUEDE SER ALUMNO        // hay que poner cast (Profesor) porque no estamos seguros de que una persona sea profesor       
			                                           // Hay que hablar en términos de : es (HERENCIA) y tiene (ATRIBUTOS Y CAMPOS)
//			Persona p = alumno; // ALUMNO ES PERSONA  
											// No poner booleano para comprobar si uno es Policía o no, por ejemplo
				
				alumnos.add(alumno);	
			}											   
			
		}
		return alumnos;
	}
	
	// LENGUAJE DESCRIPTIVO, NO declarar campos ni clases como val, type, p, n, Declarar variables como por ejemplo alumno, profesor, alumnosdemierda... Para los métodos y clases poner nombres largos y descriptivos
	// NO DECLARAR COMENTARIOS EN UN PROYECTO
}
