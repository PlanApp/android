package com.example.planapp;

class Panorama{
	private String id_1;
	private String lugar_1;
	private String id_2;
	private String lugar_2;
	private String id_3;
	private String lugar_3;
	private String img;
	
	
	
	public void setID1(String id){
		this.id_1=id;
	}
	
	public void setID2(String id){
		this.id_2=id;
	}
	
	public void setID3(String id){
		this.id_3=id;
	}
	
	
	public void setLugar1(String lugar){
		this.lugar_1=lugar;
	}
	
	public void setLugar2(String lugar){
		this.lugar_2=lugar;
	}
	
	public void setLugar3(String lugar){
		this.lugar_3=lugar;
	}
	
	public void setIMG(String img){
		this.img=img;
	}
	
	public String getID1(){
		return this.id_1;
	}
	
	public String getID2(){
		return this.id_2;
	}
	
	public String getID3(){
		return this.id_3;
	}
	
	public String getLugar1(){
		return this.lugar_1;
	}
	
	public String getLugar2(){
		return this.lugar_2;
	}
	
	public String getLugar3(){
		return this.lugar_3;
	}
	
	public String getIMG(){
		return this.img;
	}
	
}