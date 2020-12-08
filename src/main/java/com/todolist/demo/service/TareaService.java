package com.todolist.demo.service;

import java.util.List;

import com.todolist.demo.entity.Tarea;

public interface TareaService {
	List<Tarea> obtenerTareas();
	
	Tarea agregarTarea(Tarea tarea);
	
	Tarea resolverTarea(Tarea tarea);
}
