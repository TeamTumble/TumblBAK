package com.tumbl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.user.vo.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

}
