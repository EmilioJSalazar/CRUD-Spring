package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

	public Rol findBynombre(String nombre);
}
