package com.sopra.java.patterns.model.entities;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;   // Esto crea un cuello de botella, por eso lo delegamos en base de datos

public class LineaDeLog {
	
	private static AtomicInteger secuencia;  // Esta secuencia sólo se crea una vez
	private Date fecha;
	private Integer id;
	private Nivel nivel;
	private String mensaje;
	private String nombre;
	
	static {
		secuencia = new AtomicInteger();  // Crear secuencia en bloque static, es un bloque de clase, para hacerlo estático, sólo utilizarlo para inicializar campos
	}
	
	
	// Generar constructor para todos menos id, que ya está para Hashcode and equals
	public LineaDeLog(Date fecha, Nivel nivel, String mensaje, String nombre) {
		this.id = secuencia.incrementAndGet();
		this.fecha = fecha;
		this.nivel = nivel;
		this.mensaje = mensaje;
		this.nombre = nombre;
	}
	
	// Sólo generar Hashcode and equals para los campos que necesitemos utilizar para update en MemoryListLogDAO
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaDeLog other = (LineaDeLog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
