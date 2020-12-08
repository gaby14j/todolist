package com.todolist.demo.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.todolist.demo.entity.Tarea;
import com.todolist.demo.service.TareaService;



@RestController
@RequestMapping("/api/tarea")
public class TareaController {
	
	private static final Logger logger= LoggerFactory.getLogger(TareaController.class);
	
	@Autowired 
	private TareaService tareaService;
	
	@GetMapping("/listar-tareas")
	public ResponseEntity<List<Tarea>> obtenerTareas() {  
		ResponseEntity<List<Tarea>> responseTarea=null;
		List<Tarea> listaTareas=new ArrayList<Tarea>(); 
		try {
			listaTareas=tareaService.obtenerTareas();
		
		 
		 responseTarea= new ResponseEntity<List<Tarea>>(listaTareas,HttpStatus.OK);
		 
		 
	   }catch(Exception e) {
			
		   logger.error("Error al Listar tareas" + e.getMessage());
		   responseTarea= new ResponseEntity<>(listaTareas,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   return responseTarea;
	}
	
	@PostMapping("/agregar-tarea")
	public ResponseEntity<Tarea> agregarTarea(@RequestBody Tarea tarea) {  
		ResponseEntity<Tarea> responseTarea=null;
		Tarea tareaCreada=new Tarea();
	   try {
		   tareaCreada=tareaService.agregarTarea(tarea);
		
		   if (tareaCreada!=null) {
			   responseTarea= new ResponseEntity<>(tareaCreada,HttpStatus.CREATED);
		   }
		 
	   }catch(Exception e) {
			
		   logger.error("Error al Agregar tarea" + e.getMessage());
		   responseTarea= new ResponseEntity<>(tareaCreada,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   return responseTarea;
	}
	
	@PutMapping("/marcar-tarea-resuelta")
	public ResponseEntity<Tarea> modificarTarea(@RequestBody Tarea tarea) {  
		ResponseEntity<Tarea> responseTarea=null;
		Tarea tareaResuelta=new Tarea();
	   try {
		   tareaResuelta=tareaService.resolverTarea(tarea);
		   if (tareaResuelta!=null) {
			   responseTarea= new ResponseEntity<>(tareaResuelta,HttpStatus.CREATED);
		   }
		 
	   }catch(Exception e) {
			
		   logger.error("Error al Modificar tareas" + e.getMessage());
		   responseTarea= new ResponseEntity<>(tareaResuelta,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   return responseTarea;
	}
	

}
