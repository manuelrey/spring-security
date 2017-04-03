package com.manuelrey.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manuelrey.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select p from Client p where p.first_name like :x")
	public Page<Client> search(@Param("x")String se, Pageable pageable);

}
