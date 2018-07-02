package com.tumbl.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.admin.repository.AdminNoticeRepository;
import com.tumbl.admin.vo.NoticeVO;

@Service
public class NoticeService {

   @Resource
   AdminNoticeRepository adminNoticeRepository;

   // 글목록 구현
   public List<NoticeVO> noticeList(NoticeVO nvo) {
      List<NoticeVO> myList = null;

      myList = adminNoticeRepository.findAll();
      return myList;
   }
   
   // 전체 레코드 수 구현
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

   // 글상세 구현
   public NoticeVO noticeDetail(NoticeVO nvo) {
      NoticeVO detail = null;
      detail = adminNoticeRepository.findOne(nvo.getNno());
      System.out.println("디테일 서비스 -=-=-=-=-=-=-=-=" + detail);

      return detail;

   }

   /*
    * public int noticeListCnt(NoticeVO nvo); // 전체 레코드 수 구현
    * 
    * 
    */

}