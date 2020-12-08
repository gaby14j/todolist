package com.todolist.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todolist.demo.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	 @Query(value = "SELECT U FROM Usuario U WHERE (U.username = :username  AND U.password = :password)", nativeQuery = false)  
	 public Usuario obtenerUsuario(@Param(value = "username") String username, @Param(value = "password") String password);

}
