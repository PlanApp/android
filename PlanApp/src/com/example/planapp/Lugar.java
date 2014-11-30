package com.example.planapp;

public class Lugar{
	private String id, nombre, longitud, latitud, monto_promedio, imagen;
	
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
	
	public void setMonto(String monto){
		this.monto_promedio=monto;
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
	
	public String getMonto(){
		return this.monto_promedio;
	}
	
	public String getImagen(){
		return this.imagen;
	}
	
}