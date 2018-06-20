/*package com.tumbl.client.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.qna.vo.QnaVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession session;

	// 글 목록 구현
	@Override
	public List<QnaVO> boardList(QnaVO bvo) {
		return session.selectList("", bvo);
	}
	//전체 레코드 건수 구현
	@Override
	public int boardListCnt(QnaVO bvo) {
		return (Integer) session.selectOne("boardListCnt");
	}

	// 글 상세 구현
	@Override
	public QnaVO boardDetail(QnaVO bvo) {
		return (QnaVO) session.selectOne("boardDetail", bvo);
	}

	// 글입력 구현
	@Override
	public int boardInsert(QnaVO bvo) {
		return session.insert("boardInsert", bvo);

	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(QnaVO bvo) {
		return (Integer) session.selectOne("pwdConfirm", bvo);
	}

	// 글 수정 구현
	@Override
	public int boardUpdate(QnaVO bvo) {
		return session.update("boardUpdate", bvo);
	}

	// 글 삭제구현
	@Override
	public int boardDelete(int q_num) {
		return session.delete("boardDelete", q_num);
	}

}
*/