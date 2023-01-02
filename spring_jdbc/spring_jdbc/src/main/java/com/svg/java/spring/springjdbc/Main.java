package com.svg.java.spring.springjdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
 
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurator.class);

        try {
            InvoiceRepository invoiceRepository = context.getBean(InvoiceRepository.class);
            List<Invoice> invoices = invoiceRepository.getAll();
            for (Invoice invoice : invoices){
                System.out.printf("Number: %s, Concept: %s, Amount: %s%n", invoice.getNumber(), invoice.getConcept(), invoice.getAmount());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
