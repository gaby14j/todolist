package com.todolist.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.demo.entity.Tarea;
import com.todolist.demo.entity.Usuario;
import com.todolist.demo.repository.TareaRepository;
import com.todolist.demo.repository.UsuarioRepository;
import com.todolist.demo.service.TareaService;
@Service
public class TareaServiceImpl implements TareaService{

	@Autowired
	private TareaRepository tareaRepository;
	
	@Override
	public List<Tarea> obtenerTareas() {
		List<Tarea> listaTareas=new ArrayList<Tarea>(); 
		listaTareas=tareaRepository.findAll();
		return listaTareas;
	}

	public boolean obtenerTarea(Tarea tarea) {
		Tarea tareaBuscada= tareaRepository.findByNombre(tarea.getNombre());
		if (tareaBuscada==null) {
			return false;
		}
		return true;
	}
	
	@Override
	public Tarea agregarTarea(Tarea tarea) {
		Tarea tareaCreada=new Tarea();
		if (!this.obtenerTarea(tarea)) {
			tareaCreada= tareaRepository.save(tarea);
		}
		return tareaCreada;
	}

	@Override
	public Tarea resolverTarea(Tarea tarea) {
		Tarea tareaResuelta=new Tarea();
		if (this.obtenerTarea(tarea)) {
			tarea.setEstado(true);
			tareaResuelta= tareaRepository.save(tarea);
		}else throw new NullPointerException("La tarea no existe");
		return tareaResuelta;

	}

}
