package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Persona;

public class MemoryMapPersonaDao implements IMultipleDao<Persona, String> {  // Map, porque me servirá para Id

	private Map<String,Persona> almacenDePersonas;
	
	
	
	public MemoryMapPersonaDao(Map<String, Persona> almacenDePersonas) {
		super();
		this.almacenDePersonas = almacenDePersonas;
	}

	@Override
	public void insert(Persona elemento) {
		almacenDePersonas.putIfAbsent(elemento.getDni(), elemento);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona update(Persona elemento) {
		
		// TODO Auto-generated method stub
		if(almacenDePersonas.replace(elemento.getDni(), elemento) != null) { // Si ha sustituido algo
			return elemento;
		}
		return null;
	}

	@Override
	public void delete(Persona elemento) {
		// TODO Auto-generated method stub
		almacenDePersonas.remove(elemento.getDni());
		
	}

	@Override
	public Collection<Persona> list() {
		// TODO Auto-generated method stub
		return almacenDePersonas.values();
	}

	@Override
	public List<Persona> searchByName(String name) {
		// TODO Auto-generated method stub
		List<Persona> lista = new ArrayList<>();
		for(Persona persona: almacenDePersonas.values()) {
			if(persona.getNombre().equals(name)) {
				lista.add(persona);
			}
		}
		return lista;
	}

	@Override
	public Persona searchById(String id) {
		// TODO Auto-generated method stub
		return almacenDePersonas.get(id);
	}  


}
