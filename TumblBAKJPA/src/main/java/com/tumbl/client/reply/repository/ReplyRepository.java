package com.tumbl.client.reply.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.client.reply.vo.ReplyVO;

public interface ReplyRepository extends JpaRepository<ReplyVO, Integer> {
	List<ReplyVO> findByQnum(int qnum);

}
