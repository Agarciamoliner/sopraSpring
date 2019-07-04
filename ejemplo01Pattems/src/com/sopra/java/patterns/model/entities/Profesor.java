package com.sopra.java.patterns.model.entities;


public class Profesor extends Persona {    // 

	
	
	public Profesor(String nombre, String dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String identificador() {
		// TODO Auto-generated method stub
		return "Profesor : " + this.getNombre() + " " + this.getDni();
	}

}
