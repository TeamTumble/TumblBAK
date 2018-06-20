/*package com.tumbl.client.support.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.support.dao.SupportDAO;
import com.tumbl.client.support.vo.SupportVO;


@Service
@Transactional
public class SupportServiceImpl implements SupportService {
	Logger logger = Logger.getLogger(SupportServiceImpl.class);

	@Autowired
	private SupportDAO supportDAO;

	@Override
	public int supportInsert(SupportVO svo) {
		int result = 0;
		try {
			result = supportDAO.supportInsert(svo);

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	@Override
	public int supportInsertPlus(SupportVO svo) {
		int result = 0;
		try {
			result = supportDAO.supportInsertPlus(svo);

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	
	
	@Override
	public SupportVO supportDetail(SupportVO svo) {
		SupportVO detail = null;
		detail = supportDAO.supportDetail(svo);
		return detail;
		
	}

	@Override
	public SupportVO supportSuccess(SupportVO svo) {
		SupportVO detail = null;
		detail = supportDAO.supportSuccess(svo);
		return detail;
	}
}
*/