package com.tumbl.client.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tumbl.client.login.vo.LoginHistory;


public interface LoginHistoryRepository extends JpaRepository<LoginHistory, String> {

	

}