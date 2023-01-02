package com.svg.java.spring.springjdbc.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InvoiceRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Invoice> getAll() throws SQLException {
        String sql = "SELECT * FROM invoices";
        return template.query(sql, new InvoiceRowMapper());
    }

    public void insert(Invoice invoice) throws Exception {
        String sql = "INSERT INTO invoices(number, concept, amount) VALUES(?,?,?)";
        template.update(sql, invoice.getNumber(), invoice.getConcept(), invoice.getAmount());

    }

}
