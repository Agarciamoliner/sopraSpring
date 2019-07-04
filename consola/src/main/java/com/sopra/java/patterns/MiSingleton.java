package com.sopra.java.patterns;


// Singleton es un único objeto de tipo Singleton en toda la máquina virtual de Java, no puede haber 2 como él. En cada Servidor hay un Singleton, es único dentro de una máquina virtual.
// Spring evalúa sólo una máquina virtual
public class MiSingleton {
	private static MiSingleton instance;
	private MiSingleton() {
		
	}
	public static MiSingleton getInstance() {
		if (instance == null) {
			instance = new MiSingleton();
		}					// Es mi memoria la que utilizo
		return instance;   // Devuelve una instancia, un objeto de clase Singleton
							// En Java debemos pensar en el objetivo de la aplicación. Sesión de aplicación, JSessionId. Cada vez que solicitas un acceso, se envía la misma cookie (JsessionId).
							// Compartir tu sesión con otros servidores, en caso de que el usuario no pueda acceder desde su ordenador personal.
	}
	
	

}
