package com.sopra.java.patterns;

import java.util.Arrays;
import java.util.List;

import com.sopra.java.patterns.business.GestionAulas;
import com.sopra.java.patterns.model.entities.Aula;

public class Lanzador {
	public static void main(String[] args) {
		
		GestionAulas gestionAulas = new GestionAulas();
		gestionAulas.crearAula("Kepler", true, true, 16);
		// Collections: Para manipular colecciones (fusionarlas, copias)
		// Arrays: Quiero convertir una lista en un array de elementos
		List<Aula> aulas = gestionAulas.dameAulas(Arrays.asList("Kepler","Galileo"));
		System.out.println(aulas);
		
}
	
}
