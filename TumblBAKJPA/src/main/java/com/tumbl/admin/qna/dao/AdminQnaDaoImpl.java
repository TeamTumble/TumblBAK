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

	// �� ��� ����
	@Override
	public List<QnaVO> qnaList(QnaVO qvo) {
		return session.selectList("", qvo);
	}

	// ��ü ���ڵ� �Ǽ� ����
	@Override
	public int qnaListCnt(QnaVO qvo) {
		return (Integer) session.selectOne("qnaListCnt");
	}

	// ���Է� ����
	@Override
	public int qnaInsert(QnaVO qvo) {
		return session.insert("qnaInsert", qvo);
	}

	// �� �� ����
	@Override
	public QnaVO qnaDetail(QnaVO qvo) {
		return (QnaVO) session.selectOne("qnaDetail", qvo);
	}

	// ��й�ȣ Ȯ�� ����
	@Override
	public int pwdConfirm(QnaVO qvo) {
		return (Integer) session.selectOne("pwdConfirm", qvo);
	}

	// �� ���� ����
	@Override
	public int qnaUpdate(QnaVO qvo) {
		return session.update("qnaUpdate", qvo);
	}

	// �� ��������
	@Override
	public int qnaDelete(int q_num) {
		return session.delete("qnaDelete", q_num);
	}

}
*/