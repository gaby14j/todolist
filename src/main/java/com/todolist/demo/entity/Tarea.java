package com.todolist.demo.entity;

import javax.persistence.Column;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tarea")
public @Data class Tarea implements Serializable {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	
}
