/*package com.tumbl.admin.support.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.support.dao.AdminSupportDao;
import com.tumbl.client.support.vo.SupportVO;

@Service
@Transactional
public class AdminSupportServiceImpl implements AdminSupportService {
	Logger logger = Logger.getLogger(AdminSupportServiceImpl.class);
	@Autowired
	private AdminSupportDao adminSupportDao;

	// 글목록 구현
	@Override
	public List<SupportVO> supportList(SupportVO svo) {
		List<SupportVO> myList = null;

		// 정렬에 대한 기본값 설정
		if (svo.getOrder_by() == null) {
			svo.setOrder_by("s_no");
		}
		if (svo.getOrder_sc() == null) {
			svo.setOrder_sc("DESC");
		}

		myList = adminSupportDao.supportList(svo);
		return myList;
	}

	// 전체 레코드 수 구현
	@Override
	public int supportListCnt(SupportVO svo) {
		return adminSupportDao.supportListCnt(svo);
	}

	// 글입력 구현
	@Override
	public int supportInsert(SupportVO svo) {
		int result = 0;
		try {
			result = adminSupportDao.supportInsert(svo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글상세 구현
	@Override
	public SupportVO supportDetail(SupportVO svo) {
		SupportVO detail = null;
		detail = adminSupportDao.supportDetail(svo);
		return detail;
	}

	// 글수정 구현
	@Override
	public int supportUpdate(SupportVO svo) {
		int result = 0;
		try {
			result = adminSupportDao.supportUpdate(svo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글삭제 구현
	@Override
	public int supportDelete(int s_no) {
		int result = 0;
		try {
			result = adminSupportDao.supportDelete(s_no);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


}
*/