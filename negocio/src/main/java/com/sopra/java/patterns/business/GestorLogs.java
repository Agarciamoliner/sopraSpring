package com.sopra.java.patterns.business;

import java.util.ArrayList;
import java.util.List;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.entities.LineaDeLog;


// Por nivel, decir el nivel. 
public class GestorLogs {
	private IMultipleDao<LineaDeLog, Integer> logDao;
	
	public GestorLogs() {
		logDao = Factory.getDaoDeLog();
	}

	public List<LineaDeLog> getLog(){   // Me importa el orden, por lo que hago una lista
		return new ArrayList<LineaDeLog>(logDao.list());
	}
}
