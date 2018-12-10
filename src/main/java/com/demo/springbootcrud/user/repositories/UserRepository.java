package com.demo.springbootcrud.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootcrud.user.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
