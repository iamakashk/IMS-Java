package com.ims.beans.login;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="USERX")
public class Users {

	public Users() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USR_USERID")
	private String USR_USERID;
	
	@Column(name="USR_NAME")
	private String USR_NAME;
	
	@Column(name="USR_LOGGED_IN_FLG")
	private String USR_LOGGED_IN_FLG;
	
	@Column(name="USR_DELETED_FLG")
	private String USR_DELETED_FLG;
	
	@Column(name="USR_TS_CREATED")
	private Timestamp USR_TS_CREATED;
	
	@Column(name="USR_CREATED_BY")
	private String USR_CREATED_BY;
	
	@Column(name="USR_TS_EDITED")
	private Timestamp USR_TS_EDITED;
	
	@Column(name="USR_EDITED_BY")
	private String USR_EDITED_BY;
	
	@Column(name="USR_SHORT_NAME")
	private String USR_SHORT_NAME;
	
	@Column(name="USR_BRANCH_CODE")
	private String USR_BRANCH_CODE;
	
	@Column(name="USR_SISCON_CODE")
	private String USR_SISCON_CODE;
	
	@Column(name="USR_DESGI")
	private String USR_DESGI;
	
	@Column(name="USR_GODOWN_CODE")
	private String USR_GODOWN_CODE;
	
	@Column(name="USR_EMAIL")
	private String USR_EMAIL;
	
	@Column(name="USR_OF_BRANCH")
	private String USR_OF_BRANCH;
	
	@Column(name="USR_OF_SISCON")
	private String USR_OF_SISCON;
	
	@Column(name="USR_MOBILE_NO1")
	private String USR_MOBILE_NO1;
	
	@Column(name="USR_LOCKED_FLG")
	private String USR_LOCKED_FLG;
	
	@Column(name="USR_ACC_CODE")
	private String USR_ACC_CODE;
	
	@Column(name="USR_BLOCKED_FLG")
	private String USR_BLOCKED_FLG;
	
	@Column(name="USR_PASSWORD")
	private String USR_PASSWORD;
	
	@Column(name="USR_PWD_CHANGE_FLG")
	private String USR_PWD_CHANGE_FLG;
	
	@Column(name="USR_PWD_VALID_DAYS")
	private String USR_PWD_VALID_DAYS;
	
	public String getUSR_USERID() {
		return USR_USERID;
	}
	public void setUSR_USERID(String uSR_USERID) {
		USR_USERID = uSR_USERID;
	}
	public String getUSR_NAME() {
		return USR_NAME;
	}
	public void setUSR_NAME(String uSR_NAME) {
		USR_NAME = uSR_NAME;
	}
	public String getUSR_LOGGED_IN_FLG() {
		return USR_LOGGED_IN_FLG;
	}
	public void setUSR_LOGGED_IN_FLG(String uSR_LOGGED_IN_FLG) {
		USR_LOGGED_IN_FLG = uSR_LOGGED_IN_FLG;
	}
	public String getUSR_DELETED_FLG() {
		return USR_DELETED_FLG;
	}
	public void setUSR_DELETED_FLG(String uSR_DELETED_FLG) {
		USR_DELETED_FLG = uSR_DELETED_FLG;
	}
	public Timestamp getUSR_TS_CREATED() {
		return USR_TS_CREATED;
	}
	public void setUSR_TS_CREATED(Timestamp uSR_TS_CREATED) {
		USR_TS_CREATED = uSR_TS_CREATED;
	}
	public String getUSR_CREATED_BY() {
		return USR_CREATED_BY;
	}
	public void setUSR_CREATED_BY(String uSR_CREATED_BY) {
		USR_CREATED_BY = uSR_CREATED_BY;
	}
	public Timestamp getUSR_TS_EDITED() {
		return USR_TS_EDITED;
	}
	public void setUSR_TS_EDITED(Timestamp uSR_TS_EDITED) {
		USR_TS_EDITED = uSR_TS_EDITED;
	}
	public String getUSR_EDITED_BY() {
		return USR_EDITED_BY;
	}
	public void setUSR_EDITED_BY(String uSR_EDITED_BY) {
		USR_EDITED_BY = uSR_EDITED_BY;
	}
	public String getUSR_SHORT_NAME() {
		return USR_SHORT_NAME;
	}
	public void setUSR_SHORT_NAME(String uSR_SHORT_NAME) {
		USR_SHORT_NAME = uSR_SHORT_NAME;
	}
	public String getUSR_BRANCH_CODE() {
		return USR_BRANCH_CODE;
	}
	public void setUSR_BRANCH_CODE(String uSR_BRANCH_CODE) {
		USR_BRANCH_CODE = uSR_BRANCH_CODE;
	}
	public String getUSR_SISCON_CODE() {
		return USR_SISCON_CODE;
	}
	public void setUSR_SISCON_CODE(String uSR_SISCON_CODE) {
		USR_SISCON_CODE = uSR_SISCON_CODE;
	}
	public String getUSR_DESGI() {
		return USR_DESGI;
	}
	public void setUSR_DESGI(String uSR_DESGI) {
		USR_DESGI = uSR_DESGI;
	}
	public String getUSR_GODOWN_CODE() {
		return USR_GODOWN_CODE;
	}
	public void setUSR_GODOWN_CODE(String uSR_GODOWN_CODE) {
		USR_GODOWN_CODE = uSR_GODOWN_CODE;
	}
	public String getUSR_EMAIL() {
		return USR_EMAIL;
	}
	public void setUSR_EMAIL(String uSR_EMAIL) {
		USR_EMAIL = uSR_EMAIL;
	}
	public String getUSR_OF_BRANCH() {
		return USR_OF_BRANCH;
	}
	public void setUSR_OF_BRANCH(String uSR_OF_BRANCH) {
		USR_OF_BRANCH = uSR_OF_BRANCH;
	}
	public String getUSR_OF_SISCON() {
		return USR_OF_SISCON;
	}
	public void setUSR_OF_SISCON(String uSR_OF_SISCON) {
		USR_OF_SISCON = uSR_OF_SISCON;
	}
	public String getUSR_MOBILE_NO1() {
		return USR_MOBILE_NO1;
	}
	public void setUSR_MOBILE_NO1(String uSR_MOBILE_NO1) {
		USR_MOBILE_NO1 = uSR_MOBILE_NO1;
	}
	public String getUSR_LOCKED_FLG() {
		return USR_LOCKED_FLG;
	}
	public void setUSR_LOCKED_FLG(String uSR_LOCKED_FLG) {
		USR_LOCKED_FLG = uSR_LOCKED_FLG;
	}
	public String getUSR_ACC_CODE() {
		return USR_ACC_CODE;
	}
	public void setUSR_ACC_CODE(String uSR_ACC_CODE) {
		USR_ACC_CODE = uSR_ACC_CODE;
	}
	public String getUSR_BLOCKED_FLG() {
		return USR_BLOCKED_FLG;
	}
	public void setUSR_BLOCKED_FLG(String uSR_BLOCKED_FLG) {
		USR_BLOCKED_FLG = uSR_BLOCKED_FLG;
	}
	public String getUSR_PASSWORD() {
		return USR_PASSWORD;
	}
	public void setUSR_PASSWORD(String uSR_PASSWORD) {
		USR_PASSWORD = uSR_PASSWORD;
	}
	public String getUSR_PWD_CHANGE_FLG() {
		return USR_PWD_CHANGE_FLG;
	}
	public void setUSR_PWD_CHANGE_FLG(String uSR_PWD_CHANGE_FLG) {
		USR_PWD_CHANGE_FLG = uSR_PWD_CHANGE_FLG;
	}
	public String getUSR_PWD_VALID_DAYS() {
		return USR_PWD_VALID_DAYS;
	}
	public void setUSR_PWD_VALID_DAYS(String uSR_PWD_VALID_DAYS) {
		USR_PWD_VALID_DAYS = uSR_PWD_VALID_DAYS;
	}

}
