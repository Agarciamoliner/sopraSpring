package com.sopra.java.patterns.model.dao;

//import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.sopra.java.patterns.model.entities.Aula;

public class MemorySetDAO implements IDao<Aula> {
	
	private Set<Aula> miSet;

	@Override
	public void insert(Aula aula) {
		
		if ( !miSet.contains(aula)) {
			miSet.add(aula);
		}
			
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aula update(Aula aula) {
		
		// TODO Auto-generated method stub
		if (miSet.remove(aula)) {
			miSet.add(aula);
			return aula;
			// TODO Auto-generated method stub
			}
		
		return null;
		
	}

	@Override
	public void delete(Aula aula) {
		// TODO Auto-generated method stub
		miSet.remove(aula);
		
	}

	@Override
	public Collection<Aula> list() {
		// TODO Auto-generated method stub
		return miSet;
	}

	@Override
	public Aula searchByName(Aula aula) {
		if(miSet.contains(aula)) {
			for(Aula aulaActual: miSet) {
				if(aulaActual.equals(aula)) {
					return aulaActual;
				}
			}
		}
		return null;
	}

//	@Override
//	public Collection<Aula> search(Aula aula) {
//		Collection<Aula> miColeccion = new ArrayList<>();
//		// TODO Auto-generated method stub
//		if(miSet.contains(aula)) {
//			for(Aula aulaActual: miSet) {
//				if(aulaActual.equals(aula)) {
//					miColeccion.add(aulaActual);
//					return miColeccion;
//				}
//			}
//		}
//		return null;
//	}
	
	

}
