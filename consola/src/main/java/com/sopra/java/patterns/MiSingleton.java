package com.sopra.java.patterns;


// Singleton es un �nico objeto de tipo Singleton en toda la m�quina virtual de Java, no puede haber 2 como �l. En cada Servidor hay un Singleton, es �nico dentro de una m�quina virtual.
// Spring eval�a s�lo una m�quina virtual
public class MiSingleton {
	private static MiSingleton instance;
	private MiSingleton() {
		
	}
	public static MiSingleton getInstance() {
		if (instance == null) {
			instance = new MiSingleton();
		}					// Es mi memoria la que utilizo
		return instance;   // Devuelve una instancia, un objeto de clase Singleton
							// En Java debemos pensar en el objetivo de la aplicaci�n. Sesi�n de aplicaci�n, JSessionId. Cada vez que solicitas un acceso, se env�a la misma cookie (JsessionId).
							// Compartir tu sesi�n con otros servidores, en caso de que el usuario no pueda acceder desde su ordenador personal.
	}
	
	

}
