package com.tumbl.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.user.repository.SupportRepository;
import com.tumbl.user.vo.SupportVO;

@Service
public class AdminSupportService {

	@Resource
	SupportRepository supportRepository;

	// �۸�� ����
	public List<SupportVO> supportList(SupportVO svo) {
		return supportRepository.findAll();
		
	}

	// ��ü ���ڵ� �� ����
	public long supportListCnt(SupportVO svo) {
		return supportRepository.countBySno(svo);

	}

	public long countAdminSupport(SupportVO svo) {
		List<SupportVO> myList = null;
		
		myList = supportRepository.findAll();
		long palc = supportRepository.count();
		
		return palc;
	}

	public Page<SupportVO> findAll(Pageable pageable) {
		return supportRepository.findAll(pageable);
	}
	
	public Page<SupportVO> findBySnameContaining(String sname, PageRequest pageRequest) {

		return supportRepository.findBySnameContaining(sname,pageRequest);
	}
	

	/*
	 * // ���Է� ���� public int supportInsert(SupportVO svo);
	 * 
	 * // �ۻ� ���� public SupportVO supportDetail(SupportVO svo);
	 * 
	 * // �ۼ��� ���� public int supportUpdate(SupportVO svo);
	 * 
	 * // �ۻ��� ���� public int supportDelete(int s_no);
	 */
}
