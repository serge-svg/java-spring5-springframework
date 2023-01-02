package com.svg.java.spring.springjdbc.beanmapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InvoiceRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Invoice> getAll() throws SQLException {
        String sql = "SELECT * FROM invoices";
        return template.query(sql, new BeanPropertyRowMapper<Invoice>(Invoice.class));
    }

    public void insert(Invoice invoice) throws Exception {
        String sql = "INSERT INTO invoices(number, concept, amount) VALUES(?,?,?)";
        template.update(sql, invoice.getNumber(), invoice.getConcept(), invoice.getAmount());
    }

    public void update(Invoice invoice) throws Exception {
        String sql = "UPDATE invoices SET concept=?, amount=? WHERE number=?";
        template.update(sql, invoice.getConcept(), invoice.getAmount(), invoice.getNumber());
    }

    public void delete(Invoice invoice) throws Exception {
        String sql = "DELETE FROM invoices WHERE number=?";
        template.update(sql, invoice.getNumber());
    }

    public void deleteAll() throws Exception {
        String sql = "DELETE FROM invoices";
        template.execute(sql);
    }


}
