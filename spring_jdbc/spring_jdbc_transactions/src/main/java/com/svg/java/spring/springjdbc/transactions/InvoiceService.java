package com.svg.java.spring.springjdbc.transactions;

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

    @Transactional
    public void insertAListOfInvoice(List<Invoice> invoices) {
        for(Invoice invoice : invoices){
            invoiceRepository.insert(invoice);
        }

    }

    @Transactional
    public void insertInvoices(Invoice invoice1, Invoice invoice2) {
        invoiceRepository.insert(invoice1);
        invoiceRepository.insert(invoice2);
    }
    
}
