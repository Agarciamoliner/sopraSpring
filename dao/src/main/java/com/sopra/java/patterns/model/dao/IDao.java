
package com.sopra.java.patterns.model.dao;

public interface IDao<T> extends IGenericDao<T> {
	T searchByName(T elemento);
//	Collection<Aula> search(Aula aula);
	// Aula insertAula(String name);  // ESTO SERÍA INCORRECTO
	
}
