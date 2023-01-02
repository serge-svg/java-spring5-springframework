package com.svg.java.spring.springjdbc.transactions;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InvoiceRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Invoice> getAll() {
        String sql = "SELECT * FROM invoices";
        return template.query(sql, new BeanPropertyRowMapper<Invoice>(Invoice.class));
    }

    @Transactional
    public void insert(Invoice invoice) {
        String sql = "INSERT INTO invoices(number, concept, amount) VALUES(?,?,?)";
        template.update(sql, invoice.getNumber(), invoice.getConcept(), invoice.getAmount());
    }

    @Transactional
    public void update(Invoice invoice) {
        String sql = "UPDATE invoices SET concept=?, amount=? WHERE number=?";
        template.update(sql, invoice.getConcept(), invoice.getAmount(), invoice.getNumber());
    }

    @Transactional
    public void delete(Invoice invoice) {
        String sql = "DELETE FROM invoices WHERE number=?";
        template.update(sql, invoice.getNumber());
    }

    @Transactional
    public void deleteAll() {
        String sql = "DELETE FROM invoices";
        template.execute(sql);
    }


}
