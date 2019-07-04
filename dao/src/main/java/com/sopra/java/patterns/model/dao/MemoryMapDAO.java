package com.sopra.java.patterns.model.dao;

//import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Aula;

public class MemoryMapDAO implements IDao<Aula>  {
	
      private Map<String ,Aula> miMapa;

	public MemoryMapDAO(Map<String, Aula> miMapa) {
		super();
		this.miMapa = miMapa;
	}

	@Override
	public void insert(Aula aula) {
		// TODO Auto-generated method stub
		miMapa.putIfAbsent(aula.getNombre(), aula);
	}

	@Override
	public Aula update(Aula aula) {
		miMapa.replace(aula.getNombre(), aula);	
		return aula;
	}

	@Override
	public void delete(Aula aula) {
		miMapa.remove(aula.getNombre());	
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Aula> list() {
		// TODO Auto-generated method stub
		return miMapa.values();
	}

//	@Override
//	public Collection<Aula> search(Aula aula) {
//		// TODO Auto-generated method stub
//		Collection<Aula> miColeccion = new ArrayList<>(); // Un ArrayList es una lista, una coleccion, un RandomAccess...
//		if(miMapa.containsKey(aula.getNombre())) {
//			miColeccion.add(miMapa.get(aula.getNombre()));
//		}
//		
//
//		return miColeccion;
//	}

	@Override
	public Aula searchByName(Aula aula) {
		
		if(miMapa.containsKey(aula.getNombre())) {
			return miMapa.get(aula.getNombre());
		}
		
			
		// TODO Auto-generated method stub
		return null;
	}
	}
