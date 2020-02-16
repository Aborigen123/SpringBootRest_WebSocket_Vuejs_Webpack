package com.example.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "message")
@ToString(of= {"id", "text"})//lombok
@EqualsAndHashCode(of = {"id"})//lombok
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1295845509079963559L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Id.class)//приховує поля
	//ми створюємо інтерфейс маркер які можуть наслідуватися один від одного н-д FullMessage extends IdName
	//якщо ми будемо віддавати меседж через апі з вказаням  IdName нам буде вертати поля які позначеня як IdName якщо ми зверенмся до нам верне всі IdName + FullMessage (тому що extends)
	//для цього нам в RestController потрібно поставити таку ж анотатацію над методом 
	private Long id;
	
	@Column(updatable = false)//поле не обновляєме
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")//запис даних в бд буде стандартним але вертати на фронтенд буде за вказаним форматом
	@JsonView(Views.FullMessage.class)
	private LocalDateTime creationDate;
	
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}


	

}
