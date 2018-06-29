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

	// 글목록 구현
	public List<SupportVO> supportList(SupportVO svo) {
		return supportRepository.findAll();
		
	}

	// 전체 레코드 수 구현
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
	 * // 글입력 구현 public int supportInsert(SupportVO svo);
	 * 
	 * // 글상세 구현 public SupportVO supportDetail(SupportVO svo);
	 * 
	 * // 글수정 구현 public int supportUpdate(SupportVO svo);
	 * 
	 * // 글삭제 구현 public int supportDelete(int s_no);
	 */
}
