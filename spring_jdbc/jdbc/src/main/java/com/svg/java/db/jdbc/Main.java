package com.svg.java.db.jdbc;

import java.sql.SQLException;
import java.util.List;

public class Main {
    static InvoiceRepository invoiceRepository = new InvoiceRepository();
    public static void main(String[] args) throws SQLException {
        //invoiceRepository.insert(new Invoice(1002, "Computer", 1000.0));
        printInvoices();
    }

    private static void printInvoices() throws SQLException {
        List<Invoice> invoices = invoiceRepository.getAll();
        for (Invoice invoice : invoices){
            System.out.printf("Number: %s, Concept: %s, Amount: %s%n", invoice.getNumber(), invoice.getConcept(), invoice.getAmount());
        }        
    }
}
