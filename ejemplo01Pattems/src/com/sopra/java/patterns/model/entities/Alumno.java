package com.sopra.java.patterns.model.entities;

public class Alumno extends Persona {

	
	
	public Alumno(String nombre, String dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}

	@Override   // Override: 
	public String identificador() {
		// TODO Auto-generated method stub
		return "Alumno: " + this.getDni() + " " + this.getNombre();
	}

}
