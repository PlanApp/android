package com.example.glock;

public class Notas{
	private String id, titulo, contenido;
	
	public String getId(){
		return id;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getContenido(){
		return contenido;
	}
	
	public void setId(String x){
		this.id=x;
	}
	
	public void setTitulo(String x){
		this.titulo=x;
	}
	
	public void setContenido(String x){
		this.contenido=x;
	}
	
	public void setNota(String titulo, String contenido){
		this.titulo=titulo;
		this.contenido=contenido;
	}
}