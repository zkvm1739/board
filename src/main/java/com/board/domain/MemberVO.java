package com.board.domain;

import java.util.Date;

public class MemberVO {
	/*
	   create table member_tbl( 
		  userId 	varchar(30) 	not null, 
		  userPass 	varchar(100) 	not null, 
		  userName  varchar(30) 	not null, 
		  regDate   date 			default NOW(), 
		  primary	key(userId),
	   	unique(userName) 
	      );

	 */
	private String userId;
	private String userPass;
	private String userName;
	private Date regDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
