package com.board.domain;

public class ClothVO {

	/*
	 * 남자 옷 
	 * CREATE TABLE tbl_man( 
	 * clothcode INT 		NOT NULL 	AUTO_INCREMENT, 
	 * clothname VARCHAR(30) NOT NULL, 
	 * brand 	VARCHAR(30) NOT NULL, 
	 * clotheach VARCHAR(20) NOT NULL,
	 * clothcount INT 		NOT NULL,
	 * PRIMARY KEY(clothcode) );
	 * 
	 * 여자 옷
	 * CREATE TABLE tbl_woman(
		clothcode	 INT		  	NOT NULL AUTO_INCREMENT,
		clothname	 VARCHAR(30) NOT NULL,
		brand			 VARCHAR(30)	NOT NULL,
		clotheach	 VARCHAR(20)	NOT NULL,
		clothcount   INT		NOT NULL,
		PRIMARY KEY(clothcode));
	 */
	
	private int clothcode;
	private String clothname;
	private	String brand;
	private String clotheach;
	private int clothcount;
	
	public int getClothcode() {
		return clothcode;
	}
	public void setClothcode(int clothcode) {
		this.clothcode = clothcode;
	}
	public String getClothname() {
		return clothname;
	}
	public void setClothname(String clothname) {
		this.clothname = clothname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getClotheach() {
		return clotheach;
	}
	public void setClotheach(String clotheach) {
		this.clotheach = clotheach;
	}
	public int getClothcount() {
		return clothcount;
	}
	public void setClothcount(int clothcount) {
		this.clothcount = clothcount;
	}
	
}
