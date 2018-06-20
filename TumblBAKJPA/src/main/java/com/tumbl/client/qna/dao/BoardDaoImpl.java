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

	// �� ��� ����
	@Override
	public List<QnaVO> boardList(QnaVO bvo) {
		return session.selectList("", bvo);
	}
	//��ü ���ڵ� �Ǽ� ����
	@Override
	public int boardListCnt(QnaVO bvo) {
		return (Integer) session.selectOne("boardListCnt");
	}

	// �� �� ����
	@Override
	public QnaVO boardDetail(QnaVO bvo) {
		return (QnaVO) session.selectOne("boardDetail", bvo);
	}

	// ���Է� ����
	@Override
	public int boardInsert(QnaVO bvo) {
		return session.insert("boardInsert", bvo);

	}

	// ��й�ȣ Ȯ�� ����
	@Override
	public int pwdConfirm(QnaVO bvo) {
		return (Integer) session.selectOne("pwdConfirm", bvo);
	}

	// �� ���� ����
	@Override
	public int boardUpdate(QnaVO bvo) {
		return session.update("boardUpdate", bvo);
	}

	// �� ��������
	@Override
	public int boardDelete(int q_num) {
		return session.delete("boardDelete", q_num);
	}

}
*/