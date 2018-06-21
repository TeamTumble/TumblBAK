package com.tumbl.admin.notice.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.admin.notice.vo.NoticeVO;

public interface AdminNoticeRepository extends JpaRepository<NoticeVO, Integer> {

	int findByNno(int nno);
	
	int countByNno(int nno);
	
	Page<NoticeVO> findByNno (int nno, Pageable pageable);
	
	
	
}
