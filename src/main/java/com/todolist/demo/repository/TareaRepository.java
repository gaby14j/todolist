package com.todolist.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.demo.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer>{

	Tarea findByNombre(String nombre);
}
