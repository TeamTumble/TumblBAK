package com.tumbl.user.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.user.vo.ProjectVO;

public interface ProjectRepository extends JpaRepository<ProjectVO, Integer> {

	public ProjectVO findByPno(int pno);

	public List<ProjectVO> findByEmail(String email);

	List<ProjectVO> findTop3ByPsupporter(int psupporter, Pageable pageable);

	public int countByPno(ProjectVO pvo);

	int countByPno(int pno);

	Page<ProjectVO> findByPno(int pno, Pageable pageable);

	Page<ProjectVO> findByPtitleContaining(String ptitle, Pageable pageable);

	Page<ProjectVO> findByPcaseLike(String pcase, Pageable pageable);

	Page<ProjectVO> findByPmnameContaining(String pmname, Pageable pageable);

}


