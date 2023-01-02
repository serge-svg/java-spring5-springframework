package com.svg.java.spring.springjdbc.beanmapper;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
 
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurator.class);

        try {
            InvoiceRepository invoiceRepository = context.getBean(InvoiceRepository.class);            
            invoiceRepository.deleteAll();
            printInvoices(invoiceRepository.getAll());

            Invoice invoice1001 =  new Invoice(1001, "computer", 1000.0);
            Invoice invoice1002 =  new Invoice(1002, "screen", 100.0);
            invoiceRepository.insert(invoice1001);
            invoiceRepository.insert(invoice1002);
            printInvoices(invoiceRepository.getAll());

            invoice1002.setAmount(200.0);
            invoiceRepository.update(invoice1002);
            printInvoices(invoiceRepository.getAll());

            invoiceRepository.delete(invoice1002);
            printInvoices(invoiceRepository.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void printInvoices(List<Invoice> invoices) {
        System.out.println("***************************");
        for (Invoice invoice : invoices){
            System.out.printf("Number: %s, Concept: %s, Amount: %s%n", invoice.getNumber(), invoice.getConcept(), invoice.getAmount());
        }
        System.out.println("***************************");            
    }


}
