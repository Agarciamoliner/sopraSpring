package com.sopra.java.patterns.business;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sopra.java.patterns.model.entities.Alumno;
import com.sopra.java.patterns.model.entities.Aula;
import com.sopra.java.patterns.model.entities.Profesor;
import com.sopra.java.patterns.model.entities.Puesto;

public class GestionCursos {
	
	private GestionAulas gestorDeAulas;
//	private GestorLogs gestorDeLogs;
	private GestionPersonas gestorDePersonas;
	
	public GestionCursos() {
		gestorDeAulas = new GestionAulas();
//		gestorDeLogs = new GestorLogs();
		gestorDePersonas = new GestionPersonas();
	}
	
	public void crearCurso(
			String nombre, Boolean proyector, 
			Boolean pizarra, Map<String,String> alumnos,
			String nombreProfesor, String dniProfesor) throws Exception {
		
		gestorDeAulas.crearAula(nombre, proyector, pizarra, alumnos.size());
		gestorDePersonas.crearProfesor(dniProfesor, nombreProfesor);
		
		Collection<Alumno> alumnosGuardados = almacenarAlumnosDesdeElGestorDeAlumnos(alumnos); // Collection Porque nos da igual el orden
		List<Aula> aulas = gestorDeAulas.dameAulas(Arrays.asList(nombre));
		if(aulas.size()==1) {
			Aula aula = aulas.get(0);
		
			// Todas las Colecciones son iterables
			// Iterador es un puntero de base de datos
			Iterator<Alumno> recorreAlumnos = alumnosGuardados.iterator();
			Iterator<Puesto> recorrePuestos = aula.getPuestosDeAlumnos().iterator();
			while(recorreAlumnos.hasNext() && recorrePuestos.hasNext()){
				Puesto puesto = recorrePuestos.next();
				puesto.setPersona(recorreAlumnos.next());
			}
			Set<Profesor> listaProfesores = gestorDePersonas.listarProfesores();
		    Profesor ProfesorQueBusco = new Profesor(null, dniProfesor);
			for(Profesor profe: listaProfesores) {
				if(profe.equals(ProfesorQueBusco)) {
					aula.getPuestoDeProfesor().setPersona(profe);
				}  // Garantizo que esté siempre almacenado en DAO
			}
			
		}else {
		  throw new Exception("No existe el aula");	
		}
	}

	private Collection<Alumno> almacenarAlumnosDesdeElGestorDeAlumnos(Map<String, String> alumnos) {
//		// Esta parte es demasiado complejo, mas posibilidades de fallo
		
//		Set<String> dnis = alumnos.keySet();  // set de claves, recorrer claves y luego pedir valor
//		Set<Alumno> alumnosEncontrados = new HashSet<Alumno>();
//		Set<Alumno> alumnosClavesDeBusqueda = new HashSet<Alumno>();
//		for(String dni:dnis) {
//			gestorDePersonas.crearAlumno(dni, alumnos.get(dni));   // Dar de alta nuevos alumnos en curso  // Aquí usamos orientación a objeto
//			alumnosClavesDeBusqueda.add(new Alumno(null, dni));
//		// Hacer trazas mentales en caso de que me pidan hacer el mismo código en otro proyecto
//		}
//		
//		 Set<Alumno> alumnosGuardados = gestorDePersonas.listarAlumnos();
//		 alumnosEncontrados.
//		 alumnosGuardados.stream().flatMap(mapper) //Estructuras funcionales, según vayas accediendo // Novedad en Java 8 
//
//		for(Alumno alumno: alumnosGuardados) {
//			Alumno alumnoABuscar = new Alumno(null, dni)
//		}
		 
		 // Mapa
		 // Set de alumnos en base de datos (bbdd) --> AlumnosGuardados alumnos
		for(String dni: alumnos.keySet()) {
			gestorDePersonas.crearAlumno(dni, alumnos.get(dni));
		}
		Collection<Alumno> misAlumnos = new HashSet<Alumno>();
		 Set<Alumno> listaAlumnos = gestorDePersonas.listarAlumnos();
		 for(Alumno alumno: listaAlumnos) {
			 if(alumnos.containsKey(alumno.getDni())) {
				 misAlumnos.add(alumno);
			 }
		 }
		 return misAlumnos;
	  
	   
	}

}
