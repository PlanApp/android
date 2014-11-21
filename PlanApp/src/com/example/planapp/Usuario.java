package com.example.planapp;

class Usuario{
	
	private String id,mail, password, fecha_nacimiento, sexo, edo;
	
	public String getEdo(){
		return this.edo;
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getFechaNacimiento(){
		return this.fecha_nacimiento;
	}
	
	public String getSexo(){
		return this.sexo;
	}
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setMail(String mail){
		this.mail=mail;
	}
	
	public void setPassword(String pass){
		this.password=pass;
	}
	
	public void setFechaNacimiento(String fecha){
		this.fecha_nacimiento=fecha;
	} 
	
	public void setSexo(String sexo){
		this.sexo=sexo;
	}
	
	public void setEdo(String edo){
		this.edo=edo;
	}
	
}
