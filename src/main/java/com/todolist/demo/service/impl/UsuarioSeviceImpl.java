package com.todolist.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.demo.entity.Usuario;
import com.todolist.demo.repository.UsuarioRepository;
import com.todolist.demo.service.UsuarioService;
@Service
public class UsuarioSeviceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public boolean obtenerUsuario(Usuario usuario) {
		Usuario user= usuarioRepository.obtenerUsuario(usuario.getUsername(), usuario.getPassword());
		if (user==null) {
			return false;
		}
		return true;
	}
	
	@Override
	public Usuario inscribirUsuario(Usuario usuario) {
		Usuario usuarioCreado=new Usuario();
		if (!this.obtenerUsuario(usuario)) {
			usuarioCreado=usuarioRepository.save(usuario);
		}

		return usuarioCreado;
	}

	@Override
	public boolean loginUsuario(Usuario usuario) {
		if (this.obtenerUsuario(usuario)) {
			return true;
		}
		return false;
	}

}
