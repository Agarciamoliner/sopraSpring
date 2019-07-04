package com.sopra.java.patterns.model.dao;

//import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.patterns.model.entities.Aula;

public class MemoryListAulaDAO implements IDao<Aula>{
	
	private List<Aula> miListaDeAulas;

	public MemoryListAulaDAO(List<Aula> miListaDeAulas) {
		super();
		this.miListaDeAulas = miListaDeAulas;
	}

	@Override
	public void insert(Aula aula) {
		//	Collection<Aula> aulaEncontradas = search(aula);
		

		if ( !miListaDeAulas.contains(aula)) {
		miListaDeAulas.add(aula);
		// TODO Auto-generated method stub
		}
		
//		FORMA MENOS EFICIENTE :
	//			if ( aulaEncontradas.size() == 0) {
//		miListaDeAulas.add(aula);
//		// TODO Auto-generated method stub
//		}
		
		
	}

	@Override
	public Aula update(Aula aula) {
		
		if (miListaDeAulas.remove(aula)) {
			miListaDeAulas.add(aula);
			return aula;
			// TODO Auto-generated method stub
			}
		
		return null;
		
//		OTRA FORMA:
//		if ( miListaDeAulas.contains(aula)) {
//			miListaDeAulas.remove(aula);
//			miListaDeAulas.add(aula);
//			return aula;
//			// TODO Auto-generated method stub
//			}
//		
//		return null;
		
		
		/* FORMA MENOS EFICIENTE
		 * Collection<Aula> aulaEncontradas = search(aula); if ( aulaEncontradas.size()
		 * == 1) { Aula aulaEncontrada = aulaEncontradas.iterator().next();
		 * miListaDeAulas.remove(aulaEncontrada); miListaDeAulas.add(aula); return aula;
		 * } return null;
		 */
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Aula aula) {
		
		miListaDeAulas.remove(aula);
		
//		FORMA MENOS EFICIENTE
//		Collection<Aula> aulaEncontradas = search(aula);
//		if ( aulaEncontradas.size() == 1) {
//			miListaDeAulas.remove(aulaEncontradas.iterator().next());
//		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Aula> list() {
		// TODO Auto-generated method stub
		return miListaDeAulas;
	}

//	@Override
//	public Collection<Aula> search(Aula aula) {
//
//		Collection<Aula> miColeccion = new ArrayList<>();
//		
//		if(miListaDeAulas.contains(aula)) {;
//		int indexOf = miListaDeAulas.indexOf(aula);
//		Aula aulaEncontrada = miListaDeAulas.get(indexOf);
//		miColeccion.add(aulaEncontrada);
//		}
//		
////		FORMA MENOS EFICIENTE:
//	//		for( Aula aulaActual: miListaDeAulas) {
////			if(aula.getNombre().contentEquals(aulaActual.getNombre())) {
////				coleccion.add(aulaActual);
////			}
////		}
//		// TODO Auto-generated method stub
//		return miColeccion;
//	}

	@Override
	public Aula searchByName(Aula aula) {
		if(miListaDeAulas.contains(aula)) {
		int indexOf = miListaDeAulas.indexOf(aula);
		return miListaDeAulas.get(indexOf);
		}
		return null;
	}
	

	
}
