package com.tumbl.client.qna.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tumbl.client.qna.vo.QnaVO;

public interface BoardRepository extends JpaRepository<QnaVO, Long> {

	long findByQnum(long qnum);

	Page<QnaVO> findByQnum(int qnum, Pageable pageable);

	int countByQnum(int qnum);

	Page<QnaVO> findByEmailContaining(String email, Pageable pageable);

	Page<QnaVO> findByQtitleContaining(String qtitle, Pageable pageable);

}
