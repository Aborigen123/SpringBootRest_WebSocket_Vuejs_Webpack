package com.example.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="usr")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4427621263147177265L;
	@Id
    private String id;// ід буде приходити від гугла і в форматі String
	private String name;
	private String userpic;
	private String email;
	private String gender;
	private String locate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime laseVisit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public LocalDateTime getLaseVisit() {
		return laseVisit;
	}
	public void setLaseVisit(LocalDateTime laseVisit) {
		this.laseVisit = laseVisit;
	}
	
	
}
