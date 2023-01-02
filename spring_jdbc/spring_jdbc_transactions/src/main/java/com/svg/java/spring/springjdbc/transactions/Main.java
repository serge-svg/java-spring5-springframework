package com.svg.java.spring.springjdbc.transactions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
 
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurator.class);
        InvoiceService invoiceService = context.getBean(InvoiceService.class);
        printInvoices(invoiceService.getAll());
        /*
        Invoice invoice1001 =  new Invoice(1003, "computer", 3000.0);
        Invoice invoice1002 =  new Invoice(1002, "screen", 100.0);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice1001);
        invoices.add(invoice1002);       
        invoiceService.insertAListOfInvoice(invoices);
                        
        printInvoices(invoiceService.getAll());
        */
    }

    private static void printInvoices(List<Invoice> invoices) {
        System.out.println("***************************");
        for (Invoice invoice : invoices){
            System.out.printf("Number: %s, Concept: %s, Amount: %s%n", invoice.getNumber(), invoice.getConcept(), invoice.getAmount());
        }
        System.out.println("***************************");            
    }


}
