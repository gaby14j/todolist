package com.todolist.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.demo.entity.Tarea;
import com.todolist.demo.entity.Usuario;
import com.todolist.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
  
	@Autowired 
	private UsuarioService usuarioService;
  
  
	@PostMapping("/inscribir-usuario")
	public ResponseEntity<Usuario> inscribirUsuario(@RequestBody Usuario usuario) {  
		ResponseEntity<Usuario> responseUser=null;
		Usuario usuarioCreado=new Usuario();
	   try {
		   usuarioCreado=usuarioService.inscribirUsuario(usuario);
		
		   if (usuarioCreado!=null) {
			   responseUser= new ResponseEntity<>(usuario,HttpStatus.CREATED);
		   }
		 
	   }catch(Exception e) {
		   e.printStackTrace();
		   responseUser= new ResponseEntity<>(usuario,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   return responseUser;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUsuario(@RequestBody Usuario usuario) {  
		ResponseEntity<Boolean> responseUsuario=null;
		boolean usuarioEncontrado=false;
	   try {
		   usuarioEncontrado=usuarioService.loginUsuario(usuario);
		
		   if (usuarioEncontrado) {
			   responseUsuario= new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
		   }else   
			   responseUsuario= new ResponseEntity<>(usuarioEncontrado,HttpStatus.UNAUTHORIZED);
		 
	   }catch(Exception e) {
		
		   e.printStackTrace();
		   responseUsuario= new ResponseEntity<>(usuarioEncontrado,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   return responseUsuario;
	}
}
