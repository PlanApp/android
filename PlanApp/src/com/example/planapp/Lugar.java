package com.example.planapp;

class Lugar{
	private String id, nombre, ubicacion, monto_promedio, imagen;
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setUbicacion(String ubicacion){
		this.ubicacion=ubicacion;
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
	
	public String getUbicacion(){
		return this.ubicacion;
	}
	
	public String getMonto(){
		return this.monto_promedio;
	}
	
	public String getImagen(){
		return this.imagen;
	}
	
}