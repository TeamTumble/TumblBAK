/*package com.tumbl.admin.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.qna.vo.QnaVO;

@Repository
public class AdminQnaDaoImpl implements AdminQnaDao {

	@Autowired
	private SqlSession session;

	// 글 목록 구현
	@Override
	public List<QnaVO> qnaList(QnaVO qvo) {
		return session.selectList("", qvo);
	}

	// 전체 레코드 건수 구현
	@Override
	public int qnaListCnt(QnaVO qvo) {
		return (Integer) session.selectOne("qnaListCnt");
	}

	// 글입력 구현
	@Override
	public int qnaInsert(QnaVO qvo) {
		return session.insert("qnaInsert", qvo);
	}

	// 글 상세 구현
	@Override
	public QnaVO qnaDetail(QnaVO qvo) {
		return (QnaVO) session.selectOne("qnaDetail", qvo);
	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(QnaVO qvo) {
		return (Integer) session.selectOne("pwdConfirm", qvo);
	}

	// 글 수정 구현
	@Override
	public int qnaUpdate(QnaVO qvo) {
		return session.update("qnaUpdate", qvo);
	}

	// 글 삭제구현
	@Override
	public int qnaDelete(int q_num) {
		return session.delete("qnaDelete", q_num);
	}

}
*/