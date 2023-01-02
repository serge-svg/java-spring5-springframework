package com.svg.java.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {
    
    @Autowired
    InvoiceRepository invoiceRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }

    public Invoice find(int number) {
        return invoiceRepository.find(number);
    }

    @Transactional
    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    @Transactional
    public void insert(Invoice invoice) {
        invoiceRepository.insert(invoice);
    }

    @Transactional
    public void insertAll(List<Invoice> invoices) {
        for(Invoice invoice : invoices){
            System.out.println(invoice.getNumber());
            invoiceRepository.insert(invoice);
        }
    }

    @Transactional
    public void update(Invoice invoice) {
        invoiceRepository.update(invoice);
    }

    @Transactional
    public void deleteAll() {
        invoiceRepository.deleteAll();
    }
}
