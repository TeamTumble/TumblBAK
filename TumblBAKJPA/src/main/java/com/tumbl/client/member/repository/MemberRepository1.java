package com.tumbl.client.member.repository;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.tumbl.client.member.vo.Member;


@Repository
public class MemberRepository1 {

    @PersistenceContext
    private EntityManager em;

    
    public void save(Member mvo) {
    	
    	System.out.println("Repository  " + mvo);
    	
        em.persist(mvo);
        
  
    }

    public Member findOne(String email) {
        return em.find(Member.class, email);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }
}
