package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.patterns.model.entities.LineaDeLog;

public class MemoryListLogDAO implements IMultipleDao<LineaDeLog,Integer>{

	
	private List<LineaDeLog> almacenDeLogs;  
	
	
	public MemoryListLogDAO(List<LineaDeLog> almacenDeLogs) {
		super();
		this.almacenDeLogs = almacenDeLogs;
	}

	@Override
	public void insert(LineaDeLog elemento) {
		almacenDeLogs.add(elemento);
		// TODO Auto-generated method stub
		
	}

	@Override
	public LineaDeLog update(LineaDeLog elemento) {
		//Hay que indicar qué identificador hay que utilizar
		// Hay que generar Hashcode and equals en LineaDeLog para que funcione update en MemoryListLogDAO
		if (almacenDeLogs.contains(elemento)) {
			int posicion = almacenDeLogs.indexOf(elemento); // Para saber dónde está
			almacenDeLogs.add(posicion,elemento);
			return elemento;
			}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(LineaDeLog elemento) {
		
		almacenDeLogs.remove(elemento);
			// TODO Auto-generated method stub
			
		
	}

	@Override
	public Collection<LineaDeLog> list() {
		// TODO Auto-generated method stub
		return almacenDeLogs;
	}

	@Override
	public List<LineaDeLog> searchByName(String name) {    //Lista de Logs
		// TODO Auto-generated method stub
		List<LineaDeLog> listaDeLogs = new ArrayList<>();
		for(LineaDeLog lineaActual : almacenDeLogs) {    //Utilizamos equals excepto para elementos primitivos
			if(lineaActual.getNombre().equals(name)) {
				listaDeLogs.add(lineaActual);
			}
		}
		return listaDeLogs;
	}

	@Override
	public LineaDeLog searchById(Integer id) {     //SearchbyId
		// TODO Auto-generated method stub
		LineaDeLog log = null;
		for(int i = 0; i < almacenDeLogs.size() || log ==null ; i++) {
			if(almacenDeLogs.get(i).getId().equals(id)) {  // == daría false si compara dos Integer igual a 128, mejor utilizar equals siempre que se pueda. Para ints estamos obligados a utilizar ==
				log = almacenDeLogs.get(i);                    // cuidado con los Booleans, Boolean puede ser true, false o null
			}
		}
		return log;              // mejor return que break; break no está orientado a objetos
	}

	
	// Me valen todos los métodos menos SeachbyName
	

}
