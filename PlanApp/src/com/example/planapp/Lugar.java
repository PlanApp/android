package com.example.planapp;

class Lugar{
	private String id;
	private String nombre;
	private String imagen;
	private String longitud;
	private String latitud;
	private String descrip;
	private String tipo;
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setLatitud(String l){
		this.latitud=l;
	}
	
	public void setLongitud(String l){
		this.longitud=l;
	}
	
	public void setDescrip(String d){
		this.descrip=d;
	}
	
	public void setTipo(String t){
		this.tipo=t;
	}
	
	public void setImagen(String img){
		this.imagen=img;
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getLatitud(){
		return this.latitud;
	}
	
	public String getLongitud(){
		return this.longitud;
	}
	
	public String getDescrip(){
		return this.descrip;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public String getImagen(){
		return this.imagen;
	}
	
}