package com.tumbl.client.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.client.login.vo.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

}
