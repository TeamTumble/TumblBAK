package com.tumbl.client.project.repository;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.client.project.vo.ProjectVO;

public interface ProjectRepository extends JpaRepository<ProjectVO, Integer> {
	
	/*public List<ProjectVO> findOneByOrderByDesc(ProjectVO pvo);*/
	public ProjectVO findByPno(int pno);
	public List<ProjectVO> findByEmail(String email);
	List<ProjectVO> findTop3ByPsupporter(int psupporter, Pageable pageable);
	
	
}
