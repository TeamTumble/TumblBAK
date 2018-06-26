package com.tumbl.client.support.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.support.repository.SupportRepository;
import com.tumbl.client.support.vo.SupportVO;

@Service
public class SupportService {

	@Resource
	SupportRepository supportRepository;
	@Resource
	ProjectRepository projectRepsoitory;

	public SupportVO supportInsert(SupportVO svo) {

		return supportRepository.save(svo);
	}

	public void supportInsertPlus(SupportVO svo) {
		SupportVO svoi = new SupportVO();
		ProjectVO pvo = new ProjectVO();
		String email = svo.getEmail();
		int pno = svo.getPno();
		svoi = supportRepository.findByEmailAndPno(email, pno);
		pvo = projectRepsoitory.findByPno(svo.getPno());
		System.out.println("서포터 인서트 플러스  PVO ===  " + pvo);
		int pvoP = pvo.getPcollection()+svoi.getS_price();
		int pvoO = pvo.getPsupporter()+svoi.getS_supporter();
		
		pvo.setPcollection(pvoP);
		pvo.setPsupporter(pvoO);
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
		detail.setPtitle(pvo.getPtitle());
		return detail;

	}

	public SupportVO supportSuccess(SupportVO svo) {
		SupportVO detail = null;
		detail = supportRepository.findOne(svo.getSno());
		System.out.println("후원성공   =====  " + detail);
		return detail;
	}

}
