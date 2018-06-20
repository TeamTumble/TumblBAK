package com.tumbl.client.support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.support.repository.SupportRepository;
import com.tumbl.client.support.vo.SupportVO;

@Service
public class SupportService {
	
	@Autowired
	SupportRepository supportRepository;
	@Autowired
	ProjectRepository projectRepsoitory;
	
	
	public SupportVO supportInsert(SupportVO svo) {
		
		SupportVO svoi =supportRepository.save(svo);

		
		return svoi;
	}
	
	
	public void supportInsertPlus(SupportVO svo) {
		SupportVO svoi = new SupportVO();
		ProjectVO pvo = new ProjectVO();
		String email = svo.getEmail();
		int pno = svo.getPno();
		svoi = supportRepository.findByEmailAndPno(email, pno);
		pvo = projectRepsoitory.findByPno(pno);
		pvo.setP_collection(svoi.getS_price());
		pvo.setP_supporter(svoi.getS_supporter());
		projectRepsoitory.save(pvo);
		
	}

	
	
	
	public SupportVO supportDetail(SupportVO svo) {
		SupportVO detail = new SupportVO();
		ProjectVO pvo = new ProjectVO();
		int pnum = svo.getPno();
		pvo = projectRepsoitory.findOne(pnum);
		detail.setPno(pnum);
		detail.setEmail(pvo.getEmail());
		detail.setP_giftname(pvo.getP_giftname());
		detail.setP_giftprice(pvo.getP_giftprice());
		return detail;
		
	}

	
	public SupportVO supportSuccess(SupportVO svo) {
		SupportVO detail = new SupportVO();
		detail = supportRepository.findOne(svo.getPno());
		System.out.println("후원성공   =====  " +detail);
		return detail;
	}

}
