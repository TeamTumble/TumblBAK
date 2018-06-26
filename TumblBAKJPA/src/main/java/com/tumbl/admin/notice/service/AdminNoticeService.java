package com.tumbl.admin.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.admin.notice.repository.AdminNoticeRepository;
import com.tumbl.admin.notice.vo.NoticeVO;
import com.tumbl.client.member.vo.Member;
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
	
	
	public Page<NoticeVO> findByNtitleContaining(String ntitle, PageRequest pageRequest) {

		return adminNoticeRepository.findByNtitleContaining(ntitle,pageRequest);
	
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
		System.out.println("������ ���� -=-=-=-=-=-=-=-=" + detail);

		return detail;

	}

	// �ۼ��� ����
	public NoticeVO noticeUpdate(NoticeVO nvo) {

		adminNoticeRepository.save(nvo);

		return nvo;

	}

	// �ۻ��� ����
	public int noticeDelete(int nno) {
		try {

			adminNoticeRepository.delete(nno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nno;

	}

}