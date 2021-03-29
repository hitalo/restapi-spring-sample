package com.hit.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hit.springrest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
