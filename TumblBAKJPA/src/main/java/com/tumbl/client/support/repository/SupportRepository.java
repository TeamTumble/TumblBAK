package com.tumbl.client.support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.client.support.vo.SupportVO;

public interface SupportRepository extends JpaRepository<SupportVO, Integer> {
	SupportVO findByEmailAndPno(String email, int pno);
	SupportVO findByPno(int pno);
	public List<SupportVO> findByEmail(String email);

}
