package com.tumbl.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.user.vo.QnaVO;

public interface BoardRepository extends JpaRepository<QnaVO, Long> {

	long findByQnum(long qnum);

	Page<QnaVO> findByQnum(int qnum, Pageable pageable);

	int countByQnum(int qnum);

	Page<QnaVO> findByEmailContaining(String email, Pageable pageable);

	Page<QnaVO> findByQtitleContaining(String qtitle, Pageable pageable);

}
