package com.svg.java.spring.mvc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InvoiceRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Invoice> getAll() {
		TypedQuery<Invoice> queryJPA = em.createQuery("SELECT i FROM Invoice i ORDER BY i.number", Invoice.class);
		return queryJPA.getResultList();
    }
	
    public Invoice find(int number) {		
		return em.find(Invoice.class, number);
    }

    @Transactional
    @Secured({"administrator"})
    public void delete(Invoice invoice) {
        em.remove(em.merge(invoice));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Invoice invoice) {
        em.persist(invoice);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Secured({"administrator", "advance"})
    public void update(Invoice invoice) {
        em.merge(invoice);
    }

    @Transactional
    @Secured({"administrator"})
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM Invoice");        
		int result = query.executeUpdate();
        if (result > 0) {
            System.out.println("All record removed");
        }
    }

}
