package com.tumbl.admin.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.admin.notice.repository.AdminNoticeRepository;
import com.tumbl.admin.notice.vo.NoticeVO;
import com.tumbl.client.qna.vo.QnaVO;

@Service
public class AdminNoticeService {

	@Resource
	AdminNoticeRepository adminNoticeRepository;

	// �۸�� ����
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		List<NoticeVO> myList = null;

		myList = adminNoticeRepository.findAll();
		return myList;
	}

	// ��ü ���ڵ� �� ����
	public int noticeCnt(int nno) {
		return adminNoticeRepository.countByNno(nno);
	}

	public long countNotice(NoticeVO nvo) {
		List<NoticeVO> myList = null;
		myList = adminNoticeRepository.findAll();
		long nlc = adminNoticeRepository.count();
		return nlc;
	}
	
	public Page<NoticeVO> findAll(Pageable pageable) {
		return adminNoticeRepository.findAll(pageable);
	}

	// ���Է� ����
	public NoticeVO noticeInsert(NoticeVO nvo) {

		try {
			adminNoticeRepository.save(nvo);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return nvo;
	}

	// �ۻ� ����
	 public NoticeVO noticeDetail(NoticeVO nvo) {
		 NoticeVO detail = null;
		 detail = adminNoticeRepository.findOne(nvo.getNno());
		 System.out.println("������ ���� -=-=-=-=-=-=-=-="+ detail);
		 
		 return detail;
		 
	 }
	 
	/*
	 * public int noticeUpdate(NoticeVO nvo);// �ۼ��� ����
	 * 
	 * public int noticeDelete(int n_no);// �ۻ��� ����
	 */
}