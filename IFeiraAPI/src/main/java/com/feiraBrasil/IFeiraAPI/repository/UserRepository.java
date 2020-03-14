package com.feiraBrasil.IFeiraAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feiraBrasil.IFeiraAPI.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsuario(String usuario);
}
