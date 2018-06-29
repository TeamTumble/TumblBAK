package com.tumbl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.user.vo.LoginHistory;


public interface LoginHistoryRepository extends JpaRepository<LoginHistory, String> {

	

}