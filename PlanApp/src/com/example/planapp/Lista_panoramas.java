package com.example.planapp;

public class Lista_panoramas {
	
	private int idImagen; 
	private String titulo; 
	private String descripcion; 

	public Lista_panoramas (int idImagen, String textoEncima, String textoDebajo) { 
	    this.idImagen = idImagen; 
	    this.titulo = textoEncima; 
	    this.descripcion = textoDebajo; 
	}

	public String get_textoEncima() { 
	    return titulo; 
	}

	public String get_textoDebajo() { 
	    return descripcion; 
	}

	public int get_idImagen() {
	    return idImagen; 
	} 
}
