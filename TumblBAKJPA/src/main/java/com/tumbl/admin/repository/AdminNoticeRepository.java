package com.tumbl.admin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.admin.vo.NoticeVO;

public interface AdminNoticeRepository extends JpaRepository<NoticeVO, Integer> {

	int findByNno(int nno);
	
	int countByNno(int nno);
	
	Page<NoticeVO> findByNno (int nno, Pageable pageable);
	
	Page<NoticeVO> findByNtitleContaining(String ntitle, Pageable pageable);
	
	
	
}
