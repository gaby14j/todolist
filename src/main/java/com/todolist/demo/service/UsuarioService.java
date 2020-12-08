package com.todolist.demo.service;

import com.todolist.demo.entity.Usuario;

public interface UsuarioService {
	Usuario inscribirUsuario(Usuario usuario);
	
	boolean loginUsuario(Usuario usuario);
}
